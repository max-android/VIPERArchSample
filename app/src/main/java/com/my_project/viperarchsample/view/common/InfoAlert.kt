package com.my_project.viperarchsample.view.common

import android.content.Context
import android.support.v7.app.AlertDialog


class InfoAlert {

    private var alertDialog: AlertDialog? = null

    fun showAlert(message: String, context: Context) {

        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.apply {
            setTitle("InfoAlertDialog")
            setMessage(message)
            // setOnDismissListener {  }
            setCancelable(false)
            setPositiveButton("Да") { dialog, id -> {} }
            setNegativeButton("Нет") { dialog, id -> {} }
        }
        alertDialog = dialogBuilder.create()
        alertDialog?.show()
    }

    fun dismissAlert() {
        //  alertDialog?.setOnDismissListener { null }
        alertDialog?.dismiss()
    }
}