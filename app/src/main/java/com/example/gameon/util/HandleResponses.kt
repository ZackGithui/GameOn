package com.example.gameon.util

/*suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    api: () -> Resource.Error<List<Games>>
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
}*/