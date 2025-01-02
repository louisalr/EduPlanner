package com.edu.shared.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.edu.shared.presentation.ui.home.navigation.HomeComponent
import com.edu.shared.presentation.viewmodels.features.home.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    component: HomeComponent,
    homeViewModel: HomeViewModel = koinViewModel()
){

    Scaffold {
        Column {
            Text("Home screen")
        }
    }

}