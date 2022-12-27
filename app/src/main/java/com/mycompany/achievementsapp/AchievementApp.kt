package com.mycompany.achievementsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AchievementApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}