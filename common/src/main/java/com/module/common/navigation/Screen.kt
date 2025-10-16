package com.module.common.navigation

sealed class Screen (val route: String){
    data object SplashScreen: Screen("splash_screen")
    data object HomeScreen: Screen("home_screen")
    data object OnBoardingScreen: Screen("on_boarding_screen")
    data object AttendanceScreen: Screen("attendance_screen")
    data object AttendanceDetailScreen: Screen("attendance_detail_screen")
}