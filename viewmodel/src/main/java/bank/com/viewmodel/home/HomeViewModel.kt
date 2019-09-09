package bank.com.viewmodel.home

import android.annotation.SuppressLint
import bank.com.model.home.GenerateTokenModel
import bank.com.shared.base.BaseViewModel
import bank.com.shared.extensions.applyIoToMainThread
import bank.com.shared.extensions.applyLoading
import io.reactivex.Single

@SuppressLint("CheckResult")
class HomeViewModel(private val tokenModel: GenerateTokenModel) : BaseViewModel() {
    fun generateToken(name: String, email: String): Single<Unit> =
        tokenModel.generateToken(name, email)
            .applyIoToMainThread()
            .applyLoading(loadingSubject)
            .flatMap {
                saveToken(it)
            }


    private fun saveToken(token: String): Single<Unit> =
        Single.fromCallable {
            tokenModel.saveToken(token)
        }.flatMap { unit ->
            Single.just(unit)
        }
}