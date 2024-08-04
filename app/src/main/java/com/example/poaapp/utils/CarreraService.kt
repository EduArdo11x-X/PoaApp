package com.example.poaapp.utils

import com.example.poaapp.model.Carrera
import com.example.poaapp.model.Roles
import retrofit2.Call
import retrofit2.http.GET

interface CarreraService {

    @GET("carrera/")
    fun getCarreras(): Call<List<Carrera>>
}