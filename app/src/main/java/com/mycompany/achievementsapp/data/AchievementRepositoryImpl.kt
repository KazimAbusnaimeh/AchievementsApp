package com.mycompany.achievementsapp.data

import com.mycompany.achievementsapp.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AchievementRepositoryImpl @Inject constructor(
    private val api: Api,
//    private val achievementsDAO: AchievementsDAO
) :
    AchievementRepository {
    //    override suspend fun insert(achievements: Achievements) {
//        achievementsDAO.insertAchievement(achievements)
//    }
//
//    override suspend fun getAll(): List<Achievements> {
//        return achievementsDAO.getAllAchievements()
//    }
    lateinit var achievement: Achievements

    override fun getAllAchievements():Call<Achievements> {
        return api.getAchievements()
    }
}