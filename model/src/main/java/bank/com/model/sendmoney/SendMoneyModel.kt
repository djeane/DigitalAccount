package bank.com.model.sendmoney

import bank.com.model.api.DigitalAccountApi
import io.reactivex.Single

class SendMoneyModel(private val digitalAccountApi: DigitalAccountApi) {
    fun sendMoney(accountSenderRequest: AccountSenderRequest): Single<Boolean> =
        digitalAccountApi.sendMoney(accountSenderRequest)
}