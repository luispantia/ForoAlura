package Alura.api.foro.domain.topico.respuesta.validaciones;

import Alura.api.foro.domain.topico.TopicoRepository;
import Alura.api.foro.infra.errores.ValidacionDeIntegridad;
import Alura.api.foro.domain.topico.respuesta.DatosCrearRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoValido implements ValidadorRespuesta {

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idTopico() == null || !topicoRepository.existsById(datos.idTopico())) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
    }
}
