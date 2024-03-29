package bank.com.digitalaccount.sendmoney

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.InjectionTags.SEND_MONEY_VIEW_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import bank.com.viewmodel.sendmoney.SendMoneyViewModel
import bank.com.viewmodel.sendmoney.TransferAccountsUiModel
import com.muddzdev.styleabletoast.StyleableToast
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_send_money.*


@Inject(SEND_MONEY_VIEW_MODEL)
@SuppressLint("CheckResult")
class SendMoneyActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<SendMoneyViewModel>(SEND_MONEY_VIEW_MODEL)
    }

    private val TAG = SendMoneyActivity::class.java.simpleName
    private lateinit var dialog: DialogToSendMoney

    private val publish by lazy { PublishSubject.create<SendMoneyAdapter.Interaction>() }
    var amount = 0.0
    private val context by lazy { this@SendMoneyActivity }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
        setupToolbar()
        title = getString(R.string.home_title)
        setAdapter()
        itemClicked()
        imageClicked()
    }

    private fun setAdapter() {
        rv_accounts_transfer.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SendMoneyAdapter(context, TransferAccountsUiModel.generateUsersTransferList(), publish)
        }
    }

    private fun itemClicked() {
        publish.ofType(SendMoneyAdapter.Interaction.ItemTapped::class.java).subscribe {
            showDialogToSendMoney(it.account)
        }
    }

    private fun imageClicked() {
        publish.ofType(SendMoneyAdapter.Interaction.ImageTapped::class.java).subscribe {
            showDialogToSendMoney(it.account)
        }
    }

    private fun showDialogToSendMoney(account: AccountReceiverUIModel) {
        val ft = supportFragmentManager!!.beginTransaction()
        val prev = supportFragmentManager!!.findFragmentByTag(getString(R.string.tag_dialog))
        if (prev != null) {
            ft.remove(prev)
        }
        dialog = DialogToSendMoney.getInstance(account) { sendMoneyWithoutApiCall() }
        dialog.show(ft, getString(R.string.tag_dialog))
    }


    private fun sendMoneyWithoutApiCall() {
        if (amount > 10) {
            onStartLoading()
            Handler().postDelayed({
                dialog.dismiss()
                onStopLoading()
                StyleableToast.makeText(
                    context,
                    getString(R.string.transfer_successfully),
                    Toast.LENGTH_LONG,
                    R.style.SuccessToast
                ).show()
                backToHome()
            }, 3000)
        } else {
            dialog.dismiss()
            StyleableToast.makeText(
                context,
                getString(R.string.transfer_error),
                Toast.LENGTH_LONG,
                R.style.FailToast
            ).show()
        }
    }

    private fun backToHome() {
        onBackPressed()
    }

    private fun sendMoney() {
        viewModel?.sendMoney(amount = amount)
            ?.subscribe({}, {
                Log.e(TAG, "${getString(R.string.errror)}: ${it.message}")
            })
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SendMoneyActivity::class.java)
    }
}
