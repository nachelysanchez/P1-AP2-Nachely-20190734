package com.example.p1_ap2_nachely_20190734.ui.Entidad

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.p1_ap2_nachely_20190734.utils.Screen

@Composable
fun RegistroScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar= {
            TopAppBar(
                title = { Text(text = "Registro") }
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

        }
    }
}