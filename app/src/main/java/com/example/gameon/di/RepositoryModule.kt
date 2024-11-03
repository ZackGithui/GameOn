package com.example.gameon.di

import com.example.gameon.data.repository.RepositoryImpl
import com.example.gameon.domain.repository.GamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFreeToGame(repositoryImpl:RepositoryImpl):GamesRepository
}