package com.example.gameon.di

import android.content.Context
import androidx.room.Room
import com.example.gameon.data.local.FavouriteDAO
import com.example.gameon.data.local.GameDatabase
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
    fun provideDatabase(@ApplicationContext context: Context): GameDatabase {
        return Room.databaseBuilder(context, GameDatabase::class.java, "Game")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavouriteDAO(database: GameDatabase): FavouriteDAO {
        return database.favouriteDAO()
    }
}