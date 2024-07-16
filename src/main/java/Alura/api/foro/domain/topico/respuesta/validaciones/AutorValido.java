package Alura.api.foro.domain.topico.respuesta.validaciones;

import Alura.api.foro.domain.topico.respuesta.DatosCrearRespuesta;
import Alura.api.foro.domain.usuario.UsuarioRepository;
import Alura.api.foro.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorValido implements ValidadorRespuesta {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idAutor() == null || !usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionDeIntegridad("Autor no encontrado");
        }
    }
}
