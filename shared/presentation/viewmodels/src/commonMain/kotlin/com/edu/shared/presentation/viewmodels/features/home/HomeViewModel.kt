package com.edu.shared.presentation.viewmodels.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.shared.domain.user.usecases.gettoken.GetTokenUseCase
import com.edu.shared.domain.user.usecases.settoken.SetTokenUseCase
import com.edu.shared.presentation.viewmodels.features.home.models.HomeModelUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTokenUseCase: GetTokenUseCase,
    private val setTokenUseCase: SetTokenUseCase
): ViewModel(){

    private val _viewState = MutableStateFlow(HomeModelUiState())
    val viewState: StateFlow<HomeModelUiState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            //setTokenUseCase("test", "test")
            println("MYLOG ${getTokenUseCase()}")
        }
    }
}