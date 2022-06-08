package com.example.p1_ap2_nachely_20190734.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.p1_ap2_nachely_20190734.model.Prestamo

@Database(
    entities = [
        Prestamo::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb : RoomDatabase() {
    abstract val prestamosDao : PrestamoDao
}