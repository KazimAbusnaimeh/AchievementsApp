package com.mycompany.achievementsapp.ui.fragments

import androidx.lifecycle.*
import com.mycompany.achievementsapp.api.Api
import com.mycompany.achievementsapp.data.AchievementRepository
import com.mycompany.achievementsapp.data.Achievements
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val repository: AchievementRepository
) : ViewModel() {


       val achievementCallBack= repository.getAllAchievements()

}