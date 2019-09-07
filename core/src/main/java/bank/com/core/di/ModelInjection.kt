package bank.com.core.di

import bank.com.model.sendmoney.SendMoneyModel
import bank.com.shared.constants.InjectionTags
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class ModelInjection {

    val model = Kodein.Module{
        bind<SendMoneyModel>(InjectionTags.SEND_MONEY_MODEL) with singleton {
            SendMoneyModel()
        }
    }
}