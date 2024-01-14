package com.meta.capstoneproject.littlelemonapp.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

internal fun Context.setSharedPref(key: String, value: Any) {
    val preference = getSharedPreferences("LittleLemonSharedPref", Context.MODE_PRIVATE)
    val editor = preference.edit()
    when (value) {
        is String -> editor.putString(key, value)
        is Int -> editor.putInt(key, value)
        is Boolean -> editor.putBoolean(key, value)
        else -> return
    }
    editor.apply()
}

internal fun Context.getSharedPrefString(key: String): String {
    val preference = getSharedPreferences("LittleLemonSharedPref", Context.MODE_PRIVATE)
    return preference.getString(key, "")?:""
}

internal fun <T> String.toObject(tClass: Class<T>): T? {
    return try {
        Gson().fromJson(this, tClass)
    } catch (e: JsonSyntaxException) {
        e.printStackTrace()
        null
    }
}