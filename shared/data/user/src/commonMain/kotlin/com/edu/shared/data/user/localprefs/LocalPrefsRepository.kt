package com.edu.shared.data.user.localprefs

import com.edu.shared.data.user.localprefs.models.LocalPrefsRepositoryModel

interface LocalPrefsRepository{
    suspend fun getTokens(): LocalPrefsRepositoryModel

    suspend fun setTokens(token: String, refreshToken: String)
}