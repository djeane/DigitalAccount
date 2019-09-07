package bank.com.digitalaccount.sendmoney

import android.view.View
import bank.com.digitalaccount.base.OnItemSelected
import bank.com.digitalaccount.base.SelectableItem
import bank.com.digitalaccount.base.SelectableViewHolder
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import kotlinx.android.synthetic.main.item_user_account_transfer.view.*

class SendMoneyViewHolder(
    itemView: View, itemSelectedListener: OnItemSelected<AccountReceiverUIModel>
) : SelectableViewHolder<AccountReceiverUIModel>(itemView, itemSelectedListener) {

    override fun bind(selectableItem: SelectableItem<AccountReceiverUIModel>) {
        super.bind(selectableItem)
        itemView.tv_username_account_transfer.text = selectableItem.model.formattingUserName()
        itemView.tv_phone_account_transfer.text = selectableItem.model.formattingPhoneNumber()
    }

    override val selectAction = {}
    override val deselectAction = {}
}