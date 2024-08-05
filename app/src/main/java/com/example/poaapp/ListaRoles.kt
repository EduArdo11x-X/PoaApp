package com.example.poaapp

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.poaapp.model.Roles

class ListaRoles : ComponentActivity() {

    private val listaRoles: MutableList<Roles> = mutableListOf()
    private lateinit var listView1: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_roles)

        // Inicialización del ListView
        listView1 = findViewById(R.id.listViewRoles)

        // Cargar roles
        cargarRoles()

        // Configuración de padding para las ventanas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun cargarRoles() {
        // Datos quemados de roles
        val rol1 = Roles(1, "DOCENTE", "Docente del sistema")
        val rol2 = Roles(2, "EVALUADOR", "Evaluador del sistema")
        val rol3 = Roles(3, "ADMINISTRADOR", "Administrador del sistema")

        listaRoles.addAll(listOf(rol1, rol2, rol3))

        // Configurar el adaptador con los datos quemados
        listView1.adapter = RolesAdapter(this, R.layout.content_main, listaRoles)
    }
}
