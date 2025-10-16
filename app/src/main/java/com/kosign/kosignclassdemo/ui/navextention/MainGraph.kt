package com.kosign.kosignclassdemo.ui.navextention

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.module.common.navigation.Graph
import com.module.common.navigation.Screen

/**
 * Home Graph
 */
fun NavGraphBuilder.homeGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.HOME_GRAPH,
        startDestination = Screen.HomeScreen.route
    ){
        homeMenu()
    }
}

/**
 * Dashboard Graph
 */
fun NavGraphBuilder.attendanceGraph(
    navController: NavHostController
){
    navigation(
        route = Graph.ATTENDANCE_GRAPH,
        startDestination = Screen.AttendanceScreen.route
    ){
        attendanceMenu(navController)
        attendanceDetailScreen(navController)
    }
}