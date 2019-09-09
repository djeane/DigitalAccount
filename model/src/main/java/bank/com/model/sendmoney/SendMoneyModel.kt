package bank.com.model.sendmoney

import android.content.SharedPreferences
import bank.com.model.api.DigitalAccountApi
import bank.com.shared.constants.PreferencesKeys
import io.reactivex.Single

class SendMoneyModel(private val digitalAccountApi: DigitalAccountApi,
                     private val preferences: SharedPreferences
) {
    fun sendMoney(accountSenderRequest: AccountSenderRequest): Single<Boolean> =
        digitalAccountApi.sendMoney(accountSenderRequest)


    fun getToken(): String? = preferences.getString(PreferencesKeys.TOKEN_KEY, "")
}