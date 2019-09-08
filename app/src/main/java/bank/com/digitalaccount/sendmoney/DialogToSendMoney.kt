package bank.com.digitalaccount.sendmoney

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import bank.com.digitalaccount.R
import bank.com.shared.views.MoneyTextWatcher
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import kotlinx.android.synthetic.main.activity_dialog_send_money.*

@Suppress("UNCHECKED_CAST")
class DialogToSendMoney : DialogFragment() {

    private val account by lazy { arguments?.getSerializable(ACCOUNT_EXTRA) as AccountReceiverUIModel }
    //private val function by lazy { arguments?.getSerializable(FUNCTION_EXTRA) as () -> Unit}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        layoutInflater.inflate(R.layout.activity_dialog_send_money, root, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        account.image?.let { sp_user_image.setImageURI(it) }
        tv_username.text = account.formattingUserName()
        et_amount.hint?.let { et_amount.setSelection(0) }
        tv_phone_number.text = account.formattingPhoneNumber()
        iv_close.setOnClickListener { this.dismiss() }
        applyCurrencyMask()
    }

    private fun applyCurrencyMask(){
        et_amount.addTextChangedListener(MoneyTextWatcher(et_amount))
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        //function()
    }

    companion object {
        const val ACCOUNT_EXTRA = "ACOUNT_EXTRA"
        const val FUNCTION_EXTRA = "FUNCTION_EXTRA"

        fun getInstance(account: AccountReceiverUIModel/*, function: () -> Unit*/) = DialogToSendMoney().apply {
            arguments = Bundle().apply {
                putSerializable(ACCOUNT_EXTRA, account)
                //putSerializable(FUNCTION_EXTRA, function as Serializable)
            }
            setStyle(STYLE_NO_FRAME, R.style.MyDialogTheme)
        }
    }

}