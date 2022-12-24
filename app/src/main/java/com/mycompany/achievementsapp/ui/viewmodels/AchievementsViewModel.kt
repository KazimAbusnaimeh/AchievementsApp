package com.mycompany.achievementsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mycompany.achievementsapp.data.AchievementRepository
import com.mycompany.achievementsapp.datasource.models.Achievements
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val repository: AchievementRepository
) : ViewModel() {

    var achievement: MutableLiveData<Achievements>

    init {
        achievement = MutableLiveData()
    }

    fun saveRecord(records: Achievements.AchievementsData.Records) = liveData {
        try {
            repository.insertRecords(records)
        } catch (e: java.lang.Exception) {
            emit(false)
        }
        emit(true)
    }

    fun getAllRecords() = repository.getAllRecords()

    fun getAchievementObservable(): MutableLiveData<Achievements> {
        return achievement
    }

    fun setAchievement() {
        repository.getAllAchievements().enqueue(object : Callback<Achievements?> {
            override fun onResponse(call: Call<Achievements?>, response: Response<Achievements?>) {
                if (response.isSuccessful) {
                    achievement.postValue(response.body())
                }

            }

            override fun onFailure(call: Call<Achievements?>, t: Throwable) {
            }
        })
    }
}