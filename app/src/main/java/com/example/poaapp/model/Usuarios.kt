import com.example.poaapp.model.Roles
import com.example.poaapp.model.UsuCarrera
import com.example.poaapp.model.UsuUnidad

data class Usuarios(
    var id: Long? = null,
    var usuario: String? = null,
    var contrasena: String? = null,
    var nombre: String? = null,
    var apellido: String? = null,
    var correo: String? = null,
    var f_nacimiento: String? = null,
    var rol: Roles? = null,
    var usuCarreras: List<UsuCarrera>? = null,
    var usuUnidades: List<UsuUnidad>? = null
)
