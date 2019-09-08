package bank.com.viewmodel.transferhistory

import android.annotation.SuppressLint
import bank.com.model.transferhistory.TransfersHistoryModel
import bank.com.shared.extensions.applyIoToMainThread
import bank.com.shared.base.BaseViewModel
import io.reactivex.Observable

@SuppressLint("CheckResult")
class TransferHistoryViewModel(private val transfersHistoryModel: TransfersHistoryModel) : BaseViewModel() {

    fun getTransfers(): Observable<List<AccountTransferUiModel>> =
        transfersHistoryModel.getTransfers("cdc46d46cd6c")
            .applyIoToMainThread()
            .flatMap {
                val accounts = mutableListOf<AccountTransferUiModel>()
                it.forEach { accountsResponse ->
                    accounts.add(
                        AccountTransferUiModel(
                            amount = accountsResponse.valor,
                            id = accountsResponse.id,
                            clientId = accountsResponse.clienteId
                        )
                    )
                }
                Observable.just(accounts)
            }
}