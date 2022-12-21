package com.mycompany.achievementsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mycompany.achievementsapp.api.models.Achievements

@Database(entities = [Achievements.AchievementsData.Records::class], exportSchema = false, version = 1)
abstract class AchievementsDatabase :RoomDatabase(){

    abstract fun achievementsDao():AchievementsDAO
}