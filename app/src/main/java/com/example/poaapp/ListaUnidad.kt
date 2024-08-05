package com.example.poaapp

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.poaaplication.utils.Apis
import com.example.poaapp.model.Roles
import com.example.poaapp.model.Unidad
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class ListaUnidad : ComponentActivity() {

    private val listaUnidad: MutableList<Unidad> = mutableListOf()
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_unidad)

        // Inicialización del ListView
        listView = findViewById(R.id.listViewUnidades)


        // Cargar Unidad desde la API
        cargarUnidadDesdeApi()

        // Configuración de padding para las ventanas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun cargarUnidadDesdeApi() {
        val api = Apis()
        val UnidadService = api.getUnidadesService()
        UnidadService.getUnidades().enqueue(object : Callback<List<Unidad>> {
            override fun onResponse(call: Call<List<Unidad>>, response: Response<List<Unidad>>) {
                if (response.isSuccessful) {
                    response.body()?.let { Unidad ->
                        listaUnidad.addAll(Unidad)
                        // Configurar el adaptador con los datos de la API
                        listView.adapter = UnidadAdapter(this@ListaUnidad, R.layout.activity_contenido_unidad, listaUnidad)
                    }
                } else {
                    Log.e("ListaUnidad", "Error en la respuesta: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Unidad>>, t: Throwable) {
                Log.e("ListaUnidad", "Error en la llamada a la API", t)
            }
        })
    }
}
