package com.kosign.kosignclassdemo.ui.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.module.common.navigation.Screen
import com.module.features.splash.presentation.SplashScreen

@Composable
fun RootNavGraph(
    onNavigateToHome    : () -> Unit,
    onNavigateToAdmin   : () -> Unit,
    onNavigateToInitial : () -> Unit
) {

    NavHost(
        navController = rememberNavController(),
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route){
            SplashScreen(
                onStartHomeAdmin    = onNavigateToAdmin,
                onStartHome         = onNavigateToHome,
                onStartInitial      = onNavigateToInitial
            )
        }
    }
}