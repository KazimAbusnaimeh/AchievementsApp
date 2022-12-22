package com.mycompany.achievementsapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mycompany.achievementsapp.datasource.models.Achievements

@Dao
interface AchievementsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecords(record: Achievements.AchievementsData.Records)

    @Query("Select * from achievements")
     fun getAllRecords(): LiveData<List<Achievements.AchievementsData.Records>>

}