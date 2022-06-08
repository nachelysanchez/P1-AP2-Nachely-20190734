package com.example.p1_ap2_nachely_20190734.data

import androidx.room.*
import com.example.p1_ap2_nachely_20190734.model.Prestamos
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamos: Prestamos)

    @Delete
    suspend fun eliminar(prestamos: Prestamos)

    @Query("SELECT * FROM Prestamos WHERE prestamoId=:prestamoId")
    fun buscar(prestamoId : Int) : Flow<Prestamos>

    @Query("SELECT * FROM Prestamos ORDER BY prestamoId")
    fun getList() : Flow<List<Prestamos>>
}