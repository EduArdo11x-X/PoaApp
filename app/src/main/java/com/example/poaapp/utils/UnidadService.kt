package com.example.poaapp.utils

import com.example.poaapp.model.Roles
import com.example.poaapp.model.Unidad
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UnidadService {

    @GET("api/unidad")
    fun getUnidades(): Call<List<Unidad>>

    @POST("api/unidad")
    fun create(@Body unidad: Unidad): Call<Unidad>
}