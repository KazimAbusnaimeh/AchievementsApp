package com.mycompany.achievementsapp.datasource

import com.mycompany.achievementsapp.datasource.models.Achievements
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object {
        const val BASE_URL = "https://786b905e-735c-4be6-adfb-949d5dadee32.mock.pstmn.io/"
    }

    // endpoints
    // api

    @GET("achievements")
    fun getAchievements(): Call<Achievements>
}