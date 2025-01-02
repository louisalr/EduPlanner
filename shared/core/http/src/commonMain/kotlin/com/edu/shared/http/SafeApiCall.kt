package com.edu.shared.http

suspend fun <T> safeApiCall(call: suspend () -> T): Result<T> {
    return try {
        Result.success(call())
    } catch (e: Exception) {
        // Vous pouvez personnaliser le message d'erreur ou l'action à prendre
        Result.failure(e)
    }
}