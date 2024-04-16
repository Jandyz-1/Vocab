package com.example.vocab.ui.theme.ui

import androidx.annotation.DrawableRes

data class GameUiState(
    val currentVocabWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessWordWrong: Boolean = false,
    val isGameOver: Boolean = false,
)

data class Vocab(
    val currentVocabWord: String,
    @DrawableRes val image: Int,
)