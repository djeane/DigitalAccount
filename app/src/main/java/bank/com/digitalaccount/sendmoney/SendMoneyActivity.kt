package bank.com.digitalaccount.sendmoney

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bank.com.digitalaccount.R

class SendMoneyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
    }

    companion object{
        fun getIntent(context: Context) = Intent(context, SendMoneyActivity::class.java)
    }
}
