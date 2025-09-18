package cl.estay.android.proyectoserviciosbasicos.Datos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

// representa una tabla en la base de datos
@Entity(tableName = "mediciones")
data class Medicion(

    // se define en la primera variable com clave primaria
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipo: TipoMedidor,
    val valor: Double,
    val fecha: LocalDate


)