package cl.estay.android.proyectoserviciosbasicos.Paginas


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import cl.estay.android.proyectoserviciosbasicos.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.estay.android.proyectoserviciosbasicos.Datos.TipoMedidor
import cl.estay.android.proyectoserviciosbasicos.ui.theme.MedicionViewModel
import java.time.LocalDate


// uso de variables de estado para conservar el tipo de medicion y el valor.
@Composable
fun PantallaFormulario(navController: NavController, viewModel: MedicionViewModel) {
    var tipo by remember { mutableStateOf(TipoMedidor.AGUA) }
    var valor by remember { mutableStateOf("") }
    val fecha = LocalDate.now()
    val contexto= LocalContext.current


    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 50.dp)) {
        // titulo del formulario
        Text(
            text=contexto.getString(R.string.Titulo),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp,
            modifier = Modifier.padding(vertical = 20.dp))

        //ingreso lectura del medidor
        TextField(value = valor, onValueChange = { valor = it },
            label = { Text(text=contexto.getString(R.string.Medidor)) })

        // muestra la fecha actual
        TextField(value = fecha.toString(), onValueChange = { fecha.toString() },
            label = { Text(text = contexto.getString(R.string.fecha))})

        Spacer(Modifier.height(8.dp))

        Text(text = contexto.getString(R.string.Medidor_de),
            modifier = Modifier.padding(vertical = 20.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,)


        Spacer(Modifier.height(8.dp))
        TipoMedidor.entries.forEach {
            Row {
                RadioButton(selected = tipo == it, onClick = { tipo = it })
                Text(it.name)
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            viewModel.registrarMedicion(tipo, valor.toDouble(), fecha)
            navController.popBackStack()
        }) {
            Text(text = contexto.getString(R.string.Registrar_medicion))
        }
        }
         }


