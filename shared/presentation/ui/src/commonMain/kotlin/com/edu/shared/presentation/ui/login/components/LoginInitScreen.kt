package com.edu.shared.presentation.ui.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.shared.presentation.ui.commons.TextFieldComponent
import com.edu.shared.presentation.viewmodels.features.login.mappers.LoginTextField
import com.edu.shared.presentation.viewmodels.features.login.models.LoginUiStateModel

@Composable
fun LoginInitScreen(
    state: LoginUiStateModel.State.Init,
    onValueChange: (LoginTextField, String) -> Unit,
    onLogin: () -> Unit
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Centre verticalement
            horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
        ) {
            Text(
                text = "Connexion",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Champ nom d'utilisateur
            TextFieldComponent(
                value = state.loginFormUiModel.username,
                placeholder = "prenom.nom",
                onValueChange = { onValueChange(LoginTextField.Username, it) }
            )

            TextFieldComponent(
                isPassword = true,
                value = state.loginFormUiModel.password,
                placeholder = "Mot de passe",
                onValueChange = { onValueChange(LoginTextField.Password, it ) }
            )


            Button(
                onClick = {
                    onLogin()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(text = "Se connecter")
            }
        }
    }

}