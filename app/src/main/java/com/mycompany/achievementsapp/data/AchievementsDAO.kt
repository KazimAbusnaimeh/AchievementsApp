package com.mycompany.achievementsapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mycompany.achievementsapp.api.models.Achievements

@Dao
interface AchievementsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecords(record: Achievements.AchievementsData.Records)

    @Query("Select * from achievements")
    suspend fun getAllRecords(): List<Achievements.AchievementsData.Records>

}