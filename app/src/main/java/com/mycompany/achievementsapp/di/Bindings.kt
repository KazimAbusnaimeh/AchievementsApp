package com.mycompany.achievementsapp.di

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mycompany.achievementsapp.R

@BindingAdapter("app:loadImageFromUri")
fun loadImageFromUrl(imageView: ImageView,image: String?){
    Glide.with(imageView.context)
        .load(image)
        .error(R.drawable.ic_launcher_background)
        .into(imageView)
}