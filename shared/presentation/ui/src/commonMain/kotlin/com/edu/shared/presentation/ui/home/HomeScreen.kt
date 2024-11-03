package com.edu.shared.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.edu.shared.presentation.viewmodels.features.home.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
){

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)){
            Text("Home Screen")
        }
    }
}