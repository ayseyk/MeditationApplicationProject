package com.example.meditation.util

import android.content.Context
import android.preference.PreferenceManager

class Util(context: Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun storeUserName(userName : String) {
        prefs.edit().putString("name",userName).apply()
    }

    fun getUserName(): String?{
        return prefs.getString("name",null)
    }
}