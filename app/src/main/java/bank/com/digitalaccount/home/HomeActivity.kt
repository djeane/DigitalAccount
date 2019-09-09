package bank.com.digitalaccount.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import bank.com.digitalaccount.R
import bank.com.digitalaccount.sendmoney.SendMoneyActivity
import bank.com.digitalaccount.transferhistory.TransferHistoryActivity
import bank.com.shared.annotations.Inject
import bank.com.shared.base.BaseActivity
import bank.com.shared.constants.DataMocked.Companion.PERSONAL_EMAIL
import bank.com.shared.constants.DataMocked.Companion.PERSONAL_IMAGE_URL
import bank.com.shared.constants.DataMocked.Companion.PERSONAL_NAME
import bank.com.shared.constants.InjectionTags.HOME_VIEW_MODEL
import bank.com.shared.extensions.getTyped
import bank.com.viewmodel.home.HomeViewModel
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_home.*

@Inject(HOME_VIEW_MODEL)
class HomeActivity : BaseActivity() {

    private val viewModel by lazy {
        viewModels.getTyped<HomeViewModel>(HOME_VIEW_MODEL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        applyListeners()
        initUi()
        generateToken()
    }


    private fun generateToken() {
        viewModel?.generateToken(PERSONAL_NAME, PERSONAL_EMAIL)
            ?.subscribe({
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_LONG).show()
            }, {
                Toast.makeText(this, "Erro: ${it.message}", Toast.LENGTH_LONG).show()
            })?.addTo(compositeDisposable)
    }

    override fun initUi() {
        super.initUi()
        sp_user_image.setImageURI(PERSONAL_IMAGE_URL)
        tv_username.text = PERSONAL_NAME
        tv_email.text = PERSONAL_EMAIL
    }

    private fun applyListeners() {
        button_send_money.setOnClickListener {
            startActivity(SendMoneyActivity.getIntent(this))
        }

        button_transfer_history.setOnClickListener {
            startActivity(TransferHistoryActivity.getIntent(this))
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }
}