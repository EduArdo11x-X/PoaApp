package com.example.poaapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.poaaplication.utils.Apis
import com.example.poaapp.model.Carrera
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RegisterCarreraActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_carrera)

        val nombreEditText = findViewById<EditText>(R.id.nombre_carrera)
        val coordinacionEditText = findViewById<EditText>(R.id.coordinacion_carrera)
        val directorEditText = findViewById<EditText>(R.id.director_carrera)
        val registerButtonCarrera = findViewById<Button>(R.id.register_button_carrera)







        registerButtonCarrera.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val coordinacion = coordinacionEditText.text.toString()
            val director = directorEditText.text.toString()
            val newCarrera = Carrera( nombre = nombre, coordinacion = coordinacion, director = director)

            registerNewCarrera(newCarrera)


        }
    }

    private fun registerNewCarrera(Carrera: Carrera) {
        val api = Apis().getCarrerasService()
        val call: Call<Carrera> = api.create(Carrera)

        call.enqueue(object : Callback<Carrera> {
            override fun onResponse(call: Call<Carrera>, response: Response<Carrera>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterCarreraActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@RegisterCarreraActivity, "Error en el registro: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Carrera>, t: Throwable) {
                Toast.makeText(this@RegisterCarreraActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
