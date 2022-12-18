package com.mycompany.achievementsapp.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize


@Parcelize
//@Entity(tableName = "achievements")
data class Achievements (
    val data:List<AchievementsData>
        ):Parcelable{

    @Parcelize
    data class AchievementsData(
        val id: Int,
        val title: String,
        val label:String,
        val records:List<Records>
    ):Parcelable{

    @Parcelize
    data class Records(
        val id: Int,
        val title: String,
        val label: String,
        val active:Boolean,
        val image: String
    ):Parcelable{}
}}