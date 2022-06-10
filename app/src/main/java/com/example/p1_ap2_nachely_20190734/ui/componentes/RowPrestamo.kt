package com.example.p1_ap2_nachely_20190734.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p1_ap2_nachely_20190734.MyApp
import com.example.p1_ap2_nachely_20190734.model.Prestamo
import com.example.p1_ap2_nachely_20190734.ui.theme.P1AP2Nachely20190734Theme

@Composable
fun RowPrestamo (prestamo: Prestamo) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth().height(30.dp).padding(2.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = prestamo.deudor)
            Text(text = prestamo.monto.toString(),
                style = MaterialTheme.typography.h5
            )
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = prestamo.concepto,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

