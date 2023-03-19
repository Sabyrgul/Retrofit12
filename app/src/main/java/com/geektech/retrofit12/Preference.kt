package com.geektech.retrofit12

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class Preference @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val HAVE_SEEN_ONBOARDING_KEY = "have_seen_on_boarding"
    }

    fun setHaveSeenOnBoarding() {
        sharedPreferences.edit().putBoolean(HAVE_SEEN_ONBOARDING_KEY, true).apply()
    }

    fun getHaveSeenBoarding() = sharedPreferences.getBoolean(HAVE_SEEN_ONBOARDING_KEY, false)
}