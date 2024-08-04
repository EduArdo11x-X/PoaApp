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
    }
}
