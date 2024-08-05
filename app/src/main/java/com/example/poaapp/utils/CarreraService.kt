package com.example.poaapp.utils

import com.example.poaapp.model.Carrera
import com.example.poaapp.model.Roles
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CarreraService {

    @GET("api/carreras")
    fun getCarreras(): Call<List<Carrera>>

    @POST("api/carreras")
    fun create(@Body carrera: Carrera): Call<Carrera>
}