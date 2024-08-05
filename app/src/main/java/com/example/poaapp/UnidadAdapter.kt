package com.example.poaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.poaapp.model.Unidad
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UnidadAdapter(context: Context, resource: Int, objects: List<Unidad>) :
    ArrayAdapter<Unidad>(context, resource, objects) {

    private val resourceLayout = resource
    private val items = objects

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(resourceLayout, parent, false)

        val unidad = items[position]

        val txtId = view.findViewById<TextView>(R.id.Id_Unidad)
        val txtNombreUnidad = view.findViewById<TextView>(R.id.view_nombre_unidad)
        val txtCoordinacionUnidad= view.findViewById<TextView>(R.id.view_unidad_coordinacion)
        val txtDirectorUnidad = view.findViewById<TextView>(R.id.view_unidad_director)



        txtId.text = "ID: ${unidad.id}"


        txtNombreUnidad.text = "Nombre: ${unidad.nombre}"
        txtCoordinacionUnidad.text = "Coordinacion: ${unidad.coordinacion}"
        txtDirectorUnidad.text = "Unidad: ${unidad.director}"



        return view
    }
}
