package com.mycompany.achievementsapp.data

import com.mycompany.achievementsapp.api.Api
import com.mycompany.achievementsapp.api.models.Achievements
import retrofit2.Call

class AchievementRepositoryImpl (
    private val api: Api,
    private val achievementsDAO: AchievementsDAO
) : AchievementRepository {
    lateinit var achievement: Achievements

    override fun getAllAchievements(): Call<Achievements> {
        return api.getAchievements()
    }

    override suspend fun insertRecords(record: Achievements.AchievementsData.Records) {
        achievementsDAO.insertRecords(record)
    }

    override suspend fun getAllRecords(): List<Achievements.AchievementsData.Records> {
        return achievementsDAO.getAllRecords()
    }


}