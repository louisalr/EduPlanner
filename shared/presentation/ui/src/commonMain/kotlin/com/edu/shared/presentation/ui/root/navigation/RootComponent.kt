package com.edu.shared.presentation.ui.root.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.edu.shared.presentation.ui.home.navigation.HomeComponent
import com.edu.shared.presentation.ui.login.navigation.LoginComponent
import com.edu.shared.presentation.ui.splash.navigation.SplashComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class Splash(val component: SplashComponent) : Child()
        class Login(val component: LoginComponent) : Child()
        class Home(val component: HomeComponent): Child()
    }
}