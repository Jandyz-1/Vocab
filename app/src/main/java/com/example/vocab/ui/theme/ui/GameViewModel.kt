package com.example.vocab.ui.theme.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.vocab.ui.theme.data.MAX_NO_OF_WORDS
import com.example.vocab.ui.theme.data.SCORE_INCREASE
import com.example.vocab.ui.theme.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState:StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    private val usedWord: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String

//    Hàm đưa trò chơi về ban đầu
    private fun resetGame() {
        usedWord.clear()
        _uiState.value = GameUiState(currentVocabWord = pickRandomAndShuffle())
    }

        init {
            resetGame()
    }

//    Hàm xáo trộn từ
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }


//    Hàm chọn ngẫu nhiên 1 từ và xáo trộn
     fun pickRandomAndShuffle(): String {
        currentWord = allWords.random()
        if (usedWord.contains(currentWord)) {
            currentWord = allWords.random()
        }
    return shuffleCurrentWord(currentWord)
    }


//  Hàm cập nhật từ đoán của người
    fun updateUserGuess(wordGuess: String) {
        userGuess = wordGuess
    }

    fun updateGameState(upDateScore: Int) {
//     Vòng cuối cùng của trò chơi
        if (usedWord.size == MAX_NO_OF_WORDS) {
                _uiState.update { currentState ->
                    currentState.copy(isGameOver = true, score = upDateScore, isGuessWordWrong = false)
                }
        }
        else {
//    Vòng bình thường của trò chơi
                _uiState.update { currentState ->
                    currentState.copy(
                        isGuessWordWrong = false,
                        currentVocabWord = pickRandomAndShuffle(),
                        score = upDateScore,
                        currentWordCount = _uiState.value.currentWordCount.inc()
                        )
                }
        }
        updateUserGuess("")

    }
//    Hàm bỏ qua từ không biết của User
    fun skipWord() {
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }

//    Hàm kiểm tra lựa chọn của User
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            val updatedScore = _uiState.value.score.or(SCORE_INCREASE)
            updateGameState(updatedScore)
        } else {
             _uiState.update { currentState -> currentState.copy(isGuessWordWrong = true) }
        }
    updateUserGuess("")
    }














}