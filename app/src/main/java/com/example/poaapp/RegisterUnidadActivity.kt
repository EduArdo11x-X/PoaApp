package com.example.poaapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.poaaplication.utils.Apis
import com.example.poaapp.model.Unidad
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RegisterUnidadActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_unidad)

        val nombreEditText = findViewById<EditText>(R.id.nombre_unidad)
        val coordinacionEditText = findViewById<EditText>(R.id.coordinacion_unidad)
        val directorEditText = findViewById<EditText>(R.id.director_unidad)
        val registerButtonUnidad = findViewById<Button>(R.id.register_button_unidad)







        registerButtonUnidad.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val coordinacion = coordinacionEditText.text.toString()
            val director = directorEditText.text.toString()
            val newUnidad = Unidad( nombre = nombre, coordinacion = coordinacion, director = director)

            registerNewUnidad(newUnidad)


        }
    }

    private fun registerNewUnidad(unidad: Unidad) {
        val api = Apis().getUnidadesService()
        val call: Call<Unidad> = api.create(unidad)

        call.enqueue(object : Callback<Unidad> {
            override fun onResponse(call: Call<Unidad>, response: Response<Unidad>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterUnidadActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@RegisterUnidadActivity, "Error en el registro: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Unidad>, t: Throwable) {
                Toast.makeText(this@RegisterUnidadActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
