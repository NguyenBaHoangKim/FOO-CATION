package com.example.common.utils

import android.content.Context
import android.content.SharedPreferences

class UserSessionManager(val context: Context) {
    private val prefName = "user"
    private val privateMode = 0
    private val preference: SharedPreferences = context.getSharedPreferences(prefName, privateMode)
    private val editor = preference.edit()


    fun setInfo(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getInfo(key: String): String? {
        return preference.getString(key, "")
    }
}