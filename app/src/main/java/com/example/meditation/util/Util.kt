package com.example.meditation.util

import android.content.Context
import android.preference.PreferenceManager

class Util(context: Context) {
    companion object {
        //object üretmeden
        private const val SHARED_PREF_USERNAME = "name" //!! text
    }

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun storeUserName(userName: String) {
        prefs.edit().putString(SHARED_PREF_USERNAME, userName).apply()
    }

    fun getUserName(): String? {
        return prefs.getString(SHARED_PREF_USERNAME, null)
    }
}