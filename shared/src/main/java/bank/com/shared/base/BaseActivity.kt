package bank.com.shared.base

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import bank.com.shared.R
import bank.com.shared.annotations.Inject
import bank.com.shared.extensions.hideKeyboard
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.provider

abstract class BaseActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()
    protected var viewModels: MutableMap<String, BaseViewModel> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        inject()
    }

    private fun inject() {
        val inject: Inject? = javaClass.annotations.firstOrNull { it is Inject } as Inject?
        inject?.let {
            for (tag in it.tag) {
                val provider: () -> BaseViewModel by kodein.provider(tag)
                val viewModel = provider.invoke()
                viewModels[tag] = viewModel
            }
        }
    }

    open fun setupToolbar() {
        findViewById<Toolbar>(R.id.toolbar)?.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            it.setNavigationOnClickListener {
                hideKeyboard()
                onBackPressed()
            }
        }
    }

    @CallSuper
    open fun initUi() {}

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}