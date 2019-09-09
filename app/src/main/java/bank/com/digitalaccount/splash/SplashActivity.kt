package bank.com.digitalaccount.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bank.com.digitalaccount.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(HomeActivity.getIntent(this))
        finish()
    }
}
