package com.edu.shared.presentation.viewmodels.features.login.mappers

import com.edu.shared.presentation.viewmodels.features.login.models.LoginFormUIModel

class LoginUiMappers {

    fun mapTo(loginFormUIModel: LoginFormUIModel, value: String, loginTextFields: LoginTextField): LoginFormUIModel =
        when(loginTextFields) {
            LoginTextField.Username -> loginFormUIModel.copy(username = value)
            LoginTextField.Password -> loginFormUIModel.copy(password = value)
        }
}
enum class LoginTextField{
    Username,
    Password
}