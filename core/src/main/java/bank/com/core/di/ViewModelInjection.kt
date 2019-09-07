package bank.com.core.di

import bank.com.shared.constants.InjectionTags.SEND_MONEY_MODEL
import bank.com.shared.constants.InjectionTags.SEND_MONEY_VIEW_MODEL
import bank.com.viewmodel.sendmoney.SendMoneyViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ViewModelInjection {

    val module = Kodein.Module {
        import(module = ModelInjection().model)

        bind<SendMoneyViewModel>(SEND_MONEY_VIEW_MODEL) with singleton {
            SendMoneyViewModel(instance(SEND_MONEY_MODEL))
        }
    }
}