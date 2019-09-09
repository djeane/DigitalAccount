package bank.com.core.application

import android.app.Application
import bank.com.core.di.CoreInjection
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class DigitalAccountApplication : Application(), KodeinAware {

    private val context by lazy { this@DigitalAccountApplication }

    override val kodein = Kodein.lazy {
        import(module = CoreInjection(context).coreModule)
        import(androidModule(context))
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(context)
        setupStetho()
    }

    private fun setupStetho() {
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build()
        )
    }
}