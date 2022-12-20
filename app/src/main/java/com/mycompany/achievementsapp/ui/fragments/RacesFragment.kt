package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.data.Achievements
import com.mycompany.achievementsapp.databinding.FragmentRacesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RacesFragment:Fragment(R.layout.fragment_races) {

    lateinit var binding: FragmentRacesBinding
    lateinit var record :Achievements.AchievementsData.Records
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentRacesBinding.bind(view)

        setLabel()

    }
    private fun setLabel(){
        arguments?.let {
            record=it.getParcelable("record")!!
        }
        binding.record=record
    }
}