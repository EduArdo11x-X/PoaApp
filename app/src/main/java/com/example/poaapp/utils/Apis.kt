package com.example.poaaplication.utils

import com.example.poaapp.utils.CarreraService
import com.example.poaapp.utils.RolesService
import com.example.poaapp.utils.UnidadService

class Apis {

    fun getUsuarioService(): UsuarioService {
        return Cliente.getCliente().create(UsuarioService::class.java)
    }

    fun getRolesService(): RolesService {
        return Cliente.getCliente().create(RolesService::class.java)
    }

    fun getCarrerasService(): CarreraService {
        return Cliente.getCliente().create(CarreraService::class.java)
    }

    fun getUnidadesService(): UnidadService {
        return Cliente.getCliente().create(UnidadService::class.java)
    }
}
