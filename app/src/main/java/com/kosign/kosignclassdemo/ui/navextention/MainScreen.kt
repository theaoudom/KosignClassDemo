package com.kosign.kosignclassdemo.ui.navextention

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.module.common.navigation.Screen
import com.module.features.attendance.presentation.AttendanceScreen
import com.module.features.attendance.presentation.AttendanceVm

fun NavGraphBuilder.homeMenu(

) {
    composable(
        route = Screen.HomeScreen.route
    ){
        //TODO : Add home screen composable here
    }
}

fun NavGraphBuilder.attendanceMenu(
    navController: NavHostController
) {
    composable(
        route = Screen.AttendanceScreen.route
    ){

        val attendanceVm: AttendanceVm = hiltViewModel()
        val state by attendanceVm.attendanceState.collectAsState()
        val event = attendanceVm::onEvent
        AttendanceScreen(
            state   = state,
            onEvent = event,
        )
    }
}

fun NavGraphBuilder.attendanceDetailScreen(
    navController: NavHostController
) {
    composable(
        route = Screen.AttendanceDetailScreen.route
    ){
        //TODO : Add attendance detail screen composable here
    }
}