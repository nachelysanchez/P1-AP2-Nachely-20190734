package com.example.p1_ap2_nachely_20190734.data.repositorios

import com.example.p1_ap2_nachely_20190734.data.PrestamosDao
import com.example.p1_ap2_nachely_20190734.model.Prestamos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamosDao: PrestamosDao
){
    suspend fun insertar(prestamos: Prestamos){
        prestamosDao.insertar(prestamos = prestamos)
    }
    suspend fun eliminar(prestamos: Prestamos){
        prestamosDao.eliminar(prestamos = prestamos)
    }

     fun buscar(prestamoId : Int) : Flow<Prestamos> {
        return prestamosDao.buscar(prestamoId = prestamoId)
    }

    fun getList() : Flow<List<Prestamos>>{
        return prestamosDao.getList()
    }
}