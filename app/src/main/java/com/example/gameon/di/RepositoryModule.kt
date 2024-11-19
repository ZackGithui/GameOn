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
    /* This binds the implementation of GamesRepository to Repositoryimpl
    ensuring that dagger hilt provides the RepositoryImpl whenever
    GamesRepository is called as a dependency

     */
    @Binds
    @Singleton
    abstract fun bindGamesRepository(repositoryImpl: RepositoryImpl): GamesRepository
}