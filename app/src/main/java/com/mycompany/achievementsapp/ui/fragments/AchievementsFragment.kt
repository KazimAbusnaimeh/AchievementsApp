package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.adapters.AchievementsDataAdapter
import com.mycompany.achievementsapp.adapters.RecordAdapter
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import com.mycompany.achievementsapp.ui.viewmodels.AchievementsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    lateinit var binding: FragmentAchievementBinding
    lateinit var achievementsDataAdapter: AchievementsDataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAchievementBinding.bind(view)

        bindData()
    }

    private fun bindData() {
        viewModel.setAchievement()
        viewModel.achievement.observe(viewLifecycleOwner, Observer {
            achievementsDataAdapter = AchievementsDataAdapter(requireActivity(), it.data)
            setRecyclerView()
            achievementsDataAdapter.differ.submitList(it.data)

        })
    }

    private fun setRecyclerView(){
        val binding1: FragmentAchievementBinding =
            DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_achievement)
        binding1.rvAchievementData.apply {
            adapter = achievementsDataAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}