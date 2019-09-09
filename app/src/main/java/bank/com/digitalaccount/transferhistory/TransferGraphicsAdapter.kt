package bank.com.digitalaccount.transferhistory

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
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
            if (account.image != null) {
                itemView.sdv_user_image.visibility = View.VISIBLE
                itemView.sdv_user_image.setImageURI(account.image)
            } else {
                getNameInitials(account.fistName, account.lastName)
            }
            itemView.tv_amount.text = "R$ ${account.amount}"
            setHeightOfBars(account)
        }

        private fun setHeightOfBars(account: AccountReceiverUIModel) {
            val newAmount = account.amount.toString().replace("[$,.]".toRegex(), "")
            val height = (newAmount.trim().toDouble() / 100).toInt()
            val params = LinearLayout.LayoutParams(10, height)
            itemView.view_graphic.layoutParams = params
        }

        private fun getNameInitials(firstName: String, lastName: String) {
            val firstInitial = firstName[0]
            val lastInitial = lastName[0]
            val initials = "$firstInitial$lastInitial".toUpperCase()
            with(itemView) {
                tv_username_letters.text = initials
                tv_username_letters.visibility = View.VISIBLE
                sdv_user_image.visibility = View.INVISIBLE
            }
        }
    }
}