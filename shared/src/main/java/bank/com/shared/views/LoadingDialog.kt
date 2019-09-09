package bank.com.shared.views

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import bank.com.shared.R

class LoadingDialog(context: Context) : AlertDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.loading_dialog)
        this.setCancelable(false)
        this.setCanceledOnTouchOutside(false)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun show() {
        if (!this.isShowing) {
            try {
                super.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun dismiss() {
        if (this.isShowing) {
            super.dismiss()
        }
    }

    override fun cancel() {
        if (this.isShowing) {
            super.cancel()
        }
    }
}