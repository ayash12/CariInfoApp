package com.example.cariinfoapp.di

import android.content.Context
import androidx.room.Room
import com.example.cariinfoapp.data.local.InfoDAO
import com.example.cariinfoapp.data.local.InfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context): InfoDatabase =
        Room.databaseBuilder(context, InfoDatabase::class.java, "info_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideNewsDao(db: InfoDatabase): InfoDAO = db.infoDAO()


}