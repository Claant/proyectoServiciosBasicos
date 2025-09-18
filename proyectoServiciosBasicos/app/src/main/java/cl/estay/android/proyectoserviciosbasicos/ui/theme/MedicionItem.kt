package cl.estay.android.proyectoserviciosbasicos.ui.theme


import androidx.compose.runtime.Composable
import cl.estay.android.proyectoserviciosbasicos.Datos.TipoMedidor
import cl.estay.android.proyectoserviciosbasicos.R


@Composable
fun MedicionItem(tipo: TipoMedidor): Int = when (tipo) {
    TipoMedidor.AGUA -> R.drawable.agua
    TipoMedidor.LUZ -> R.drawable.luz
    TipoMedidor.GAS -> R.drawable.gas

}











