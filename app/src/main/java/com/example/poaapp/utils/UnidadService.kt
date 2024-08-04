package com.example.poaapp.utils

import com.example.poaapp.model.Roles
import com.example.poaapp.model.Unidad
import retrofit2.Call
import retrofit2.http.GET

interface UnidadService {

    @GET("unidad/")
    fun getUnidades(): Call<List<Unidad>>
}