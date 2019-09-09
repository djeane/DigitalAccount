package bank.com.shared.extensions

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

fun <T> Single<T>.applyIoToMainThread(): Single<T> =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.applyIoToMainThread(): Observable<T> =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.applyLoading(loadingSubject: BehaviorSubject<Boolean>): Single<T> =
    doOnSubscribe { loadingSubject.onNext(true) }
        .doFinally { loadingSubject.onNext(false) }

fun <T> Observable<T>.applyLoading(loadingSubject: BehaviorSubject<Boolean>): Observable<T> =
    doOnSubscribe { loadingSubject.onNext(true) }
        .doFinally { loadingSubject.onNext(false) }
