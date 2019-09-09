package bank.com.viewmodel.sendmoney

import bank.com.model.sendmoney.AccountSenderRequest
import bank.com.model.sendmoney.SendMoneyModel
import bank.com.shared.base.BaseViewModel
import bank.com.shared.constants.DataMocked.Companion.PERSONAL_ID
import bank.com.shared.extensions.applyIoToMainThread
import bank.com.shared.extensions.applyLoading
import io.reactivex.Single


class SendMoneyViewModel(private val sendMoneyModel: SendMoneyModel) : BaseViewModel() {

    fun sendMoney(id: Int = PERSONAL_ID, amount: Double): Single<Boolean> =
        sendMoneyModel.sendMoney(AccountSenderRequest(clienteId = id, amount = amount, token = getToken()))
            .applyIoToMainThread()
            .applyLoading(loadingSubject)
            .flatMap {
                Single.just(it)
            }

    private fun getToken(): String? = sendMoneyModel.getToken()

}