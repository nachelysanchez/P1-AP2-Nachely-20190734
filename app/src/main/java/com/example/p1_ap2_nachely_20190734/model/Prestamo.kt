package com.example.p1_ap2_nachely_20190734.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId : Int = 0,
    val deudor : String,
    val concepto : String,
    val monto : Float
)