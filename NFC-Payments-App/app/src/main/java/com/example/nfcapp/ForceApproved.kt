package com.example.nfcapp

import java.security.SecureRandom

object ForceApproved {
    fun generateApprovedCryptogram(): ByteArray {
        val random = SecureRandom()
        val cryptogramData = ByteArray(8)
        random.nextBytes(cryptogramData)

        val tcFlag = byteArrayOf(0x9F.toByte(), 0x26.toByte(), 0x08.toByte())
        val issuerAuthData = byteArrayOf(0x9F.toByte(), 0x10.toByte(), 0x12, 0x01, 0x23, 0x45, 0x67, 0x89)

        return cryptogramData + tcFlag + issuerAuthData + byteArrayOf(0x90.toByte(), 0x00.toByte())
    }
}
