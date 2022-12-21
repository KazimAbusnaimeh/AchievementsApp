package com.mycompany.achievementsapp.api.models

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromAchievementsData(data: Achievements.AchievementsData): List<Achievements.AchievementsData.Records> {
        return data.records
    }

    @TypeConverter
    fun fromRecords(records: Achievements.AchievementsData.Records): String {
        return records.title
    }

    @TypeConverter
    fun toAchievementsData(
        title: String
    ): Achievements.AchievementsData {
        return Achievements.AchievementsData(title, title, title, title)
    }

    @TypeConverter
    fun toRecords(
        id: Int,
        title: String,
        label: String,
        active: Boolean,
        image: String
    ): Achievements.AchievementsData.Records {
        return Achievements.AchievementsData.Records(id, title, label, active, image)
    }
}