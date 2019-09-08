package bank.com.model.transferhistory

import bank.com.model.api.DigitalAccountApi
import io.reactivex.Observable

class TransfersHistoryModel(private val digitalAccountApi: DigitalAccountApi) {
    fun getTransfers(token: String): Observable<List<AccountReceiverResponse>> = digitalAccountApi.getTransfers(token)
}