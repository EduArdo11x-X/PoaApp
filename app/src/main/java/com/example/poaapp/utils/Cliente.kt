package com.example.poaaplication.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Cliente {

    companion object {
        fun getCliente(url: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}