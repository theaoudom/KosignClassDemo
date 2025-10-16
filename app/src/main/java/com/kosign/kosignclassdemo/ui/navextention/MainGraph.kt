package com.kosign.kosignclassdemo.ui.navextention

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.module.common.navigation.Graph
import com.module.common.navigation.Screen

/**
 * All Graph related navigation here
 */

/**
 * Splash Graph
 */
fun NavGraphBuilder.splashGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.SPLASH_GRAPH,
        startDestination = Screen.SplashScreen.route
    ){
        splashScreen(navController)
    }
}

/**
 * Auth Graph
 */
fun NavGraphBuilder.authGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = Screen.OnBoardingScreen.route
    ){
        //  Boarding, Register, login ...
    }
}

/**
 * Feature Graph
 */
fun NavGraphBuilder.featureGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.FEATURE_GRAPH,
        startDestination = Screen.AttendanceScreen.route
    ){
        home()
        attendance()
    }
}

/**
 * Feature Admin Graph
 */
fun NavGraphBuilder.adminFeatureGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.FEATURE_ADMIN_GRAPH,
        startDestination = Screen.HomeScreen.route
    ){
        attendanceAdmin()
    }
}
