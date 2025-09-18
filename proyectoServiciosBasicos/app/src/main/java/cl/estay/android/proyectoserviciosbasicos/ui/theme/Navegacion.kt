package cl.estay.android.proyectoserviciosbasicos.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import cl.estay.android.proyectoserviciosbasicos.Paginas.PantallaListado
import cl.estay.android.proyectoserviciosbasicos.Paginas.PantallaFormulario

@Composable
fun AppNavigation(viewModel: MedicionViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "listado") {
        composable("listado") { PantallaListado(navController, viewModel) }
        composable("formulario") { PantallaFormulario(navController, viewModel) }
    }
}