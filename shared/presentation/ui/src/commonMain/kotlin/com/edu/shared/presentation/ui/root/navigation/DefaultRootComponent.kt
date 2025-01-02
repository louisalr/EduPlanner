package com.edu.shared.presentation.ui.root.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.edu.shared.presentation.ui.home.navigation.DefaultHomeComponent
import com.edu.shared.presentation.ui.home.navigation.HomeComponent
import com.edu.shared.presentation.ui.login.navigation.DefaultLoginComponent
import com.edu.shared.presentation.ui.login.navigation.LoginComponent
import com.edu.shared.presentation.ui.root.navigation.RootComponent.Child
import com.edu.shared.presentation.ui.splash.navigation.DefaultSplashComponent
import com.edu.shared.presentation.ui.splash.navigation.SplashComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Splash,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, childComponentContext: ComponentContext): Child =
        when (config) {
            is Config.Splash -> Child.Splash(splashComponent(childComponentContext))
            is Config.Home -> Child.Home(homeComponent(childComponentContext))
            is Config.Login -> Child.Login(loginComponent(childComponentContext))
        }

    private fun splashComponent(componentContext: ComponentContext): SplashComponent =
        DefaultSplashComponent(
            componentContext = componentContext,
            onAccountSetNavigation = { navigation.replaceAll(Config.Home)},
            onNotSetNavigation = { navigation.replaceAll(Config.Login)}
        )

    private fun homeComponent(componentContext: ComponentContext): HomeComponent =
        DefaultHomeComponent(
            componentContext = componentContext,
        )

    private fun loginComponent(componentContext: ComponentContext): LoginComponent =
        DefaultLoginComponent(
            componentContext = componentContext,
            onHomeNavigation = { navigation.replaceAll(Config.Home) },
        )


    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Splash : Config

        @Serializable
        data object Login : Config

        @Serializable
        data object Home : Config
    }
}