package com.example.cariinfoapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InfoDAO {
    @Query("SELECT * FROM info_table ORDER BY id DESC")
    suspend fun getAllNews(): List<InfoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<InfoEntity>)

    @Query("DELETE FROM info_table")
    suspend fun clearNews()
}