package bank.com.model.home

import android.content.SharedPreferences
import bank.com.model.api.DigitalAccountApi
import bank.com.shared.constants.PreferencesKeys.TOKEN_KEY
import io.reactivex.Single

open class GenerateTokenModel(
    private val digitalAccountApi: DigitalAccountApi,
    private val preferences: SharedPreferences
) {
    //fun generateToken(name: String, email: String) = digitalAccountApi.generateToken(name, email)
    fun generateToken(name: String, email: String) = Single.just("someToken")

    fun saveToken(token: String) =
        preferences.edit()
            .putString(TOKEN_KEY, token)
            .apply()

}