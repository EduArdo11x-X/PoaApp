package com.example.poaapp

import Usuarios
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UsuarioAdapter(context: Context, resource: Int, objects: List<Usuarios>) :
    ArrayAdapter<Usuarios>(context, resource, objects) {

    private val resourceLayout = resource
    private val items = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(resourceLayout, parent, false)

        val usuario = items[position]

        val txtId = view.findViewById<TextView>(R.id.Id_Usuario)
        val txtFechaNacimiento = view.findViewById<TextView>(R.id.fechaNacimiento)
        val txtNombre = view.findViewById<TextView>(R.id.Nombre_usuario)
        val txtApellido = view.findViewById<TextView>(R.id.Apellido_usuario)
        val txtCorreo = view.findViewById<TextView>(R.id.Correo_usuario)
        val txtRol = view.findViewById<TextView>(R.id.IdRolText)
        val txtUsuario = view.findViewById<TextView>(R.id.usuario_U)
        val txtContraseña = view.findViewById<TextView>(R.id.contraseña)

        txtId.text = "ID: ${usuario.id}"

        // Formateador de fechas
        val dateFormatOutput = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        // Si `f_nacimiento` es una cadena, conviértelo a Date primero
        val dateFormatInput = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) // Ajusta este formato según el formato real
        val fechaNacimiento: Date? = usuario.f_nacimiento?.let {
            try {
                dateFormatInput.parse(it.toString()) // Convierte de String a Date
            } catch (e: Exception) {
                null
            }
        }

        // Formatear la fecha de nacimiento para mostrarla
        txtFechaNacimiento.text = "Fecha de Nacimiento: ${fechaNacimiento?.let { dateFormatOutput.format(it) } ?: "Desconocida"}"

        txtNombre.text = "Nombre: ${usuario.nombre}"
        txtApellido.text = "Apellido: ${usuario.apellido}"
        txtCorreo.text = "Correo: ${usuario.correo}"

        // Mostrar el nombre del rol si está disponible
        txtRol.text = "Rol: ${usuario.rol?.nombre ?: "Desconocido"}" // Asumiendo que `rol` tiene una propiedad `nombre`

        txtUsuario.text = "Usuario: ${usuario.usuario}"
        txtContraseña.text = "Contraseña: ${usuario.contrasena}"




        return view
    }
}
