package com.example.meditation.util

import android.content.Context
import android.preference.PreferenceManager

class Util(context: Context) {
    companion object {
        //object üretmeden
        private const val SHARED_PREF_USERNAME = "name" //!! text
        const val MIN_USERNAME_LENGTH = 2
        const val MIN_PASSWORD_LENGTH = 6
        const val REGEX_AT_LEAST_ONE_UPPERCASE = "(?=.[A-Z])"
        const val REGEX_AT_LEAST_ONE_DIGIT = "(?=.\\d)"
    }

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun storeUserName(userName: String) {
        prefs.edit().putString(SHARED_PREF_USERNAME, userName).apply()
    }

    fun getUserName(): String? {
        return prefs.getString(SHARED_PREF_USERNAME, null)
    }
}