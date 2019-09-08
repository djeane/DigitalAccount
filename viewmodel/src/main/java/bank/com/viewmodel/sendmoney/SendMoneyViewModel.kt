package bank.com.viewmodel.sendmoney

import bank.com.model.sendmoney.AccountSenderRequest
import bank.com.model.sendmoney.SendMoneyModel
import bank.com.shared.extensions.applyIoToMainThread
import bank.com.shared.base.BaseViewModel
import io.reactivex.Single


class SendMoneyViewModel(private val sendMoneyModel: SendMoneyModel) : BaseViewModel() {

    fun sendMoney(id: Int, amount: Double, token: String = "nkmdfmklfmkdmf"): Single<Boolean> =
        sendMoneyModel.sendMoney(AccountSenderRequest(clienteId = id, amount = amount, token = token))
            .applyIoToMainThread()
            .flatMap {
                Single.just(it)
            }

}