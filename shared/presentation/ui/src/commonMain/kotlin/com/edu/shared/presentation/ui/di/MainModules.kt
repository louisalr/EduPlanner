package com.edu.shared.presentation.ui.di

import com.edu.shared.presentation.viewmodels.di.viewModelsModule
import org.koin.dsl.KoinAppDeclaration

val mainModules: KoinAppDeclaration = {
    modules(
        viewModelsModule
    )
}