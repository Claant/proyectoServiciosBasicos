package cl.estay.android.proyectoserviciosbasicos.Paginas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.estay.android.proyectoserviciosbasicos.ui.theme.MedicionViewModel
import cl.estay.android.proyectoserviciosbasicos.ui.theme.MedicionItem
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DefaultLocale")
@Composable

fun PantallaListado(navController: NavController, viewModel: MedicionViewModel) {

    val mediciones by viewModel.mediciones.collectAsState()
    val symbols = DecimalFormatSymbols(Locale("es", "ES")).apply {
        groupingSeparator = '.'
        decimalSeparator = ','
    }
    // Crear el patrón de formato
    val formato = DecimalFormat("#,###.##", symbols)



    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("formulario") }) {
                Icon(Icons.Default.Add, contentDescription = "Inconos de los servicios basicos")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(16.dp, vertical=20.dp) ) {
            items(mediciones) { medicion ->
                Row(

                    modifier = Modifier.fillMaxWidth().padding(15.dp)

                    ) {
                    Icon(
                        painterResource(id = MedicionItem(medicion.tipo)),
                        contentDescription = "Iconos de los servicios de luz, agua y gas",
                        modifier = Modifier.size(23.dp)
                    )
                    Spacer( Modifier.width(15.dp))

                    Column (
                        modifier = Modifier.padding(vertical=5.dp),

                    ) {

                        Row(
                            // distribuye los elementos de forma horizontal, colocando el primer y ultimo elemento en los bordes de la fila
                            horizontalArrangement= Arrangement.SpaceBetween,
                            // ocupa todo el ancho disponible
                            modifier = Modifier.fillMaxWidth()

                        ) {

                            Text("${medicion.tipo}")

                            

                            Text(formato.format(medicion.valor))



                            Text("${medicion.fecha}")

                        }
                        // COLOCA UNA LINEA HORIZONTAL QUE SEPARA LAS MEDICIONES
                        HorizontalDivider(modifier= Modifier.padding(vertical=5.dp))

                    }
                    }
            }
            }
        }
    }
