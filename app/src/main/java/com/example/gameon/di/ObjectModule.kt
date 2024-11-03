package com.example.gameon.di

import com.example.gameon.data.remote.FreeToGame
import com.example.gameon.util.BASE_URL
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object ObjectModule {

    @Provides
    @Singleton

    fun provideApi():FreeToGame{
        val moshi =Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return (
                Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()
                    .create(FreeToGame::class.java)
                )

    }



}