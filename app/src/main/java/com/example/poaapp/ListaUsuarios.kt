package com.example.poaapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.poaapp.model.Roles
import com.example.poaapp.model.Usuarios
import java.text.SimpleDateFormat

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

        // Cargar usuarios
        cargarUsuarios()

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

    private fun cargarUsuarios() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        // Datos quemados de usuarios con fechas y roles
        val usuario1 = Usuarios(1, dateFormat.parse("2002-07-20")!!, "Kevin", "Cajeca", "kevin.cajeca@example.com", listaRoles[0], "Nano")
        val usuario2 = Usuarios(2, dateFormat.parse("2003-05-15")!!, "Erick", "Guarango", "erick.guarango@example.com", listaRoles[1], "Candelario")
        val usuario3 = Usuarios(3, dateFormat.parse("2004-11-10")!!, "David", "Mayancela", "david.mayancela@example.com", listaRoles[2], "Anfibio")

        listaUsuarios.addAll(listOf(usuario1, usuario2, usuario3))

        // Configurar el adaptador con los datos quemados
        listView.adapter = UsuarioAdapter(this, R.layout.activity_contenido_usuarios, listaUsuarios)
    }
}
