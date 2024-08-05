package com.example.poaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar botones
        val btnUsuarios = findViewById<Button>(R.id.btnUsuarios)
        val btnUnidad = findViewById<Button>(R.id.btnUnidad)
        val btnCarrera = findViewById<Button>(R.id.btnCarrera)
        val btnAgregarUnidades = findViewById<Button>(R.id.btnAgregarUnidad)

        val btnAgregarUsuarios = findViewById<Button>(R.id.btnAgregarUsuarios)
        val btnAgregarCarreras = findViewById<Button>(R.id.btnAgregarCarreras)


        // Configurar listeners para los botones
        btnUsuarios.setOnClickListener {
            val intent = Intent(this, ListaUsuarios::class.java)
            startActivity(intent)
        }

        btnUnidad.setOnClickListener {
            val intent = Intent(this, ListaUnidad::class.java)
            startActivity(intent)
        }

        btnCarrera.setOnClickListener {
            val intent = Intent(this, ListaCarrera::class.java)
            startActivity(intent)
        }

        btnAgregarUnidades.setOnClickListener {
            val intent = Intent(this, RegisterUnidadActivity::class.java)
            startActivity(intent)
        }

        btnAgregarUsuarios.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnAgregarCarreras.setOnClickListener {
            val intent = Intent(this, RegisterCarreraActivity::class.java)
            startActivity(intent)
        }
    }
}
