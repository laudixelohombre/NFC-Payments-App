package com.example.nfcapp

import android.content.Context
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat

object BiometricAuth {
    fun authenticate(context: Context, onSuccess: () -> Unit) {
        val executor = ContextCompat.getMainExecutor(context)
        val biometricPrompt = BiometricPrompt(context as androidx.fragment.app.FragmentActivity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    onSuccess()
                }
            })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Potwierdź płatność")
            .setSubtitle("Użyj biometrii")
            .setNegativeButtonText("Anuluj")
            .build()

        biometricPrompt.authenticate(promptInfo)
    }
}
