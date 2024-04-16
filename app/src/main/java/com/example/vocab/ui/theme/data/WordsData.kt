package com.example.vocab.ui.theme.data

import com.example.vocab.R
import com.example.vocab.ui.theme.ui.Vocab

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// Set with all the words for the Game
val allWords: Set<String> =
    setOf(
        "cheverlot",
        "cub",
        "ford",
        "jeep",
        "maclaren",
        "mercedes",
        "mitsubishi",
        "porsche",
        "tesla",
        "toyota"

    )
val vocab = listOf<Vocab>(
    Vocab(currentVocabWord = "cheverlot", image = R.drawable.cheverlot),
    Vocab(currentVocabWord = "cub", image = R.drawable.cub),
    Vocab(currentVocabWord = "ford", image = R.drawable.ford),
    Vocab(currentVocabWord = "maclaren", image = R.drawable.mclaren),
    Vocab(currentVocabWord = "mercedes", image = R.drawable.mercedes),
    Vocab(currentVocabWord = "mitsubishi", image = R.drawable.mitsubishi),
    Vocab(currentVocabWord = "porsche", image = R.drawable.porsche),
    Vocab(currentVocabWord = "tesla", image = R.drawable.tesla),
    Vocab(currentVocabWord = "toyota", image = R.drawable.toyota),
    Vocab(currentVocabWord = "jeep", image = R.drawable.jeep)
)