@file:Suppress("UNUSED_EXPRESSION")

package com.example.vocab.ui.theme.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vocab.R


@Composable
fun GameScreen(gameViewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    dimensionResource(id = R.dimen.padding_tiny)
    dimensionResource(id = R.dimen.padiing_small)
    dimensionResource(id = R.dimen.padding_large)
    dimensionResource(id = R.dimen.padding_medium)


    val gameUiState by gameViewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                style = typography.headlineLarge)
            Spacer(modifier = Modifier.height(48.dp))
            LayoutVocab(score = gameUiState.score, num =  gameUiState.currentWordCount)
            Spacer(modifier = Modifier.height(30.dp))
            CurrentVocabBox(word = gameViewModel.pickRandomAndShuffle())
            Spacer(modifier = Modifier.height(20.dp))
            UserGuessBox(userGuess = gameViewModel.userGuess, score = gameUiState.score, onUserGuessChanged = {gameViewModel.updateUserGuess(it)}, onKeyboradDone = {gameViewModel.checkUserGuess()})
            Spacer(modifier = Modifier.height(30.dp))
            DoneButton()
            Spacer(modifier = Modifier.height(10.dp))
            SkipButton()
        }
}

@Composable
fun LayoutVocab(score: Int, num: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .size(320.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.jeep), contentDescription = null, modifier = Modifier.fillMaxSize())
        Box(modifier = Modifier.offset(145.dp,252.dp)) {
            ScoreBox(score = score)
        }
        Box(modifier = Modifier.offset(205.dp,35.dp)) {
            CountBox(num)
        }
    }
}

@Composable
fun ScoreBox(score: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .padding(1.dp)
            .width(144.dp)
            .height(42.dp)
            .background(Color(0xFF0DB870)),
    ) {
        Text(text = "Score: $score",
            style = typography.displaySmall,
            modifier = Modifier.align(Alignment.Center))
    }
}
@Composable
fun CountBox(num:  Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .padding(1.dp)
            .width(85.dp)
            .height(40.dp)
            .background(Color(0xFFB6B0B0)),
    ) {
        Text(text = "$num/10",
            style = typography.displaySmall,
            modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun CurrentVocabBox(word: String) {
    Card(modifier = Modifier
        .width(260.dp)
        .height(50.dp)
        .background(Color(0xFFFAF9F9)),
    )
    {
        Text(text = word, style = typography.bodySmall, modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun UserGuessBox(userGuess: String, score: Int, onUserGuessChanged: (String) -> Unit, onKeyboradDone: () -> Unit)  {
    val gameViewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    OutlinedTextField(
        value = userGuess, onValueChange = onUserGuessChanged,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = androidx.compose.ui.text.input.ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { onKeyboradDone() }),
        singleLine = true
        )

}



@Composable
fun DoneButton() {
    val gameViewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    val gameUiState by gameViewModel.uiState.collectAsState()
    Button(onClick =  {gameViewModel.checkUserGuess()},
        modifier = Modifier
            .width(330.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(color = Color(0xFF1C913D))
    ) {
        Text(text = "Done", style = typography.labelMedium, textAlign = TextAlign.Center)
    }
}
@Composable
fun SkipButton() {
    val gameViewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    Button(onClick =  {gameViewModel.skipWord()},
        modifier = Modifier
            .width(330.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Green)
    ) {
        Text(text = "Skip", style = typography.labelMedium, textAlign = TextAlign.Center)
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewScreen() {

}