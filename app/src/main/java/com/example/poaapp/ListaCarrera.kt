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
import com.example.poaapp.model.Carrera
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class ListaCarrera : ComponentActivity() {

    private val listaCarrera: MutableList<Carrera> = mutableListOf()
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_carrera)

        // Inicialización del ListView
        listView = findViewById(R.id.listViewCarreras)


        // Cargar Carrera desde la API
        cargarCarreraDesdeApi()

        // Configuración de padding para las ventanas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun cargarCarreraDesdeApi() {
        val api = Apis()
        val CarreraService = api.getCarrerasService()
        CarreraService.getCarreras().enqueue(object : Callback<List<Carrera>> {
            override fun onResponse(call: Call<List<Carrera>>, response: Response<List<Carrera>>) {
                if (response.isSuccessful) {
                    response.body()?.let { Carrera ->
                        listaCarrera.addAll(Carrera)
                        // Configurar el adaptador con los datos de la API
                        listView.adapter = CarreraAdapter(this@ListaCarrera, R.layout.activity_contenido_carrera, listaCarrera)
                    }
                } else {
                    Log.e("ListaCarrera", "Error en la respuesta: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Carrera>>, t: Throwable) {
                Log.e("ListaCarrera", "Error en la llamada a la API", t)
            }
        })
    }
}
