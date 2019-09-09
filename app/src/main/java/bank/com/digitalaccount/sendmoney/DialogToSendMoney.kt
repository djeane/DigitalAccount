package bank.com.digitalaccount.sendmoney

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import bank.com.digitalaccount.R
import bank.com.shared.views.MoneyTextWatcher
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import kotlinx.android.synthetic.main.dialog_send_money.*
import java.io.Serializable

@Suppress("UNCHECKED_CAST")
class DialogToSendMoney : DialogFragment() {

    private val account by lazy { arguments?.getSerializable(ACCOUNT_EXTRA) as AccountReceiverUIModel }
    private val function by lazy { arguments?.getSerializable(FUNCTION_EXTRA) as () -> Unit }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        layoutInflater.inflate(R.layout.dialog_send_money, root, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (account.image != null) {
            sp_user_image.visibility = View.VISIBLE
            account.image?.let { sp_user_image.setImageURI(it) }
        } else {
            getNameInitials(account.fistName, account.lastName)
        }
        tv_username.text = account.formattingUserName()
        et_amount.hint?.let { et_amount.setSelection(0) }
        tv_phone_number.text = account.formattingPhoneNumber()
        iv_close.setOnClickListener { this.dismiss() }
        button_send_money.setOnClickListener {
            if (et_amount.text.toString().isNotEmpty()) {
                val cleanString = et_amount.text.toString().replace("R", "").replace("[$,.]".toRegex(), "")
                (activity as SendMoneyActivity).amount = cleanString.trim().toDouble() / 100
                function()
            }
        }
        applyCurrencyMask()
    }

    private fun getNameInitials(firstName: String, lastName: String) {
        val firstInitial = firstName[0]
        val lastInitial = lastName[0]
        val initials = "$firstInitial$lastInitial".toUpperCase()
        tv_username_letters.text = initials
        tv_username_letters.visibility = View.VISIBLE
        sp_user_image.visibility = View.INVISIBLE
    }

    private fun applyCurrencyMask() {
        et_amount.addTextChangedListener(MoneyTextWatcher(et_amount))
    }

    companion object {
        const val ACCOUNT_EXTRA = "ACOUNT_EXTRA"
        const val FUNCTION_EXTRA = "FUNCTION_EXTRA"

        fun getInstance(account: AccountReceiverUIModel, function: () -> Unit) = DialogToSendMoney().apply {
            arguments = Bundle().apply {
                putSerializable(ACCOUNT_EXTRA, account)
                putSerializable(FUNCTION_EXTRA, function as Serializable)
            }
            setStyle(STYLE_NO_FRAME, R.style.MyDialogTheme)
        }
    }

}