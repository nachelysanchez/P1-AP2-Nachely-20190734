package com.example.p1_ap2_nachely_20190734.data.repositorios

import com.example.p1_ap2_nachely_20190734.data.PrestamoDao
import com.example.p1_ap2_nachely_20190734.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamosDao: PrestamoDao
){
    suspend fun insertar(prestamos: Prestamo){
        prestamosDao.insertar(prestamos = prestamos)
    }
    suspend fun eliminar(prestamos: Prestamo){
        prestamosDao.eliminar(prestamos = prestamos)
    }

     fun buscar(prestamoId : Int) : Flow<Prestamo> {
        return prestamosDao.buscar(prestamoId = prestamoId)
    }

    fun getList() : Flow<List<Prestamo>>{
        return prestamosDao.getList()
    }
}