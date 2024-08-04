package com.example.poaaplication.utils

import com.example.poaapp.model.Usuarios
import retrofit2.Call
import retrofit2.http.GET

interface UsuarioService {
    @GET("usuarios/")
    fun getUsuarios(): Call<List<Usuarios>>
}