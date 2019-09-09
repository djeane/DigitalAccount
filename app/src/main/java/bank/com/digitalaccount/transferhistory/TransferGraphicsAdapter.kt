package bank.com.digitalaccount.transferhistory

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bank.com.digitalaccount.R
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import kotlinx.android.synthetic.main.item_tranfers_graphics.view.*

@SuppressLint("CheckResult")
class TransferGraphicsAdapter(
    private val context: Context,
    private val accounts: List<AccountReceiverUIModel>
) : RecyclerView.Adapter<TransferGraphicsAdapter.TransferGraphicsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TransferGraphicsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tranfers_graphics, parent, false))

    override fun onBindViewHolder(holder: TransferGraphicsViewHolder, position: Int) {
        accounts[position].let { holder.bind(it) }
    }

    override fun getItemCount() = accounts.size

    inner class TransferGraphicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(account: AccountReceiverUIModel) {
            account.image?.let { itemView.sdv_user_image.setImageURI(it) }
            itemView.tv_amount.text = account.amount.toString()
        }
    }
}