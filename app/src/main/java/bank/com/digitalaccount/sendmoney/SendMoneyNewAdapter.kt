package bank.com.digitalaccount.sendmoney

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bank.com.digitalaccount.R
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_user_account_transfer.view.*

@SuppressLint("CheckResult")
class SendMoneyNewAdapter(
    private val context: Context,
    private val accounts: List<AccountReceiverUIModel>,
    private val publish: PublishSubject<Interaction>
) : RecyclerView.Adapter<SendMoneyNewAdapter.SendMoneyNewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SendMoneyNewViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user_account_transfer, parent, false))

    override fun onBindViewHolder(holder: SendMoneyNewViewHolder, position: Int) {
        accounts[position].let { holder.bind(it) }
    }

    override fun getItemCount() = accounts.size

    inner class SendMoneyNewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(account: AccountReceiverUIModel) {
            account.image?.let { itemView.sdv_image_user_account_transfer.setImageURI(it) }
            itemView.tv_username_account_transfer.text = account.formattingUserName()
            itemView.tv_phone_account_transfer.text = account.formattingPhoneNumber()
            imageTapped(account)
            itemTapped(account)
        }

        private fun imageTapped(account: AccountReceiverUIModel){
            itemView.sdv_image_user_account_transfer.clicks()
                .subscribe{
                    publish.onNext(Interaction.ImageTapped(account))
                }
        }

        private fun itemTapped(account: AccountReceiverUIModel){
            itemView.clicks().subscribe {
                publish.onNext(Interaction.ItemTapped(account))
            }
        }
    }

    sealed class Interaction {
        data class ImageTapped(val account: AccountReceiverUIModel) : Interaction()
        data class ItemTapped(val account: AccountReceiverUIModel) : Interaction()
    }
}