package bank.com.core.di

import bank.com.model.home.GenerateTokenModel
import bank.com.model.sendmoney.SendMoneyModel
import bank.com.model.transferhistory.TransfersHistoryModel
import bank.com.shared.constants.InjectionTags
import bank.com.shared.constants.InjectionTags.GENERATE_TOKEN_MODEL
import bank.com.shared.constants.InjectionTags.TRANSFER_HISTORY_MODEL
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ModelInjection {

    val model = Kodein.Module {

        import(ApiInjection().apiModule)

        bind<GenerateTokenModel>(GENERATE_TOKEN_MODEL) with singleton {
            GenerateTokenModel(digitalAccountApi = instance())
        }

        bind<TransfersHistoryModel>(TRANSFER_HISTORY_MODEL) with singleton {
            TransfersHistoryModel(digitalAccountApi = instance())
        }

        bind<SendMoneyModel>(InjectionTags.SEND_MONEY_MODEL) with singleton {
            SendMoneyModel(digitalAccountApi = instance())
        }
    }
}