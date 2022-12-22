package com.mycompany.achievementsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mycompany.achievementsapp.databinding.ItemAchievementDataBinding
import com.mycompany.achievementsapp.datasource.models.Achievements

class AchievementsDataAdapter():RecyclerView.Adapter<AchievementsDataAdapter.AchievementDataViewHolder>() {



    inner class AchievementDataViewHolder(private val binding:ItemAchievementDataBinding) :ViewHolder(binding.root){
        fun bind(item :Achievements.AchievementsData){
            binding.data=item
        }
    }

    private val differCallback=object :DiffUtil.ItemCallback<Achievements.AchievementsData>(){
        override fun areItemsTheSame(
            oldItem: Achievements.AchievementsData,
            newItem: Achievements.AchievementsData
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Achievements.AchievementsData,
            newItem: Achievements.AchievementsData
        ): Boolean {
            return oldItem==newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= AchievementDataViewHolder (
        ItemAchievementDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: AchievementDataViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }


    override fun getItemCount(): Int {return differ.currentList.size}
}