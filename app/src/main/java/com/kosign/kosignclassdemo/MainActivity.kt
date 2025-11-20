package com.kosign.kosignclassdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kosign.core.ui.theme.KosignClassDemoTheme
import com.kosign.core.ui.components.connectivity.connectivityState
import com.kosign.kosignclassdemo.ui.graph.MainNavGraph
import com.module.common.navigation.Graph
import com.module.core.networkconnection.ConnectionState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KosignClassDemoTheme {
                val navController   = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentGraph    = navBackStackEntry?.destination?.parent?.route

                val connection by connectivityState()
                val isConnected = connection === ConnectionState.Available

                Scaffold(
                    snackbarHost = {
                        if (isConnected.not()) {
                            Snackbar(
                                action = {}, modifier = Modifier.padding(8.dp)
                            ) {
                                Text(text = "Please check your connection !")
                            }
                        }
                    },
                    bottomBar = {
                        when (currentGraph) {
                            Graph.FEATURE_ADMIN_GRAPH -> {
                                BottomBar(
                                    isAdmin = true
                                )
                            }
                            Graph.FEATURE_GRAPH -> {
                                BottomBar()
                            }
                            else -> {}
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                    ){
                        MainNavGraph(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBar(
    isAdmin: Boolean = false
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(Color.Green)
    ) {
        if (isAdmin) {
            Text("Admin Bottom Bar")
        } else {
            Text("User Bottom Bar")
        }
    }
}