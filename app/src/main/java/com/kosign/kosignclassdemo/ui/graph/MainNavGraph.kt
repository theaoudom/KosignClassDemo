package com.kosign.kosignclassdemo.ui.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kosign.kosignclassdemo.ui.navextention.attendanceGraph
import com.kosign.kosignclassdemo.ui.navextention.homeGraph
import com.module.common.navigation.Graph

@Composable
fun MainNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController       = navController,
        startDestination    = Graph.ATTENDANCE_GRAPH
    ){
        homeGraph(navController)
        attendanceGraph(navController)
    }
}