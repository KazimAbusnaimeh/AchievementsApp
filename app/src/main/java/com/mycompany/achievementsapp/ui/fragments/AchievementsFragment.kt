package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.data.Achievements
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import com.mycompany.achievementsapp.ui.viewmodels.AchievementsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private lateinit var iconsList: List<ImageView>
    private lateinit var labelsList: List<TextView>
    private lateinit var titlesList: List<TextView>


    lateinit var binding: FragmentAchievementBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAchievementBinding.bind(view)

        initLists()
        bindData()
        onItemClick()

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

                val recordsList =
                    listOf(record1, record2, record3, record4, record5, record6, record7,
                        record8, record9, record10, record11, record12)

                for ((index, record) in recordsList.withIndex()) {
                    if (!record!!.active!!) {
                        iconsList[index].isEnabled = false
                        iconsList[index].alpha = 0.4f
                    }
                }
            })
        }
    }

    private fun onItemClick() {
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

                val recordsList =
                    listOf(record1, record2, record3, record4, record5, record6, record7,
                        record8, record9, record10, record11, record12)
            for ((i) in iconsList.withIndex()) {
                iconsList[i].setOnClickListener {
                    val record=recordsList[i]
                    val bundle =bundleOf("record" to record)

                    findNavController().navigate(R.id.action_achievementsFragment_to_racesFragment,bundle)
                }
            }
        })}
    }

    private fun initLists() {
        binding.apply {
            iconsList =
                listOf(ivIcon1, ivIcon2, ivIcon3, ivIcon4, ivIcon5, ivIcon6, ivIcon7, ivIcon8,
                    ivIcon9, ivIcon10, ivIcon11, ivIcon12)
            labelsList=
                listOf(tvLabel1,tvLabel2,tvLabel3,tvLabel4,tvLabel5,tvLabel6,tvLabel7,tvLabel8
                ,tvLabel9,tvLabel10,tvLabel11,tvLabel12)
            titlesList=
                listOf(tvTitle1,tvTitle2,tvTitle3,tvTitle4,tvTitle5,tvTitle6,tvTitle7,tvTitle8
                ,tvTitle9,tvTitle10,tvTitle11,tvTitle12)
        }
    }
}