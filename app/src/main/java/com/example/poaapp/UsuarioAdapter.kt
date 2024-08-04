package com.example.poaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.poaapp.model.Usuarios

class UsuarioAdapter(context: Context, resource: Int, objects: List<Usuarios>) :
    ArrayAdapter<Usuarios>(context, resource, objects) {

    private val resourceLayout = resource
    private val items = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(resourceLayout, parent, false)

        val usuario = items[position]

        val txtId = view.findViewById<TextView>(R.id.ID)
        val txtFechaNacimiento = view.findViewById<TextView>(R.id.fechaNacimiento)

        val txtNombre = view.findViewById<TextView>(R.id.Nombre)
        val txtApellido = view.findViewById<TextView>(R.id.Apellido)
        val txtCorreo = view.findViewById<TextView>(R.id.Correo)
        val txtRol = view.findViewById<TextView>(R.id.IdRolText)

        val txtUsuario = view.findViewById<TextView>(R.id.usuario)
        val txtContraseña = view.findViewById<TextView>(R.id.contraseña)


        txtId.text = "ID: ${usuario.id}"
        txtFechaNacimiento.text = "ID: ${usuario.fechaNacimiento}"

        txtNombre.text = "Nombre: ${usuario.nombre}"
        txtApellido.text = "Apellido: ${usuario.apellido}"
        txtCorreo.text = "Correo: ${usuario.correo}"
        txtRol.text = "ID: ${usuario.rolId}"
        txtUsuario.text = "ID: ${usuario.usuario}"
        txtContraseña.text = "ID: ${usuario.contrasena}"


        return view
    }
}
