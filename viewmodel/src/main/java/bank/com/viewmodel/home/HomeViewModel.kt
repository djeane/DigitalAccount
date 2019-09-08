package bank.com.viewmodel.home

import bank.com.model.home.GenerateTokenModel
import bank.com.shared.extensions.applyIoToMainThread
import bank.com.shared.base.BaseViewModel
import io.reactivex.Single

class HomeViewModel(private val tokenModel: GenerateTokenModel) : BaseViewModel() {
    fun generateToken(name: String, email: String): Single<String> =
        tokenModel.generateToken(name, email)
            .applyIoToMainThread()
            .flatMap {
                Single.just(it)
            }
}