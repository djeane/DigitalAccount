package bank.com.model.transferhistory

import bank.com.model.api.DigitalAccountApi

class TransfersHistoryModel(private val digitalAccountApi: DigitalAccountApi) {
    fun getTransfers(token: String) = digitalAccountApi.getTransfers(token)
}