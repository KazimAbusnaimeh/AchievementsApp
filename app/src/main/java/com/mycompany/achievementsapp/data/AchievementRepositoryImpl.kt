package com.mycompany.achievementsapp.data

import androidx.lifecycle.LiveData
import com.mycompany.achievementsapp.datasource.Api
import com.mycompany.achievementsapp.datasource.models.Achievements
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

    override fun getAllRecords(): LiveData<List<Achievements.AchievementsData.Records>> {
        return achievementsDAO.getAllRecords()
    }


}