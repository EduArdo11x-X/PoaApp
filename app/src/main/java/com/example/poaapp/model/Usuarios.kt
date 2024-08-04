package com.example.poaapp.model

import java.util.Date

data class Usuarios (

    var id: Int = 0,
    var fechaNacimiento: Date? = null,
    var nombre: String? = null,
    var apellido: String? = null,
    var correo: String? = null,
    var rolId: Roles? = null,
    var usuario: String? = null,
    var contrasena: String? = null


)
