package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.api.Api
import com.mycompany.achievementsapp.data.Achievements
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private val TAG = "AchievementsFragment"
    lateinit var binding: FragmentAchievementBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAchievementBinding.bind(view)

        viewModel.setAchievement()
        viewModel.achievement.observe(viewLifecycleOwner, Observer {
            val stringBuilder = StringBuilder()
            val title = stringBuilder.append(it!!.data[0].title)
            binding.tvTitle1.text = title
        })

    }
}