package com.mycompany.achievementsapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.api.models.Achievements
import com.mycompany.achievementsapp.databinding.FragmentRacesBinding
import com.mycompany.achievementsapp.services.TimingService
import com.mycompany.achievementsapp.ui.viewmodels.AchievementsViewModel
import com.mycompany.achievementsapp.utils.Constants.ACHIEVEMENT_FRAGMENT_ARG_KEY
import com.mycompany.achievementsapp.utils.Constants.ACTION_PAUSE_SERVICE
import com.mycompany.achievementsapp.utils.Constants.ACTION_START_OR_RESUME_SERVICE
import com.mycompany.achievementsapp.utils.Utility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RacesFragment : Fragment(R.layout.fragment_races) {

    lateinit var race:Achievements.AchievementsData.Records
    lateinit var binding: FragmentRacesBinding
    lateinit var record: Achievements.AchievementsData.Records
    val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private var isRacing = false
    private var curTimeInMillis = 0L

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRacesBinding.bind(view)

        setLabel()
        subscribeToObservers()
        onButtonClicked()

    }

    private fun setLabel() {
        arguments?.let {
            record = it.getParcelable(ACHIEVEMENT_FRAGMENT_ARG_KEY)!!
        }
        binding.record = record
         race=record
    }

    private fun onButtonClicked(){
        var time="00:00:00:00"
        binding.apply {
            btnStart.setOnClickListener {
                toggleRace()
            }
            btnStop.setOnClickListener {
                toggleRace()
            }
            btnFinish.setOnClickListener{
                time=tvRecordLabel.text.toString()
                binding.btnStart.visibility = View.GONE
                binding.btnFinish.visibility = View.GONE
                binding.btnSave.visibility = View.VISIBLE
                binding.btnIgnore.visibility = View.VISIBLE
            }
            btnSave.setOnClickListener {

                race.label=time
                viewModel.saveRecord(race).observe(viewLifecycleOwner, Observer {})
                findNavController().navigate(R.id.action_racesFragment_to_savesFragment)
            }
            btnIgnore.setOnClickListener {
                findNavController().navigate(R.id.action_racesFragment_to_achievementsFragment)
            }
        }

    }

    private fun toggleRace() {
        if (isRacing) {
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
        if (!isRacing) {
//            btnToggleRun.text = "Start"
            binding.btnStart.visibility = View.VISIBLE
            binding.btnStop.visibility = View.GONE
            binding.btnFinish.visibility = View.VISIBLE
        } else {
//            btnToggleRun.text = "Stop"
            binding.btnFinish.visibility = View.GONE
            binding.btnStart.visibility = View.GONE
            binding.btnStop.visibility = View.VISIBLE
        }
    }

}