package bank.com.shared.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

fun Context.hideKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}