package com.mycompany.achievementsapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.data.Achievements
import com.mycompany.achievementsapp.databinding.FragmentRacesBinding
import com.mycompany.achievementsapp.services.TimingService
import com.mycompany.achievementsapp.utils.Constants.ACTION_PAUSE_SERVICE
import com.mycompany.achievementsapp.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.mycompany.achievementsapp.utils.Utility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RacesFragment:Fragment(R.layout.fragment_races) {

    lateinit var binding: FragmentRacesBinding
    lateinit var record :Achievements.AchievementsData.Records

    private var isRacing = false
    private var curTimeInMillis = 0L

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentRacesBinding.bind(view)

        setLabel()
        binding.btnStart.setOnClickListener{
            toggleRace()
        }

        subscribeToObservers()

    }
    private fun setLabel(){
        arguments?.let {
            record=it.getParcelable("record")!!
        }
        binding.record=record
    }
    private fun toggleRace() {
        if(isRacing) {
            sendCommandToService(ACTION_PAUSE_SERVICE)
        } else {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
    }
    private fun sendCommandToService(action: String) =
        Intent(requireContext(), TimingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    private fun subscribeToObservers() {
        TimingService.isRacing.observe(viewLifecycleOwner, Observer {
            updateTracking(it)
        })

        TimingService.timeRunInMillis.observe(viewLifecycleOwner, Observer {
            curTimeInMillis = it
            val formattedTime = Utility.getFormattedStopWatchTime(curTimeInMillis, true)
            binding.tvRecordLabel.text = formattedTime
        })
    }

    private fun updateTracking(isRacing: Boolean) {
        this.isRacing = isRacing
        if(!isRacing) {
//            btnToggleRun.text = "Start"
//            btnFinishRun.visibility = View.VISIBLE
        } else {
//            btnToggleRun.text = "Stop"
//            btnFinishRun.visibility = View.GONE
        }
    }

}