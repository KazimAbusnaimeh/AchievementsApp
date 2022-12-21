package com.mycompany.achievementsapp.services

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import com.mycompany.achievementsapp.utils.Constants.ACTION_PAUSE_SERVICE
import com.mycompany.achievementsapp.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.mycompany.achievementsapp.utils.Constants.ACTION_STOP_SERVICE
import com.mycompany.achievementsapp.utils.Constants.COROUTINE_TIMER_DELAY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimingService:LifecycleService() {
    var isFirstRace=true
    private val timeRaceInSeconds=MutableLiveData<Long>()
    private val TAG = "TimingService"

    companion object{
        val timeRunInMillis=MutableLiveData<Long>()
        val isRacing=MutableLiveData<Boolean>()
    }
    private fun postInitialValues(){
        isRacing.postValue(false)
        timeRaceInSeconds.postValue(0L)
        timeRunInMillis.postValue(0L)
    }

    private var isTimerEnabled=false
    private var lapTime=0L
    private var timeRace=0L
    private var timeStarted=0L
    private var lastSecondTimestamp=0L

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRace) {
                        Log.d(TAG, "start or resume: kazim")
                        startForegroundService()
                        isFirstRace = false
                    } else {
                        Log.d(TAG, "e: kaizm")
                        startTimer()
                    }
                }
                ACTION_PAUSE_SERVICE -> {
                    Log.d(TAG, "p: kazim")
                    pauseService()
                }
                ACTION_STOP_SERVICE -> {
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
    private fun startForegroundService() {
        startTimer()
        isRacing.postValue(true)
        }

    private fun startTimer(){
        isRacing.postValue(true)
        timeStarted=System.currentTimeMillis()
        isTimerEnabled=true
        CoroutineScope(Dispatchers.Main).launch {
            while (isRacing.value!!){
                lapTime=System.currentTimeMillis()-timeStarted
                timeRunInMillis.postValue(timeRace+lapTime)
                if(timeRunInMillis.value!!>=lastSecondTimestamp+1000L){
                    timeRaceInSeconds.postValue(timeRaceInSeconds.value!!+1)
                    lastSecondTimestamp+=1000L
                }
                delay(COROUTINE_TIMER_DELAY)
            }
            timeRace+=lapTime
        }
    }

    private fun pauseService() {
        isRacing.postValue(false)
        isTimerEnabled = false
    }

    override fun onCreate() {
        super.onCreate()
        postInitialValues()
    }
}