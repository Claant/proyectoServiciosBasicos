package cl.estay.android.proyectoserviciosbasicos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import cl.estay.android.proyectoserviciosbasicos.ui.theme.AppNavigation
import cl.estay.android.proyectoserviciosbasicos.ui.theme.MedicionViewModel

import cl.estay.android.proyectoserviciosbasicos.Datos.DataBase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            "mediciones_db"
        ).build()

        val viewModel = MedicionViewModel(db.medicionDao())
        setContent {
            AppNavigation(viewModel)

                }
            }
        }