package com.example.nfcapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val etCardNumber: EditText = findViewById(R.id.etCardNumber)
        val etExpiryDate: EditText = findViewById(R.id.etExpiryDate)
        val etCvv: EditText = findViewById(R.id.etCvv)
        val etTrack2: EditText = findViewById(R.id.etTrack2)
        val btnSaveCard: Button = findViewById(R.id.btnSaveCard)

        btnSaveCard.setOnClickListener {
            val track2Data = etTrack2.text.toString()
            if (track2Data.isNotEmpty()) {
                CardManager.addCard(track2Data)
                Toast.makeText(this, "Karta dodana!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Wprowadź Track 2", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
