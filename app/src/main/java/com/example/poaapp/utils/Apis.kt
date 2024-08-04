package com.example.poaaplication.utils

import com.example.poaapp.utils.CarreraService
import com.example.poaapp.utils.RolesService
import com.example.poaapp.utils.UnidadService

class Apis {

    val URL_001 = "http://localhost:8080/"

    fun getUsuarioService(): UsuarioService {
        return Cliente.getCliente(URL_001).create(UsuarioService::class.java)
    }

    fun getRolesService(): RolesService {
        return Cliente.getCliente(URL_001).create(RolesService::class.java)
    }

    fun getCarrerasService(): CarreraService {
        return Cliente.getCliente(URL_001).create(CarreraService::class.java)
    }

    fun getUnidadesService(): UnidadService {
        return Cliente.getCliente(URL_001).create(UnidadService::class.java)
    }
}