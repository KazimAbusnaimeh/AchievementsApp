package com.mycompany.achievementsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mycompany.achievementsapp.api.models.Achievements
import com.mycompany.achievementsapp.api.models.Converters

@Database(entities = [Achievements::class], exportSchema = false, version = 1)
@TypeConverters(Converters::class)
abstract class AchievementsDatabase :RoomDatabase(){

    abstract fun achievementsDao():AchievementsDAO
}