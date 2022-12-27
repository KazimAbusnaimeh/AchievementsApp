package com.mycompany.achievementsapp.utils

import com.mycompany.achievementsapp.BuildConfig

object Constants {

    const val COROUTINE_TIMER_DELAY = 50L
    const val START_TIMER = "00:00:00:00"

    const val ACHIEVEMENT_FRAGMENT_ARG_KEY = "ACHIEVEMENT_FRAGMENT_ARG_KEY"

    const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE"
    const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
    const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"
    const val BASE_URL = BuildConfig.API_KEY
    const val ACHIEVEMENT_FRAGMENT_TAG = "AchievementsFragment"
}