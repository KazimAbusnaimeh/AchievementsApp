package com.mycompany.achievementsapp.datasource

import com.mycompany.achievementsapp.datasource.models.Achievements
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object{

    }
    @GET("achievements")
    fun getAchievements(): Call<Achievements>
}