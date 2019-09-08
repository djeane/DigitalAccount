package bank.com.digitalaccount.transferhistory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.InjectionTags.TRANSFER_HISTORY_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.sendmoney.TransferAccountsUiModel
import bank.com.viewmodel.transferhistory.TransferHistoryViewModel
import kotlinx.android.synthetic.main.activity_transfer_history.*

@Inject(TRANSFER_HISTORY_MODEL)
class TransferHistoryActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<TransferHistoryViewModel>(TRANSFER_HISTORY_MODEL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_history)
        setupToolbar()
        title = getString(R.string.transfer_history_title)
        setAdapters()
    }

    private fun setAdapters() {
        rv_transfer_graphics.apply {
            adapter = TransferGraphicsAdapter(
                this@TransferHistoryActivity, TransferAccountsUiModel.generateUsersTransferList()
            )
        }

        rv_individual_account.apply {
            layoutManager = LinearLayoutManager(this@TransferHistoryActivity)
            adapter = IndividualTransferAdapter(
                this@TransferHistoryActivity, TransferAccountsUiModel.generateUsersTransferList()
            )
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, TransferHistoryActivity::class.java)
    }
}
