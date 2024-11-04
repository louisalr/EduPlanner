package com.edu.shared.http

import com.edu.shared.core.preferences.EncryptedPreferences
import io.ktor.client.HttpClient
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.logging.*
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.*

fun KtorClient(sharedPreferences: EncryptedPreferences): HttpClient {
    return HttpClient(CIO) {
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = sharedPreferences.getString("token", "") ?: "",
                        refreshToken = sharedPreferences.getString("refresh_token", "") ?: ""
                    )
                }
                refreshTokens {
                    // Code pour rafraîchir le token si nécessaire
                    val newAccessToken = "nouveau_token" // Remplacez par l'implémentation réelle
                    val newRefreshToken = "nouveau_refresh_token" // Remplacez par l'implémentation réelle

                    sharedPreferences.edit().putString("token", newAccessToken).apply()
                    sharedPreferences.edit().putString("refresh_token", newRefreshToken).apply()

                    BearerTokens(newAccessToken, newRefreshToken)
                }
            }
        }

        install(Logging) {
            level = LogLevel.INFO
        }
    }
}