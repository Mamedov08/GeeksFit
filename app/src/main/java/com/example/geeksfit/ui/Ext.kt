package com.example.geeksfit.ui

import android.app.AlertDialog
import android.content.Context

import android.widget.Toast




fun Context.showToast(text: String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.showConfirmationDialog(
    title: String = "Подтверждение",
    message: String = "Вы действительно хотите продолжить?",
    positiveButtonText: String = "ОК",
    negativeButtonText: String = "Отмена",
    onPositiveAction: () -> Unit = {},
    onNegativeAction: () -> Unit = {}
) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveButtonText) { _, _ ->
        onPositiveAction()
    }
    builder.setNegativeButton(negativeButtonText) { _, _ ->
        onNegativeAction()
    }
    builder.create().show()
}
