package bank.com.core.di

import bank.com.shared.constants.InjectionTags.GENERATE_TOKEN_MODEL
import bank.com.shared.constants.InjectionTags.HOME_VIEW_MODEL
import bank.com.shared.constants.InjectionTags.SEND_MONEY_MODEL
import bank.com.shared.constants.InjectionTags.SEND_MONEY_VIEW_MODEL
import bank.com.shared.constants.InjectionTags.TRANSFER_HISTORY_MODEL
import bank.com.shared.constants.InjectionTags.TRANSFER_HISTORY_VIEW_MODEL
import bank.com.shared.base.BaseViewModel
import bank.com.viewmodel.home.HomeViewModel
import bank.com.viewmodel.sendmoney.SendMoneyViewModel
import bank.com.viewmodel.transferhistory.TransferHistoryViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ViewModelInjection {

    val module = Kodein.Module {
        import(module = ModelInjection().model)

        bind<BaseViewModel>(HOME_VIEW_MODEL) with singleton {
            HomeViewModel(instance(GENERATE_TOKEN_MODEL))
        }

        bind<BaseViewModel>(SEND_MONEY_VIEW_MODEL) with singleton {
            SendMoneyViewModel(instance(SEND_MONEY_MODEL))
        }

        bind<BaseViewModel>(TRANSFER_HISTORY_VIEW_MODEL) with singleton {
            TransferHistoryViewModel(instance(TRANSFER_HISTORY_MODEL))
        }
    }
}