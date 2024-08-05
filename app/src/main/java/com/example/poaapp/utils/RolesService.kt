package com.example.poaapp.utils

import com.example.poaapp.model.Roles
import retrofit2.Call
import retrofit2.http.GET

interface RolesService {
    @GET("roles/")
    fun getRoles(): Call<List<Roles>>

}