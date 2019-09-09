package bank.com.shared.base

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

open class BaseViewModel {
    protected val loadingSubject: BehaviorSubject<Boolean> = BehaviorSubject.create()
    val loadingObservable: Observable<Boolean> = loadingSubject

    companion object {
        const val tag = "baseViewModel"
    }
}