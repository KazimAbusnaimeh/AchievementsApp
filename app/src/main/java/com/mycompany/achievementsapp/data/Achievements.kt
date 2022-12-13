package com.mycompany.achievementsapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Achievements (
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
        val active:Boolean?=true,
        val image: String
    ):Parcelable{}
}