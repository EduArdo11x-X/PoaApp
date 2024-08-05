package com.example.poaapp

import Usuarios
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.poaaplication.utils.Apis
import com.example.poaapp.model.Roles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaUsuarios : ComponentActivity() {

    private val listaUsuarios: MutableList<Usuarios> = mutableListOf()
    private val listaRoles: MutableList<Roles> = mutableListOf()
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_usuarios)

        // Inicialización del ListView
        listView = findViewById(R.id.listViewUsuarios)

        // Simular carga de roles
        cargarRolesSimulados()

        // Cargar usuarios desde la API
        cargarUsuariosDesdeApi()

        // Configuración de padding para las ventanas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun cargarRolesSimulados() {
        // Suponiendo que estos roles se cargan de algún lugar y se usan aquí
        val rol1 = Roles(1, "Admin", "Administrador del sistema")
        val rol2 = Roles(2, "User", "Usuario del sistema")
        val rol3 = Roles(3, "Guest", "Invitado del sistema")

        listaRoles.addAll(listOf(rol1, rol2, rol3))
    }

    private fun cargarUsuariosDesdeApi() {
        val api = Apis()
        val usuarioService = api.getUsuarioService()
        usuarioService.getUsuarios().enqueue(object : Callback<List<Usuarios>> {
            override fun onResponse(call: Call<List<Usuarios>>, response: Response<List<Usuarios>>) {
                if (response.isSuccessful) {
                    response.body()?.let { usuarios ->
                        listaUsuarios.addAll(usuarios)
                        // Configurar el adaptador con los datos de la API
                        listView.adapter = UsuarioAdapter(this@ListaUsuarios, R.layout.activity_contenido_usuarios, listaUsuarios)
                    }
                } else {
                    Log.e("ListaUsuarios", "Error en la respuesta: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Usuarios>>, t: Throwable) {
                Log.e("ListaUsuarios", "Error en la llamada a la API", t)
            }
        })
    }
}
