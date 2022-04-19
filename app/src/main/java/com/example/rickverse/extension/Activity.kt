package com.example.rickverse.extension

import android.app.Activity
import android.widget.Toast
import com.example.rickverse.R

fun Activity?.showToast (
    messageId: Int = R.string.something_went_wrong,
    lenght: Int = Toast.LENGTH_LONG
) {
    Toast.makeText(this, messageId, lenght).show()
}