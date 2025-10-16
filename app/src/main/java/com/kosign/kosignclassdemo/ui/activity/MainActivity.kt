package com.kosign.kosignclassdemo.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.kosign.kosignclassdemo.ui.graph.MainNavGraph
import com.kosign.resources.theme.KosignClassDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KosignClassDemoTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .background(Color.Green)
                        ){
                            Text("Bottom Bar")
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