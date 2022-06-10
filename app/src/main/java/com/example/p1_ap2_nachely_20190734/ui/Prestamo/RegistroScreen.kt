package com.example.p1_ap2_nachely_20190734.ui.Prestamo

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.p1_ap2_nachely_20190734.ui.componentes.ValidacionText

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

    val contexto = LocalContext.current

    Scaffold(
        topBar= {
            TopAppBar(
                title = { Text(text = "Registro de Prestamos") }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    deudorError = viewModel.deudor.isBlank()
                    montoError = viewModel.monto.isBlank()
                    conceptoError = viewModel.concepto.isBlank()

                    if(!deudorError && !conceptoError && !montoError){
                        if(viewModel.monto.toFloat() > 0){
                            viewModel.Guardar()
                            Toast.makeText(contexto, "El prestamo se guardó correctamente", Toast.LENGTH_LONG).show()
                            navHostController.navigateUp()
                        }else{
                            Toast.makeText(contexto, "El monto no puede ser menor o igual a cero", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            )
            {
                Icon(imageVector = Icons.TwoTone.Save, contentDescription = null)
            }
        }

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
            ValidacionText(estado = deudorError)
            
            Spacer(modifier = Modifier.height(40.dp))
            
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

            ValidacionText(estado = conceptoError)
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = viewModel.monto.toString(),
                onValueChange = {viewModel.monto = it},
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
            
            ValidacionText(estado = montoError)
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}