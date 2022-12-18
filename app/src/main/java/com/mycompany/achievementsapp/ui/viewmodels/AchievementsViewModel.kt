package com.mycompany.achievementsapp.ui.viewmodels

import androidx.lifecycle.*
import com.mycompany.achievementsapp.data.AchievementRepository
import com.mycompany.achievementsapp.data.Achievements
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val repository: AchievementRepository
) : ViewModel() {

    lateinit var achievement:MutableLiveData<Achievements>
    lateinit var record:MutableLiveData<List<Achievements.AchievementsData.Records>>

    init {
        achievement= MutableLiveData()
        record= MutableLiveData()
    }

    fun getAchievementObservable():MutableLiveData<Achievements>{
        return achievement
    }
    fun getRecordsObservable():MutableLiveData<List<Achievements.AchievementsData.Records>>{
        return record
    }

    fun setAchievement(){repository.getAllAchievements().enqueue(object : Callback<Achievements?> {
        override fun onResponse(call: Call<Achievements?>, response: Response<Achievements?>) {
            if (response.isSuccessful){
            achievement.postValue(response.body())}

        }

        override fun onFailure(call: Call<Achievements?>, t: Throwable) {
        }
    })}
    fun setRecordsList(){repository.getAllAchievements().enqueue(object : Callback<Achievements?> {
        override fun onResponse(call: Call<Achievements?>, response: Response<Achievements?>) {
            val achievement=response.body()
            val list= listOf(
                achievement!!.data[0].records[0], achievement.data[0].records[1], achievement.data[0].records[2],
                achievement.data[0].records[3], achievement.data[0].records[4], achievement.data[0].records[5],
                achievement.data[1].records[0], achievement.data[1].records[1], achievement.data[1].records[2],
                achievement.data[1].records[3], achievement.data[1].records[4], achievement.data[1].records[5],
            )
            record.postValue(list)
        }

        override fun onFailure(call: Call<Achievements?>, t: Throwable) {
        }
    })
    }
}