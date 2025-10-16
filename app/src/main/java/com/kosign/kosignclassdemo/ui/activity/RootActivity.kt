package com.kosign.kosignclassdemo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kosign.kosignclassdemo.ui.graph.RootNavGraph
import com.kosign.resources.theme.KosignClassDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KosignClassDemoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavGraph(
                        onNavigateToHome = {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        },
                        onNavigateToAdmin = {
                            val intent = Intent(this, MainAdminActivity::class.java)
                            startActivity(intent)
                        },
                        onNavigateToInitial = {
                            val intent = Intent(this, InitialActivity::class.java)
                            startActivity(intent)

                        }
                    )
                }
            }
        }
    }
}