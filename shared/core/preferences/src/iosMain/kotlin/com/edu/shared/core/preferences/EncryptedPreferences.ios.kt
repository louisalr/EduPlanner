package com.edu.shared.core.preferences

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

actual class EncryptedPreferences {
    @OptIn(ExperimentalSettingsImplementation::class)
    actual fun getSharedPreferences(key: String): Settings {
        return KeychainSettings(key = key)
    }
}