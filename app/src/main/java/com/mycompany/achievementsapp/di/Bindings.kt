package com.mycompany.achievementsapp.di

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.mycompany.achievementsapp.R
import com.mycompany.achievementsapp.databinding.ItemRecordBinding
import com.mycompany.achievementsapp.datasource.models.Achievements

@BindingAdapter("app:loadImageFromUri")
fun loadImageFromUrl(imageView: ImageView,image: String?){
    Glide.with(imageView.context)
        .load(image)
        .error(R.drawable.ic_launcher_background)
        .into(imageView)
}

@BindingAdapter("app:changeActivation")
fun changeActivation(linearLayout: LinearLayout,records: Achievements.AchievementsData.Records){
        if (!records.active) {
            linearLayout.isEnabled = false
            linearLayout.alpha = 0.4f
    }
}