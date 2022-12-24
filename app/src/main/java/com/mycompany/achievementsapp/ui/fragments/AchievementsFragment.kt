package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.adapters.AchievementsDataAdapter
import com.mycompany.achievementsapp.adapters.RecordAdapter
import com.mycompany.achievementsapp.databinding.FragmentAchievementBinding
import com.mycompany.achievementsapp.databinding.ItemAchievementDataBinding
import com.mycompany.achievementsapp.databinding.ItemRecordBinding
import com.mycompany.achievementsapp.ui.viewmodels.AchievementsViewModel
import com.mycompany.achievementsapp.utils.Constants.ACHIEVEMENT_FRAGMENT_ARG_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AchievementsFragment : Fragment(R.layout.fragment_achievement) {


    val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private lateinit var iconsList: List<ImageView>
    private lateinit var labelsList: List<TextView>
    private lateinit var titlesList: List<TextView>


    lateinit var binding: FragmentAchievementBinding
    lateinit var achievementsDataAdapter: AchievementsDataAdapter
    lateinit var recordAdapter: RecordAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAchievementBinding.bind(view)

        setUpRecyclerView()
        onItemClick()
        activate()
        bindData()

    }

    private fun setUpRecyclerView() {


//        val binding2:ItemAchievementDataBinding =
//            DataBindingUtil.setContentView(requireActivity(), R.layout.item_achievement_data)
//        binding2.rvRecords.apply {
//            adapter=recordAdapter
//            layoutManager=GridLayoutManager(requireContext(),2)
//        }

    }

    fun activate(){
        viewModel.setAchievement()
        viewModel.achievement.observe(viewLifecycleOwner, Observer {
            achievementsDataAdapter= AchievementsDataAdapter(requireActivity(), it.data)
            recordAdapter= RecordAdapter()

            val binding1:FragmentAchievementBinding =
                DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_achievement)
            binding1.rvAchievementData.apply {
                adapter=achievementsDataAdapter
                layoutManager=LinearLayoutManager(requireContext())
            }
            achievementsDataAdapter.differ.submitList(it.data)

        })
    }

    private fun bindData() {

//        binding.apply {
//            viewModel.setAchievement()
//            viewModel.achievement.observe(viewLifecycleOwner, Observer {
//                data1 = it.data[0]
//                data2 = it.data[1]
//                record1 = it.data[0].records[0]
//                record2 = it.data[0].records[1]
//                record3 = it.data[0].records[2]
//                record4 = it.data[0].records[3]
//                record5 = it.data[0].records[4]
//                record6 = it.data[0].records[5]
//                record7 = it.data[1].records[0]
//                record8 = it.data[1].records[1]
//                record9 = it.data[1].records[2]
//                record10 = it.data[1].records[3]
//                record11 = it.data[1].records[4]
//                record12 = it.data[1].records[5]
//
//                val recordsList =
//                    listOf(
//                        record1, record2, record3, record4, record5, record6, record7,
//                        record8, record9, record10, record11, record12
//                    )
//

//            })
//        }
    }

    private fun onItemClick() {
        binding.apply {
//            viewModel.setAchievement()
//            viewModel.achievement.observe(viewLifecycleOwner, Observer {
//                data1 = it.data[0]
//                data2 = it.data[1]
//                record1 = it.data[0].records[0]
//                record2 = it.data[0].records[1]
//                record3 = it.data[0].records[2]
//                record4 = it.data[0].records[3]
//                record5 = it.data[0].records[4]
//                record6 = it.data[0].records[5]
//                record7 = it.data[1].records[0]
//                record8 = it.data[1].records[1]
//                record9 = it.data[1].records[2]
//                record10 = it.data[1].records[3]
//                record11 = it.data[1].records[4]
//                record12 = it.data[1].records[5]
//
//                val recordsList =
//                    listOf(
//                        record1, record2, record3, record4, record5, record6, record7,
//                        record8, record9, record10, record11, record12
//                    )
//                for ((i) in iconsList.withIndex()) {
//                    iconsList[i].setOnClickListener {
//                        val record = recordsList[i]
//                        val bundle = bundleOf(ACHIEVEMENT_FRAGMENT_ARG_KEY to record)
//
//                        findNavController().navigate(
//                            R.id.action_achievementsFragment_to_racesFragment,
//                            bundle
//                        )
//                    }
//                }
//            })
        }
    }
}