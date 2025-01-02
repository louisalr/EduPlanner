package com.edu.shared.presentation.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.edu.shared.presentation.ui.splash.navigation.SplashComponent
import com.edu.shared.presentation.viewmodels.features.splash.SplashViewModel
import com.edu.shared.presentation.viewmodels.features.splash.models.SplashUiModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    component: SplashComponent,
    splashScreenViewModel: SplashViewModel = koinViewModel()
){

    val viewState by splashScreenViewModel.viewState.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(viewState){
                is SplashUiModel.Init -> Text("Replace with loader")
                is SplashUiModel.Success -> component.onAccountSet()
                is SplashUiModel.Failure -> component.onNotSet()
            }
        }
    }
}