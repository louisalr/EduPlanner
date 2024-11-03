package com.edu.shared.presentation.ui

import androidx.compose.runtime.Composable
import com.edu.shared.presentation.ui.di.mainModules
import com.edu.shared.presentation.ui.home.HomeScreen
import org.koin.compose.KoinApplication

@Composable
fun App(){

    KoinApplication(application= mainModules){
        HomeScreen()
    }

}