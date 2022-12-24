package com.mycompany.achievementsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mycompany.achievementsapp.datasource.models.Achievements

@Database(
    entities = [Achievements.AchievementsData.Records::class],
    exportSchema = false,
    version = 1
)
abstract class AchievementsDatabase : RoomDatabase() {

    abstract fun achievementsDao(): AchievementsDAO
}