package com.mycompany.achievementsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mycompany.achievementsapp.databinding.ItemAchievementDataBinding
import com.mycompany.achievementsapp.datasource.models.Achievements

class AchievementsDataAdapter(records: List<Achievements.AchievementsData>) :
    RecyclerView.Adapter<AchievementsDataAdapter.AchievementDataViewHolder>() {

    lateinit var recordAdapter: RecordAdapter
    var dataList: List<Achievements.AchievementsData>

    init {
        dataList = records
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AchievementDataViewHolder(
        ItemAchievementDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AchievementDataViewHolder, position: Int) {
        holder.bind(differ.currentList[position], position)
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val differCallback = object : DiffUtil.ItemCallback<Achievements.AchievementsData>() {
        override fun areItemsTheSame(
            oldItem: Achievements.AchievementsData,
            newItem: Achievements.AchievementsData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Achievements.AchievementsData,
            newItem: Achievements.AchievementsData
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    inner class AchievementDataViewHolder(private val binding: ItemAchievementDataBinding) :
        ViewHolder(binding.root) {
        fun bind(item: Achievements.AchievementsData, position: Int) {
            recordAdapter = RecordAdapter()
            binding.data = item
            binding.rvRecords.apply {
                adapter = recordAdapter
            }
            when {
                position == 0 -> {
                    recordAdapter.differ.submitList(dataList[position].records)
                }
                position == 1 -> {
                    recordAdapter.differ.submitList(dataList[position].records)
                }
            }
        }
    }
}