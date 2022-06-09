package com.example.p1_ap2_nachely_20190734.ui.Prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroScreen(
    navHostController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel()
) {
    var deudorError by remember {
        mutableStateOf(false)
    }
    var conceptoError by remember {
        mutableStateOf(false)
    }
    var montoError by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar= {
            TopAppBar(
                title = { Text(text = "Registro de Prestamos") }
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            OutlinedTextField(
                value = viewModel.deudor,
                onValueChange = {viewModel.deudor = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Deudor")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null)
                },
                isError = deudorError
            )
            OutlinedTextField(
                value = viewModel.concepto,
                onValueChange = {viewModel.concepto = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Concepto")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null)
                },
                isError = conceptoError
            )
            OutlinedTextField(
                value = viewModel.monto.toString(),
                onValueChange = {viewModel.concepto = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Monto")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null)
                },
                isError = montoError
            )
            //DEUDOR
            val assistiveElementText = if (deudorError) "Error: Obligatorio" else "*Obligatorio"
            val assistiveElementColor = if (deudorError) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            }

            //CONCEPTO
            val conceptoElementText = if (conceptoError) "Error: Obligatorio" else "*Obligatorio"
            val conceptoElementColor = if (conceptoError) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            }

            //MONTO
            val montoElementText = if (montoError) "Error: Obligatorio" else "*Obligatorio"
            val montoElementColor = if (montoError) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            }
            //MONTO
            val monto1ElementText = if (viewModel.monto < "0") "Error: No puede ser menor que cero" else "*Obligatorio"
            val monto1ElementColor = if (viewModel.monto < "0") {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
            }


            OutlinedButton(onClick = {
                if(!deudorError){
                    deudorError = viewModel.deudor.isBlank()
                }
                else if(!conceptoError){
                    conceptoError = viewModel.concepto.isBlank()
                }
                else if(!montoError){
                    montoError = viewModel.monto.isBlank()
                }
                else if(viewModel.monto < "0"){
                    montoError = viewModel.monto.isBlank()
                }
                else{
                    viewModel.Guardar()

                    navHostController.navigateUp()
                }


            }) {
                Text(text = "Guardar")
            }
        }
    }
}