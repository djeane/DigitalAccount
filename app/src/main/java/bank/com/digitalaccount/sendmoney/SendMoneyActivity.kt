package bank.com.digitalaccount.sendmoney

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.InjectionTags.SEND_MONEY_VIEW_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.sendmoney.AccountReceiverUIModel
import bank.com.viewmodel.sendmoney.SendMoneyViewModel
import bank.com.viewmodel.sendmoney.TransferAccountsUiModel
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_send_money.*


@Inject(SEND_MONEY_VIEW_MODEL)
@SuppressLint("CheckResult")
class SendMoneyActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<SendMoneyViewModel>(SEND_MONEY_VIEW_MODEL)
    }

    private val publish by lazy { PublishSubject.create<SendMoneyAdapter.Interaction>() }

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
            layoutManager = LinearLayoutManager(this@SendMoneyActivity)
            adapter = SendMoneyAdapter(
                this@SendMoneyActivity, TransferAccountsUiModel.generateUsersTransferList(),
                publish
            )
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
        val prev = supportFragmentManager!!.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        val dialog = DialogToSendMoney.getInstance(account)
        dialog.show(ft, "dialog")
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SendMoneyActivity::class.java)
    }
}
