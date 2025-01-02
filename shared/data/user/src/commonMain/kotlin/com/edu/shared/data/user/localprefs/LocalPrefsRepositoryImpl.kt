package com.edu.shared.data.user.localprefs

import com.edu.shared.core.preferences.EncryptedPreferences
import com.edu.shared.data.user.localprefs.mappers.LocalPrefsRepositoryMappers
import com.edu.shared.data.user.localprefs.models.LocalPrefsRepositoryModel

class LocalPrefsRepositoryImpl(
    private val encryptedPreferences: EncryptedPreferences,
    private val localPrefsRepositoryMappers: LocalPrefsRepositoryMappers
): LocalPrefsRepository {

    override suspend fun getTokens(): LocalPrefsRepositoryModel {
        val settings = encryptedPreferences.getSharedPreferences("token")
        return if (settings.hasKey("token") && settings.hasKey("refresh_token")) {
            val token = encryptedPreferences.getSharedPreferences("token").getString("token", "")
            val refreshToken = encryptedPreferences.getSharedPreferences("token").getString("refresh_token", "")
            localPrefsRepositoryMappers.map(token, refreshToken)
        } else {
            LocalPrefsRepositoryModel.Failure
        }
    }

    override suspend fun setTokens(token: String, refreshToken: String) {
        val settings = encryptedPreferences.getSharedPreferences("token")
        settings.putString("token", token)
        settings.putString("refresh_token", refreshToken)
    }
}