package com.example.poaaplication.utils

import Usuarios
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsuarioService {
    @GET("api/usuarios")
    fun getUsuarios(): Call<List<Usuarios>>

    @POST("api/login")
    fun login(@Body usuario: Usuarios): Call<Usuarios>

    @POST("api/usuarios")
    fun create(@Body usuario: Usuarios): Call<Usuarios>
}