package com.mycompany.achievementsapp.api.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Achievements(
    val data: List<AchievementsData>
) : Parcelable {

    @Parcelize
    data class AchievementsData(
        val id: Int,
        val title: String,
        val label: String,
        val records: List<Records>
    ) : Parcelable {

        @Parcelize
        @Entity(tableName = "achievements")
        data class Records(
            @PrimaryKey(autoGenerate = true)
            val id: Int,
            val title: String,
            var label: String,
            val active: Boolean,
            val image: String
        ) : Parcelable {}
    }
}