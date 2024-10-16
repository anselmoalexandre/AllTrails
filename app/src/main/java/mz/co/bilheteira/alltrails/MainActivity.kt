package mz.co.bilheteira.alltrails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllTrailsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ATNavigationBar(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
