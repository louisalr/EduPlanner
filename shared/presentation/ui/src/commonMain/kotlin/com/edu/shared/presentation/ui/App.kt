package com.edu.shared.presentation.ui

import androidx.compose.runtime.Composable
import com.edu.shared.presentation.ui.di.mainModules
import com.edu.shared.presentation.ui.home.HomeScreen
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
fun App(
    appDeclaration: KoinAppDeclaration = {}
){

    KoinApplication(application= mainModules(appDeclaration)){
        HomeScreen()
    }

}