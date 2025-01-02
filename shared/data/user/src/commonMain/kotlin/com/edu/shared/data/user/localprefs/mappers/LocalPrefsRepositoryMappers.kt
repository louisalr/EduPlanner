package com.edu.shared.data.user.localprefs.mappers

import com.edu.shared.data.user.localprefs.models.LocalPrefsRepositoryModel
import com.edu.shared.data.user.localprefs.models.TokenRepositoryModel

class LocalPrefsRepositoryMappers{

    fun map(token: String, refreshToken: String): LocalPrefsRepositoryModel.Success =
        LocalPrefsRepositoryModel.Success(
            token = TokenRepositoryModel(
                token = token,
                refreshToken = refreshToken
            )
        )
}