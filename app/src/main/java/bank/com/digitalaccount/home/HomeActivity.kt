package bank.com.digitalaccount.home

import android.os.Bundle
import bank.com.digitalaccount.R
import bank.com.digitalaccount.sendmoney.SendMoneyActivity
import bank.com.digitalaccount.transferhistory.TransferHistoryActivity
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.InjectionTags.HOME_VIEW_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

@Inject(HOME_VIEW_MODEL)
class HomeActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<HomeViewModel>(HOME_VIEW_MODEL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initUi()
        applyListeners()
    }

    override fun initUi() {
        super.initUi()
        sp_user_image.setImageURI(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbQE4U0SFyX6HQAVxsDw59KS7HCWKo3CyvoexeSc_EMO04Dc20"
        )
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