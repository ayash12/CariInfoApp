package com.example.cariinfoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [InfoEntity::class], version = 1, exportSchema = false)
abstract class InfoDatabase : RoomDatabase() {
    abstract fun infoDAO(): InfoDAO
}