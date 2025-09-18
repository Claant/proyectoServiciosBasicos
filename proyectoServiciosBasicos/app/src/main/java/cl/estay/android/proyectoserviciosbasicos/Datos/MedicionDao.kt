package cl.estay.android.proyectoserviciosbasicos.Datos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


//esta anotacion proporciona los metodos consulta e insertar para interactuar con los datos
@Dao
interface MedicionDao {
    @Query("SELECT * FROM mediciones ORDER BY fecha DESC")
    fun ObtenerMedicion(): Flow<List<Medicion>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertarMedicion(medicion: Medicion)


}