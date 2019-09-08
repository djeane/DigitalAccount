package bank.com.shared.constants

object InjectionTags {
    const val WORKER = "WORKER_THREAD"
    const val UITHREAD = "UI_THREAD"

    //VIEW MODEL TAGS
    const val SEND_MONEY_VIEW_MODEL = "sendMoneyViewModel"
    const val HOME_VIEW_MODEL = "homeViewModel"
    const val TRANSFER_HISTORY_VIEW_MODEL = "transferHistoryViewModel"


    //MODEL TAGS
    const val SEND_MONEY_MODEL = "sendMoneyModel"
    const val GENERATE_TOKEN_MODEL = "generateTokenModel"
    const val TRANSFER_HISTORY_MODEL = "transferHistoryModel"


    //API
    const val RETROFIT_API = "retrofitApi"
    const val OKHTTP_API = "okhttpApi"
}