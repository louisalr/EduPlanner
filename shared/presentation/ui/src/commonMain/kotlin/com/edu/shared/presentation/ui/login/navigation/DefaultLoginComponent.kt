package com.edu.shared.presentation.ui.login.navigation

import com.arkivanov.decompose.ComponentContext

class DefaultLoginComponent(
    componentContext: ComponentContext,
    private val onHomeNavigation: () -> Unit,
) : LoginComponent, ComponentContext by componentContext {

    override fun home() {
        onHomeNavigation()
    }
}