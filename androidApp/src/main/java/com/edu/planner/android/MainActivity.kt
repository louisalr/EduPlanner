package com.edu.planner.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.edu.shared.presentation.ui.MainAndroid
import com.edu.shared.presentation.ui.root.navigation.DefaultRootComponent
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = DefaultRootComponent(defaultComponentContext())
        setContent {
            MyApplicationTheme {
                MainAndroid(
                    appDeclaration = { androidContext(this@MainActivity)},
                    rootComponent = root
                )
            }
        }
    }
}