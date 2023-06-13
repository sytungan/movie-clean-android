package com.example.moviedatabase.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.toMMMMyyyy(): String {
    val format = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    return format.format(this)
}
