package bank.com.shared.extensions

import bank.com.shared.base.BaseViewModel

inline fun <reified T> Map<String, BaseViewModel>.getTyped(key: String) = this[key] as T?