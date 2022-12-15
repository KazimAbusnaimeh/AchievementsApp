//package com.mycompany.achievementsapp.di
//
//import android.content.Context
//import androidx.room.Room
//import com.google.gson.GsonBuilder
//import com.mycompany.achievementsapp.api.Api
//import com.mycompany.achievementsapp.data.AchievementsDAO
//import com.mycompany.achievementsapp.data.AchievementsDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RoomModule {
//
//    @Provides
//    fun provideDataBase(@ApplicationContext context: Context):AchievementsDatabase{
//        return Room.databaseBuilder(context,AchievementsDatabase::class.java,"achievements.db").build()
//    }
//
//    @Provides
//    fun provideDao(achievementsDatabase: AchievementsDatabase):AchievementsDAO{
//        return achievementsDatabase.achievementsDao()
//    }
//
//
//}