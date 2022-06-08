package com.example.p1_ap2_nachely_20190734.ui.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.p1_ap2_nachely_20190734.model.Prestamo

@Composable
fun RowPrestamo (prestamo: Prestamo) {
    Row() {
        Text(text = prestamo.deudor +"\n"+ prestamo.concepto+"\t"+prestamo.monto)
    }
}