package com.example.poaapp

import Usuarios
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.poaaplication.utils.Apis
import com.example.poaapp.model.Roles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private val rolesList = listOf(
        Roles(id = 1, nombre = "DOCENTE"),
        Roles(id = 2, nombre = "EVALUADOR"),
        Roles(id = 3, nombre = "ADMINISTRADOR")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val nameEditText = findViewById<EditText>(R.id.name)
        val surnameEditText = findViewById<EditText>(R.id.surname)
        val birthdateEditText = findViewById<EditText>(R.id.birthdate)
        val roleSpinner = findViewById<Spinner>(R.id.role_spinner)
        val registerButton = findViewById<Button>(R.id.register_button)

        // Formateador de fechas para la interfaz
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        // Formateador de fechas para el API
        val apiDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())

        // Manejo del DatePicker para la fecha de nacimiento
        birthdateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(selectedYear, selectedMonth, selectedDay)
                    birthdateEditText.setText(dateFormat.format(selectedDate.time))
                }, year, month, day)
            datePickerDialog.show()
        }

        // Configurar roles predefinidos en el Spinner (solo mostrando el nombre del rol)
        val rolesNames = rolesList.map { it.nombre ?: "Sin nombre" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, rolesNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        roleSpinner.adapter = adapter

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()
            val birthdateString = birthdateEditText.text.toString()
            val roleName = roleSpinner.selectedItem.toString()

            // Convertir la fecha de nacimiento a Date
            val birthdate: Date? = dateFormat.parse(birthdateString)

            // Convertir la fecha de nacimiento a formato ISO 8601
            val birthdateIso: String? = birthdate?.let { apiDateFormat.format(it) }

            // Encontrar el rol correspondiente
            val role = rolesList.find { it.nombre == roleName }

            if (birthdateIso != null && role != null) {
                val newUser = Usuarios(correo = email, contrasena = password, nombre = name, apellido = surname, f_nacimiento = birthdateIso, rol = role)
                registerNewUser(newUser)
            } else {
                // Manejar el caso en el que la fecha de nacimiento o el rol no sean válidos
                Toast.makeText(this, "Por favor, complete todos los campos correctamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerNewUser(user: Usuarios) {
        val api = Apis().getUsuarioService()
        val call: Call<Usuarios> = api.create(user)

        call.enqueue(object : Callback<Usuarios> {
            override fun onResponse(call: Call<Usuarios>, response: Response<Usuarios>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@RegisterActivity, "Error en el registro: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Usuarios>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
