package bank.com.model.transferhistory

import android.content.SharedPreferences
import bank.com.model.api.DigitalAccountApi
import bank.com.shared.constants.PreferencesKeys
import io.reactivex.Observable

class TransfersHistoryModel(
    private val digitalAccountApi: DigitalAccountApi,
    private val preferences: SharedPreferences
) {
    fun getTransfers(): Observable<List<AccountReceiverResponse>> = digitalAccountApi.getTransfers(getToken())

    private fun getToken(): String? = preferences.getString(PreferencesKeys.TOKEN_KEY, "")
}