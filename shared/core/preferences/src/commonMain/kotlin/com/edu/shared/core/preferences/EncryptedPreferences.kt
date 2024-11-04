package com.edu.shared.core.preferences

import com.russhwolf.settings.Settings

expect class EncryptedPreferences{
    fun getSharedPreferences(key: String): Settings
}