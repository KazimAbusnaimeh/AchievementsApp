package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)


    private val TAG = "AchievementsFragment"
    lateinit var binding: FragmentAchievementBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAchievementBinding.bind(view)

        bindData()
        activationState()

    }

    private fun bindData() {

        binding.apply {
            viewModel.setAchievement()
            viewModel.achievement.observe(viewLifecycleOwner, Observer {
                data1 = it.data[0]
                data2 = it.data[1]
                record1 = it.data[0].records[0]
                record2 = it.data[0].records[1]
                record3 = it.data[0].records[2]
                record4 = it.data[0].records[3]
                record5 = it.data[0].records[4]
                record6 = it.data[0].records[5]
                record7 = it.data[1].records[0]
                record8 = it.data[1].records[1]
                record9 = it.data[1].records[2]
                record10 = it.data[1].records[3]
                record11 = it.data[1].records[4]
                record12 = it.data[1].records[5]
            })
        }
    }

    private fun activationState() {
        binding.apply {
            viewModel.setRecordsList()
            viewModel.record.observe(viewLifecycleOwner, Observer {
                val recordsList =
                    listOf(it[0],it[1],it[2],it[3],it[4],it[5],it[6],it[7],it[8],it[9],it[10],it[11])
                val iconsList =
                    listOf(ivIcon1, ivIcon2, ivIcon3, ivIcon4, ivIcon5, ivIcon6, ivIcon7, ivIcon8,
                        ivIcon9, ivIcon10, ivIcon11, ivIcon12)
                for ((x, i) in recordsList.withIndex()) {
                        if (!i.active) {
                            iconsList[x].isEnabled = false
                            iconsList[x].alpha = 0.4f}
                }
            })
        }
    }
}