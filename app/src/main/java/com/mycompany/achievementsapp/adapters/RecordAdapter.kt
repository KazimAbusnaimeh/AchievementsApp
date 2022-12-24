package com.mycompany.achievementsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mycompany.achievementsapp.databinding.ItemRecordBinding
import com.mycompany.achievementsapp.datasource.models.Achievements

class RecordAdapter() : RecyclerView.Adapter<RecordAdapter.RecordViewHolder>() {

    inner class RecordViewHolder(private val binding: ItemRecordBinding) :
        ViewHolder(binding.root) {
        fun bind(item: Achievements.AchievementsData.Records) {
            binding.record = item
        }
    }

    private val differCallback =
        object : DiffUtil.ItemCallback<Achievements.AchievementsData.Records>() {
            override fun areItemsTheSame(
                oldItem: Achievements.AchievementsData.Records,
                newItem: Achievements.AchievementsData.Records
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Achievements.AchievementsData.Records,
                newItem: Achievements.AchievementsData.Records
            ): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecordViewHolder(
        ItemRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}