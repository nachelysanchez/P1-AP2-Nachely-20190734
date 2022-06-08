package com.example.p1_ap2_nachely_20190734.utils

sealed class Screen (val route :String){
    object RegistroScreen : Screen("Registro")
    object ConsultaScreen : Screen("Consulta")
}