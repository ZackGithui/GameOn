package com.example.gameon.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    api: suspend () -> T
): Resource<T> {
    return withContext(dispatcher) {
        try {
            Resource.Success(api.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Resource.Error("No internet connection")
                is HttpException -> Resource.Error("Server error occurred")
                else -> Resource.Error(throwable.message ?: "Unexpected error occurred")

            }

        }
    }

}