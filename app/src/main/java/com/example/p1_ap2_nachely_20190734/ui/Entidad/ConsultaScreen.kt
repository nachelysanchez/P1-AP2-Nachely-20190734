package com.example.p1_ap2_nachely_20190734.ui.Entidad

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.p1_ap2_nachely_20190734.utils.Screen

@Composable
fun ConsultaScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate(Screen.RegistroScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {

    }
}