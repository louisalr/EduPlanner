package com.edu.shared.presentation.ui.login

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
import com.edu.shared.presentation.ui.login.components.LoginInitScreen
import com.edu.shared.presentation.ui.login.navigation.LoginComponent
import com.edu.shared.presentation.viewmodels.features.login.LoginViewModel
import com.edu.shared.presentation.viewmodels.features.login.models.LoginUiStateModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    component: LoginComponent,
    loginViewModel: LoginViewModel = koinViewModel()
){
    val viewState by loginViewModel.viewState.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize(), // Occupe tout l'espace disponible
            verticalArrangement = Arrangement.Center, // Centre verticalement
            horizontalAlignment = Alignment.CenterHorizontally // Centre horizontalement
        )  {
            when(val state = viewState.state){
                is LoginUiStateModel.State.Success -> component.home()
                is LoginUiStateModel.State.Failure -> { Text("ERROR")}
                is LoginUiStateModel.State.Init -> {
                    LoginInitScreen(
                        state = state,
                        onValueChange = loginViewModel::onValueChange,
                        onLogin = loginViewModel::login,
                    )
                }
            }
        }
    }
}