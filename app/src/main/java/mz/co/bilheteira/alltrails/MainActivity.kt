package mz.co.bilheteira.alltrails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mz.co.bilheteira.alltrails.ui.theme.AllTrailsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllTrailsTheme {
                AllTrailsContent()
            }
        }
    }
}
