package com.mycompany.achievementsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mycompany.achievementsapp.api.models.Achievements
import com.mycompany.achievementsapp.databinding.ItemSaveBinding

class SavesAdapter(private val interaction: Interaction?=null):ListAdapter<Achievements.AchievementsData.Records,SavesAdapter.SavesViewHolder>(SavesDC()) {

    inner class SavesViewHolder(private val binding:ItemSaveBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item:Achievements.AchievementsData.Records){
            binding.record=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= SavesViewHolder (
        ItemSaveBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: SavesViewHolder, position: Int) =
        holder.bind(getItem(position))

    interface Interaction{}

    private class SavesDC:DiffUtil.ItemCallback<Achievements.AchievementsData.Records>(){
        override fun areItemsTheSame(
            oldItem: Achievements.AchievementsData.Records,
            newItem: Achievements.AchievementsData.Records
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Achievements.AchievementsData.Records,
            newItem: Achievements.AchievementsData.Records
        ): Boolean {
            return oldItem==newItem
        }
    }
}