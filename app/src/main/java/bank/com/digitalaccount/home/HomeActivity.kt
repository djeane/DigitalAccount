package bank.com.digitalaccount.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bank.com.digitalaccount.R
import bank.com.digitalaccount.sendmoney.SendMoneyActivity
import bank.com.digitalaccount.transferhistory.TransferHistoryActivity
import bank.com.shared.annotations.Inject
import bank.com.shared.constants.InjectionTags.HOME_VIEW_MODEL
import bank.com.viewmodel.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.provider

@Inject(HOME_VIEW_MODEL)
class HomeActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        injectViewModel()

        applyListeners()
    }

    private fun injectViewModel() {
        val provide: () -> HomeViewModel by kodein.provider(HOME_VIEW_MODEL)
        viewModel = provide.invoke()
    }

    private fun applyListeners() {
        button_send_money.setOnClickListener {
            startActivity(SendMoneyActivity.getIntent(this))
        }

        button_transfer_history.setOnClickListener {
            startActivity(TransferHistoryActivity.getIntent(this))
        }
    }
}
