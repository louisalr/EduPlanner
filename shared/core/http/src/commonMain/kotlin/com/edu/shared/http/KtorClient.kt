package com.edu.shared.http

import com.edu.shared.core.preferences.EncryptedPreferences
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientConfig(private val sharedPreferences: EncryptedPreferences) {

    fun provideHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(HttpTimeout) {
                // Délai d'attente de connexion
                connectTimeoutMillis = 30000 // 10 secondes
                // Délai d'attente pour lire la réponse
                requestTimeoutMillis = 30000 // 10 secondes

                socketTimeoutMillis = 30000
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            accessToken = getAccessToken(),
                            refreshToken = getRefreshToken()
                        )
                    }
                    refreshTokens {
                        refreshAccessToken()
                    }
                }
            }

            install(Logging) {
                level = LogLevel.INFO
            }
        }
    }

    private fun getAccessToken(): String {
        return sharedPreferences.getSharedPreferences("token").getString("token", "")
    }

    private fun getRefreshToken(): String {
        return sharedPreferences.getSharedPreferences("refresh_token").getString("refresh_token", "")
    }

    private fun refreshAccessToken(): BearerTokens? {

        val refreshToken = getRefreshToken()
        return try {
            // Appel à l'API de rafraîchissement des tokens
            val newTokens = refreshAccessToken(refreshToken)

            // Sauvegarde des nouveaux tokens dans SharedPreferences
            sharedPreferences.getSharedPreferences("token").apply {
                putString("token", newTokens.accessToken)
                newTokens.refreshToken?.let { putString("refresh_token", it) }
            }

            // Retourne les nouveaux tokens
            BearerTokens(newTokens.accessToken, newTokens.refreshToken)
        } catch (e: Exception) {
            e.printStackTrace()
            null // Retourne null si le rafraîchissement échoue
        }
    }

    private fun refreshAccessToken(refreshToken: String): BearerTokens {
        // Implémente l'appel réseau pour rafraîchir les tokens ici.
        // Remplace par l'implémentation réelle
        val newAccessToken = "nouveau_token" // Exemple de nouveau token
        val newRefreshToken = "nouveau_refresh_token" // Exemple de nouveau refresh token
        return BearerTokens(newAccessToken, newRefreshToken)
    }
}
