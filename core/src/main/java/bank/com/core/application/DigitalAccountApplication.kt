package bank.com.core.application

import android.app.Application
import bank.com.core.di.CoreInjection
import com.facebook.stetho.Stetho
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class DigitalAccountApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(module = CoreInjection(this@DigitalAccountApplication).coreModule)
        import(androidModule(this@DigitalAccountApplication))
    }

    override fun onCreate() {
        super.onCreate()
        setupStetho()
    }

    private fun setupStetho(){
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build())
    }
}