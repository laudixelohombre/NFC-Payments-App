package com.example.nfcapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SelectCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_card)

        val listViewCards: ListView = findViewById(R.id.listViewCards)
        val btnConfirmCard: Button = findViewById(R.id.btnConfirmCard)

        val cards = listOf(CardManager.getStoredTrack2() ?: "Brak zapisanych kart")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, cards)
        listViewCards.adapter = adapter
        listViewCards.choiceMode = ListView.CHOICE_MODE_SINGLE

        btnConfirmCard.setOnClickListener {
            val selectedPosition = listViewCards.checkedItemPosition
            if (selectedPosition != ListView.INVALID_POSITION) {
                val selectedCard = cards[selectedPosition]
                Toast.makeText(this, "Wybrano kartę: $selectedCard", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Wybierz kartę", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
