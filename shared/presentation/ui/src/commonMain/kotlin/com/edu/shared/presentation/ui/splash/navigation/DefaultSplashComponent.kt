package com.edu.shared.presentation.ui.splash.navigation

import com.arkivanov.decompose.ComponentContext

class DefaultSplashComponent(
    componentContext: ComponentContext,
    private val onAccountSetNavigation: () -> Unit,
    private val onNotSetNavigation: () -> Unit,
) : SplashComponent, ComponentContext by componentContext {

    override fun onAccountSet() {
        onAccountSetNavigation()
    }

    override fun onNotSet() {
        onNotSetNavigation()
    }
}