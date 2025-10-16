package com.kosign.kosignclassdemo.ui.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kosign.kosignclassdemo.ui.navextention.adminFeatureGraph
import com.kosign.kosignclassdemo.ui.navextention.authGraph
import com.kosign.kosignclassdemo.ui.navextention.featureGraph
import com.kosign.kosignclassdemo.ui.navextention.splashGraph
import com.module.common.navigation.Graph

@Composable
fun MainNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController       = navController,
        startDestination    = Graph.SPLASH_GRAPH
    ){
        splashGraph(navController)
        authGraph(navController)
        featureGraph(navController)
        adminFeatureGraph(navController)
    }
}