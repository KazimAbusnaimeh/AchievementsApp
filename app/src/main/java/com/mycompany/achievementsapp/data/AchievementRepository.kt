package com.mycompany.achievementsapp.data

import com.mycompany.achievementsapp.api.models.Achievements
import retrofit2.Call

interface AchievementRepository {
    //suspend fun insert(achievements: Achievements)
//suspend fun getAll():List<Achievements>
    fun getAllAchievements(): Call<Achievements>
    suspend fun insertRecords(record: Achievements.AchievementsData.Records)
    suspend fun getAllRecords(): List<Achievements.AchievementsData.Records>
}