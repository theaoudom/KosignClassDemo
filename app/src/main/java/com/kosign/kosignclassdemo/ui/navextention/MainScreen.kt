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
import com.module.features.splash.presentation.SplashScreen

/**
 * All Screen of Splash Graph
 */
fun NavGraphBuilder.splashScreen(
    navController: NavHostController
) {
    composable(
        route = Screen.SplashScreen.route
    ){
        SplashScreen(
            navController = navController
        )
    }
}

/**
 * All Screen of Auth Graph
 */
fun NavGraphBuilder.onboardingScreen(

) {
    composable(
        route = ""
    ){
        //TODO : Add onboarding screen composable here
    }
}

/** === // === */

/**
 * All Screen of feature Graph
 */
fun NavGraphBuilder.home(

) {
    composable(
        route = Screen.HomeScreen.route
    ){
        //TODO : Add home screen composable here
    }
}

fun NavGraphBuilder.attendance(

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

/**
 * All Screen of Feature Admin Graph
 */
fun NavGraphBuilder.attendanceAdmin(

) {
    composable(
        route = Screen.HomeScreen.route
    ){
        //TODO : Add home screen composable here
    }
}