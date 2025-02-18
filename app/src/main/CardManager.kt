package com.example.nfcapp

object CardManager {
    private val cards = mutableListOf<String>()

    fun addCard(track2: String) {
        cards.add(track2)
    }

    fun getStoredTrack2(): String? {
        return cards.lastOrNull()
    }
}
