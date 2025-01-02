package com.edu.shared.presentation.viewmodels.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.shared.domain.authentication.login.LoginUseCase
import com.edu.shared.domain.authentication.login.models.LoginUseCaseModel
import com.edu.shared.presentation.viewmodels.features.login.mappers.LoginTextField
import com.edu.shared.presentation.viewmodels.features.login.mappers.LoginUiMappers
import com.edu.shared.presentation.viewmodels.features.login.models.LoginUiStateModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val loginUiMappers: LoginUiMappers
): ViewModel(){

    private val _viewState = MutableStateFlow(LoginUiStateModel())
    val viewState: StateFlow<LoginUiStateModel> = _viewState.asStateFlow()

    fun onValueChange(field: LoginTextField, value: String){
        val currentState = viewState.value.state as? LoginUiStateModel.State.Init ?: return

        _viewState.update {
            it.copy(
                state = currentState.copy(
                    loginFormUiModel = loginUiMappers.mapTo(currentState.loginFormUiModel, value, field),
                )
            )
        }
    }

    fun login() {
        val currentState = viewState.value.state as? LoginUiStateModel.State.Init ?: return
        val formData = currentState.loginFormUiModel

        viewModelScope.launch {
            val updatedState = when(loginUseCase(formData.username, formData.password)){
                is LoginUseCaseModel.Success -> {
                    LoginUiStateModel.State.Success
                }
                is LoginUseCaseModel.Failure -> LoginUiStateModel.State.Failure
            }

            _viewState.update {
                it.copy(
                    state = updatedState
                )
            }
        }
    }
}