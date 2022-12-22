package com.mycompany.achievementsapp.data

import androidx.lifecycle.LiveData
import com.mycompany.achievementsapp.datasource.models.Achievements
import retrofit2.Call

interface AchievementRepository {
    //suspend fun insert(achievements: Achievements)
//suspend fun getAll():List<Achievements>
    fun getAllAchievements(): Call<Achievements>
    suspend fun insertRecords(record: Achievements.AchievementsData.Records)
     fun getAllRecords(): LiveData<List<Achievements.AchievementsData.Records>>
}