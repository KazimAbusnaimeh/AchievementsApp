package com.mycompany.achievementsapp.data

import retrofit2.Call
import retrofit2.Response

interface AchievementRepository {
//suspend fun insert(achievements: Achievements)
//suspend fun getAll():List<Achievements>
fun getAllAchievements():Call<Achievements>
}