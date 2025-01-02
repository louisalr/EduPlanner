package com.edu.shared.presentation.viewmodels.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.shared.domain.user.usecases.deletetoken.DeleteTokenUseCase
import com.edu.shared.domain.user.usecases.gettoken.GetTokenUseCase
import com.edu.shared.domain.user.usecases.gettoken.models.GetTokenUseCaseModel
import com.edu.shared.presentation.viewmodels.features.splash.mappers.SplashUiMappers
import com.edu.shared.presentation.viewmodels.features.splash.models.SplashUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getTokenUseCase: GetTokenUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
    private val splashUiMappers: SplashUiMappers
): ViewModel(){

    private val _viewState = MutableStateFlow<SplashUiModel>(SplashUiModel.Init)
    val viewState: StateFlow<SplashUiModel> = _viewState.asStateFlow()

    init {
        getToken()
        //testSet()
    }


    private fun testSet(){
        viewModelScope.launch {
            deleteTokenUseCase()
        }
    }

    private fun getToken(){
        viewModelScope.launch {
            val state = when(getTokenUseCase()){
                is GetTokenUseCaseModel.Success -> splashUiMappers.mapToSuccess()
                is GetTokenUseCaseModel.Failure -> splashUiMappers.mapToError()
            }

            _viewState.update {
               state
            }
        }
    }
}