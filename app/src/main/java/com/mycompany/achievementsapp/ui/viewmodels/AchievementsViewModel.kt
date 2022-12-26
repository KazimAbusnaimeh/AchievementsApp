package com.mycompany.achievementsapp.ui.viewmodels

import androidx.lifecycle.*
import com.mycompany.achievementsapp.data.AchievementRepository
import com.mycompany.achievementsapp.datasource.models.Achievements
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(
    private val repository: AchievementRepository
) : ViewModel() {

    val successAchievement: MutableLiveData<Achievements> = MutableLiveData()
    val errorAchievement: MutableLiveData<String> = MutableLiveData()
    val loadingAchievement: MutableLiveData<Boolean> = MutableLiveData()

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
        return successAchievement
    }

    fun setAchievement() {
        viewModelScope.launch(Dispatchers.IO) {
            loadingAchievement.postValue(true)
            repository.getAllAchievements().enqueue(object : Callback<Achievements?> {
                override fun onResponse(
                    call: Call<Achievements?>,
                    response: Response<Achievements?>
                ) {
                    if (response.isSuccessful) {
                        try {
                            successAchievement.postValue(response.body())
                        } catch (e: Exception) {
                            errorAchievement.postValue(e.message)
                        }
                    }

                }

                override fun onFailure(call: Call<Achievements?>, t: Throwable) {
                    errorAchievement.postValue(t.message)
                }
            })
            loadingAchievement.postValue(false)
        }
    }
}