package bank.com.digitalaccount.transferhistory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bank.com.digitalaccount.R

class TransferHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_history)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, TransferHistoryActivity::class.java)
    }
}
