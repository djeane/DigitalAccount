package bank.com.digitalaccount.transferhistory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.InjectionTags.TRANSFER_HISTORY_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.transferhistory.TransferHistoryViewModel

@Inject(TRANSFER_HISTORY_MODEL)
class TransferHistoryActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<TransferHistoryViewModel>(TRANSFER_HISTORY_MODEL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_history)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, TransferHistoryActivity::class.java)
    }
}
