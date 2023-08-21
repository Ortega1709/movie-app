package com.ortega.infomovies.util

import android.content.Context
import android.content.SharedPreferences
import com.ortega.infomovies.util.Constants.MY_PREFERENCES


class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE)

    fun saveSetting(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getSetting(key: String, default: String) =
        sharedPreferences.getString(key, default) ?: default

}