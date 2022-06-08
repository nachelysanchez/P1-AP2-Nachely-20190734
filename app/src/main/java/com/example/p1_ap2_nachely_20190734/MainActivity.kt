package com.example.p1_ap2_nachely_20190734

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p1_ap2_nachely_20190734.ui.Entidad.ConsultaScreen
import com.example.p1_ap2_nachely_20190734.ui.Entidad.RegistroScreen
import com.example.p1_ap2_nachely_20190734.ui.theme.P1AP2Nachely20190734Theme
import com.example.p1_ap2_nachely_20190734.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P1AP2Nachely20190734Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screen.ConsultaScreen.route){
        composable(Screen.ConsultaScreen.route){
            ConsultaScreen(navHostController = navHostController)
        }
        composable(Screen.RegistroScreen.route){
            RegistroScreen(navHostController = navHostController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    P1AP2Nachely20190734Theme {
        MyApp()
    }
}