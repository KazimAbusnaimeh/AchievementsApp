package com.mycompany.achievementsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.adapters.SavesAdapter
import com.mycompany.achievementsapp.databinding.FragmentSavesBinding
import com.mycompany.achievementsapp.ui.viewmodels.AchievementsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavesFragment:Fragment(R.layout.fragment_saves) {
    lateinit var binding: FragmentSavesBinding
    private val viewModel: AchievementsViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private lateinit var savesAdapter: SavesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSavesBinding.bind(view)
        setUpRecyclerView()
        viewModel.getAllRecords().observe(viewLifecycleOwner, Observer {
            savesAdapter.submitList(it)
        })
    }
    private fun setUpRecyclerView(){
        binding.rvSaves.apply {
            savesAdapter= SavesAdapter()
            layoutManager=LinearLayoutManager(requireContext())
            adapter=savesAdapter
        }
    }
}