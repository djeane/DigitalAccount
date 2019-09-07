package bank.com.core.di

import android.content.Context
import bank.com.shared.constants.InjectionTags
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

data class CoreInjection(private val context: Context) {
    val coreModule = Kodein.Module {
        import(ViewModelInjection().module)
        bind<Scheduler>(InjectionTags.WORKER) with singleton { Schedulers.io() }
        bind<Scheduler>(InjectionTags.UITHREAD) with singleton { AndroidSchedulers.mainThread() }
    }
}