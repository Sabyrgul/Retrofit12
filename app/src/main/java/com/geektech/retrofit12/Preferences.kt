package com.geektech.retrofit12

import android.content.Context

    class Preferences(private val context: Context) {

        companion object {
            private const val HAVE_SEEN_ONBOARDING_KEY = "have_seen_on_boarding"
        }

        private val prefs = context.getSharedPreferences(
            "utils",
            Context.MODE_PRIVATE
        )

        fun setHaveSeenOnBoarding(boolean: Boolean) {
            prefs.edit().putBoolean(HAVE_SEEN_ONBOARDING_KEY, boolean).apply()
        }

        fun getHaveSeenBoarding() = prefs.getBoolean(HAVE_SEEN_ONBOARDING_KEY, false)
    }