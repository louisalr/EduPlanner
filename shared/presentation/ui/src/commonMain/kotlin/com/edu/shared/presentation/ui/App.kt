package com.edu.shared.presentation.ui

import androidx.compose.runtime.Composable
import com.edu.shared.presentation.ui.di.mainModules
import com.edu.shared.presentation.ui.root.RootContent
import com.edu.shared.presentation.ui.root.navigation.RootComponent
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
fun App(
    appDeclaration: KoinAppDeclaration = {},
    rootComponent: RootComponent,
){

    KoinApplication(application= mainModules(appDeclaration)){
        RootContent(rootComponent)
    }

}