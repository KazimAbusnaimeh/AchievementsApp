package com.mycompany.achievementsapp.di

import com.mycompany.achievementsapp.datasource.Api
import com.mycompany.achievementsapp.data.AchievementRepository
import com.mycompany.achievementsapp.data.AchievementRepositoryImpl
import com.mycompany.achievementsapp.data.AchievementsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object AchievementsModule {
    @Provides
    fun providesWordRepository(api: Api,dao: AchievementsDAO):AchievementRepository{
        return AchievementRepositoryImpl(api,dao)
    }

    @Provides
    fun providesApi():Api{
        return Retrofit.Builder()
                .baseUrl("https://786b905e-735c-4be6-adfb-949d5dadee32.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
    }
}