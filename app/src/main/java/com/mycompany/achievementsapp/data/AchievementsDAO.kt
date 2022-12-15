//package com.mycompany.achievementsapp.data
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//@Dao
//interface AchievementsDAO {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAchievement(achievements: Achievements)
//
//    @Query("Select * from ACHIEVEMENTS")
//    suspend fun getAllAchievements(): List<Achievements>
//
//}