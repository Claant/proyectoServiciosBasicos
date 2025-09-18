package cl.estay.android.proyectoserviciosbasicos.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.estay.android.proyectoserviciosbasicos.Datos.Medicion
import cl.estay.android.proyectoserviciosbasicos.Datos.MedicionDao
import cl.estay.android.proyectoserviciosbasicos.Datos.TipoMedidor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate


class MedicionViewModel(private val dao: MedicionDao) : ViewModel(){
    val mediciones = dao.ObtenerMedicion()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),emptyList())

    fun registrarMedicion(tipo: TipoMedidor, valor: Double, fecha: LocalDate) {
        val nueva = Medicion(tipo = tipo, valor = valor, fecha = fecha)
        viewModelScope.launch {
            dao.InsertarMedicion(nueva)
        }
    }
}