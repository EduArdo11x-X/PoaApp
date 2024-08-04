package com.example.poaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.poaapp.model.Roles

class RolesAdapter(
    context: Context,
    private val resource: Int,
    private val roles: List<Roles>
) : ArrayAdapter<Roles>(context, resource, roles) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: layoutInflater.inflate(resource, parent, false)

        val txtIdRol = view.findViewById<TextView>(R.id.ID)
        val txtNombre = view.findViewById<TextView>(R.id.Nombre)
        val txtDescripcion = view.findViewById<TextView>(R.id.Descripcion)

        val role = getItem(position)

        txtIdRol.text = String.format("ID: %d", role?.id ?: 0)
        txtNombre.text = String.format("Nombre: %s", role?.nombre ?: "No Nombre")
        txtDescripcion.text = String.format("Descripcion: %s", role?.descripcion ?: "No Descripcion")

        return view
    }
}
