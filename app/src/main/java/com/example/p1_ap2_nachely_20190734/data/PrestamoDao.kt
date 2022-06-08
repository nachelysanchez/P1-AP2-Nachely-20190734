package com.example.p1_ap2_nachely_20190734.data

import androidx.room.*
import com.example.p1_ap2_nachely_20190734.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamos: Prestamo)

    @Delete
    suspend fun eliminar(prestamos: Prestamo)

    @Query("SELECT * FROM Prestamos WHERE prestamoId=:prestamoId")
    fun buscar(prestamoId : Int) : Flow<Prestamo>

    @Query("SELECT * FROM Prestamos ORDER BY prestamoId")
    fun getList() : Flow<List<Prestamo>>
}