package bank.com.digitalaccount.transferhistory

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bank.com.digitalaccount.R
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import kotlinx.android.synthetic.main.item_individual_transfer.view.*

@SuppressLint("CheckResult")
class IndividualTransferAdapter(
    private val context: Context,
    private val accounts: List<AccountReceiverUIModel>
) : RecyclerView.Adapter<IndividualTransferAdapter.IndividualTransferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IndividualTransferViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_individual_transfer,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: IndividualTransferViewHolder, position: Int) {
        accounts[position].let { holder.bind(it) }
    }

    override fun getItemCount() = accounts.size

    inner class IndividualTransferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(account: AccountReceiverUIModel) {
            if (account.image != null) {
                itemView.sdv_image_user_individual_transfer.visibility = View.VISIBLE
                itemView.sdv_image_user_individual_transfer.setImageURI(account.image)
            } else {
                getNameInitials(account.fistName, account.lastName)
            }
            itemView.tv_username_individual_transfer.text = account.formattingUserName()
            itemView.tv_phone_individual_transfer.text = account.formattingPhoneNumber()
            itemView.tv_amount.text = account.amount.toString()
        }

        private fun getNameInitials(firstName: String, lastName: String) {
            val firstInitial = firstName[0]
            val lastInitial = lastName[0]
            val initials = "$firstInitial$lastInitial".toUpperCase()
            with(itemView) {
                tv_username_letters.text = initials
                tv_username_letters.visibility = View.VISIBLE
                sdv_image_user_individual_transfer.visibility = View.INVISIBLE
            }
        }
    }
}