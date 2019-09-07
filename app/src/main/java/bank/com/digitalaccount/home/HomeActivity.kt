package bank.com.digitalaccount.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bank.com.digitalaccount.R
import bank.com.digitalaccount.sendmoney.SendMoneyActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        applyListeners()
    }

    private fun applyListeners(){
        button_send_money.setOnClickListener {
            startActivity(SendMoneyActivity.getIntent(this))
        }

        button_transfer_history.setOnClickListener {

        }
    }
}
