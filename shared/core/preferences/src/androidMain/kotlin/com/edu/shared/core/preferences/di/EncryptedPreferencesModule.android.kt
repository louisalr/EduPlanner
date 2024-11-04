package com.edu.shared.core.preferences.di

import com.edu.shared.core.preferences.EncryptedPreferences
import org.koin.core.module.Module
import org.koin.dsl.module

actual val encryptedPreferencesModule: Module = module {
    single { EncryptedPreferences(get()) }
}