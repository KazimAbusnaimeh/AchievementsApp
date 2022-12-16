package com.mycompany.achievementsapp.ui.fragments

import androidx.lifecycle.*
import com.mycompany.achievementsapp.api.Api
import com.mycompany.achievementsapp.data.AchievementRepository
import com.mycompany.achievementsapp.data.Achievements
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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

    lateinit var achievement:MutableLiveData<Achievements>

    init {
        achievement= MutableLiveData()
    }

    fun getAchievementObservable():MutableLiveData<Achievements>{
        return achievement
    }

    fun setAchievement(){repository.getAllAchievements().enqueue(object : Callback<Achievements?> {
        override fun onResponse(call: Call<Achievements?>, response: Response<Achievements?>) {
            if (response.isSuccessful){
            achievement.postValue(response.body())}
        }

        override fun onFailure(call: Call<Achievements?>, t: Throwable) {
        }
    })}
}