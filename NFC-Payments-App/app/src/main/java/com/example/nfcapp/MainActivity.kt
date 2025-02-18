package com.example.nfcapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddCard: Button = findViewById(R.id.btnAddCard)
        val btnSelectCard: Button = findViewById(R.id.btnSelectCard)
        val btnPay: Button = findViewById(R.id.btnPay)

        // Przejście do ekranu dodawania karty
        btnAddCard.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            startActivity(intent)
        }

        // Przejście do ekranu wyboru karty
        btnSelectCard.setOnClickListener {
            val intent = Intent(this, SelectCardActivity::class.java)
            startActivity(intent)
        }

        // Wykonanie płatności NFC
        btnPay.setOnClickListener {
            BiometricAuth.authenticate(this) {
                startNfcPayment()
            }
        }
    }

    // Metoda do inicjalizacji płatności NFC
    private fun startNfcPayment() {
        val selectedCard = CardManager.getStoredTrack2()
        if (selectedCard != null) {
            NFCService().processCommandApdu(selectedCard.toByteArray(), null)
        }
    }
}

