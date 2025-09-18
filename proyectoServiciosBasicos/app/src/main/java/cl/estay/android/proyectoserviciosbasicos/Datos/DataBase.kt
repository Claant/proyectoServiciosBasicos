package cl.estay.android.proyectoserviciosbasicos.Datos

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// esta anotacion define la configuracion y contension de la base de datos
@Database(entities = [Medicion::class], version = 1)
@TypeConverters(LocalDateConverter::class)
abstract class DataBase : RoomDatabase(){
    abstract fun medicionDao(): MedicionDao
}