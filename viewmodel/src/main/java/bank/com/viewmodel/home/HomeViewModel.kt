package bank.com.viewmodel.home

import bank.com.model.home.GenerateTokenModel
import bank.com.shared.base.BaseViewModel
import bank.com.shared.extensions.applyIoToMainThread
import bank.com.shared.extensions.applyLoading
import io.reactivex.Single

class HomeViewModel(private val tokenModel: GenerateTokenModel) : BaseViewModel() {
    fun generateToken(name: String, email: String): Single<String> =
        tokenModel.generateToken(name, email)
            .applyIoToMainThread()
            .applyLoading(loadingSubject)
            .flatMap {
                Single.just(it)
            }
}