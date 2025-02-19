package com.example.nfcapp

import android.nfc.cardemulation.HostApduService
import android.os.Bundle

class NFCService : HostApduService() {
    override fun processCommandApdu(commandApdu: ByteArray, extras: Bundle?): ByteArray {
        return when {
            commandApdu.isSelectAidApdu() -> selectAidResponse()
            commandApdu.isGenerateAcApdu() -> ForceApproved.generateApprovedCryptogram()
            else -> byteArrayOf(0x6A.toByte(), 0x00.toByte())
        }
    }

    override fun onDeactivated(reason: Int) {}

    private fun selectAidResponse(): ByteArray {
        return byteArrayOf(0x90.toByte(), 0x00.toByte())
    }
}
