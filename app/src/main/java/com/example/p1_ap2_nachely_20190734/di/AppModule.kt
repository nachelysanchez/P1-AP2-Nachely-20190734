package com.example.p1_ap2_nachely_20190734.di

import android.content.Context
import androidx.room.Room
import com.example.p1_ap2_nachely_20190734.data.PrestamoDao
import com.example.p1_ap2_nachely_20190734.data.PrestamosDb
import com.example.p1_ap2_nachely_20190734.data.repositorios.PrestamoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvidePrestamosDb(@ApplicationContext context: Context) : PrestamosDb{
        val DATABASE_NAME = "PrestamosDb"
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePrestamoDAO(prestamosDb: PrestamosDb) : PrestamoDao{
        return prestamosDb.prestamosDao
    }

    @Provides
    fun ProvidePrestamoRepository(prestamoDao: PrestamoDao) :PrestamoRepository{
        return PrestamoRepository(prestamoDao)
    }

}