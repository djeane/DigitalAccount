package bank.com.digitalaccount.sendmoney

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import bank.com.digitalaccount.R
import bank.com.shared.base.SelectableAdapter
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel

class SendMoneyAdapter(
    private val context: Context,
    list: List<AccountReceiverUIModel>
) : SelectableAdapter<AccountReceiverUIModel, SendMoneyViewHolder>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SendMoneyViewHolder(
            LayoutInflater
                .from(context)
                .inflate(R.layout.item_user_account_transfer, parent, false), this
        )

}