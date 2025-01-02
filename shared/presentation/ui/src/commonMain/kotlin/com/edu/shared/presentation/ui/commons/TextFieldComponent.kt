package com.edu.shared.presentation.ui.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldComponent(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean? = false
){
    TextField(
        visualTransformation = if (isPassword == true) PasswordVisualTransformation() else VisualTransformation.None,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) // Espacement autour du TextField
            .background(Color.White, shape = RoundedCornerShape(8.dp)) // Fond blanc et coins arrondis
            .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp)), // Bordure noire légère
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent, // Fond du container transparent
            textColor = Color.Black, // Couleur du texte
            placeholderColor = Color.Gray, // Couleur du placeholder
            focusedIndicatorColor = Color.Transparent, // Barre sous le champ focus
            unfocusedIndicatorColor = Color.Transparent, // Barre sous le champ non focus
            disabledIndicatorColor = Color.Transparent // Barre sous le champ désactivé
        )
    )
}