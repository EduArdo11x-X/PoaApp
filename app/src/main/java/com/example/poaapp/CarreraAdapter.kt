package com.example.poaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.poaapp.model.Carrera
import com.example.poaapp.model.Roles

class CarreraAdapter(context: Context, resource: Int, objects: List<Carrera>) :
    ArrayAdapter<Carrera>(context, resource, objects) {

    private val resourceLayout = resource
    private val items = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(resourceLayout, parent, false)

        val Carrera = items[position]

        val txtId = view.findViewById<TextView>(R.id.Id_Carrera)
        val txtNombreCarrera = view.findViewById<TextView>(R.id.view_carrera)
        val txtCoordinacionCarrera= view.findViewById<TextView>(R.id.view_coordinacion_carrera)
        val txtDirectorCarrera = view.findViewById<TextView>(R.id.view_director_carrera)

        txtId.text = "ID: ${Carrera.id}"
        txtNombreCarrera.text = "Nombre: ${Carrera.nombre}"
        txtCoordinacionCarrera.text = "Coordinacion: ${Carrera.coordinacion}"
        txtDirectorCarrera.text = "Carrera: ${Carrera.director}"
        return view
    }
}
