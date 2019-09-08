package bank.com.digitalaccount.transferhistory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bank.com.digitalaccount.R
import bank.com.shared.annotations.Inject
import bank.com.shared.constants.InjectionTags.TRANSFER_HISTORY_MODEL
import bank.com.viewmodel.transferhistory.TransferHistoryViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.provider

@Inject(TRANSFER_HISTORY_MODEL)
class TransferHistoryActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()

    private lateinit var viewModel: TransferHistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_history)
        injectViewModel()
    }

    private fun injectViewModel() {
        val provide: () -> TransferHistoryViewModel by kodein.provider(TRANSFER_HISTORY_MODEL)
        viewModel = provide.invoke()
    }


    companion object {
        fun getIntent(context: Context) = Intent(context, TransferHistoryActivity::class.java)
    }
}
