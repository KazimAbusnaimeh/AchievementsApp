package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.adapters.AchievementsDataAdapter
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import com.mycompany.achievementsapp.datasource.models.Achievements
import com.mycompany.achievementsapp.ui.viewmodels.AchievementsViewModel
import com.mycompany.achievementsapp.utils.Constants.ACHIEVEMENT_FRAGMENT_TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    private val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    lateinit var binding: FragmentAchievementBinding
    lateinit var achievementsDataAdapter: AchievementsDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAchievementBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    private fun setRecyclerView() {
        binding.rvAchievementData.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = achievementsDataAdapter
        }
    }

    private fun bindData() {
        viewModel.setAchievement()
        viewModel.successAchievement.observe(viewLifecycleOwner, ::handleAchievement)
        viewModel.loadingAchievement.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.errorAchievement.observe(viewLifecycleOwner, ::handleError)
    }

    private fun handleAchievement(achievements: Achievements) {
        achievementsDataAdapter = AchievementsDataAdapter(achievements.data)
        setRecyclerView()
        achievementsDataAdapter.differ.submitList(achievements.data)
    }

    private fun handleLoading(flag: Boolean) {
        binding.progressBar.isVisible = flag
    }

    private fun handleError(exception: String) {
        val flag= exception.isNotEmpty()
        binding.tvError.isVisible=flag
    }

}