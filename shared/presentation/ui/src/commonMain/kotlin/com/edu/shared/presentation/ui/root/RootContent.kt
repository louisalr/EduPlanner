package com.edu.shared.presentation.ui.root

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.edu.shared.presentation.ui.home.HomeScreen
import com.edu.shared.presentation.ui.login.LoginScreen
import com.edu.shared.presentation.ui.root.navigation.RootComponent
import com.edu.shared.presentation.ui.root.navigation.RootComponent.Child
import com.edu.shared.presentation.ui.splash.SplashScreen

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.systemBars)) {
        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade() + scale())
        ) {
            when (val instance = it.instance) {
                is Child.Splash -> SplashScreen(component = instance.component)
                is Child.Home -> HomeScreen(component = instance.component)
                is Child.Login -> LoginScreen(component = instance.component)
            }
        }
    }
}