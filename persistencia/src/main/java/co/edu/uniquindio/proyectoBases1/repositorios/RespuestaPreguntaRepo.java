package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.OpcionPregunta;
import co.edu.uniquindio.proyectoBases1.entidades.RespuestaPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaPreguntaRepo extends JpaRepository<OpcionPregunta, Integer> {

    @Query(nativeQuery = true, value = "select * from respuesta_pregunta rp join opcion_pregunta op on rp.opcion_pregunta_codigo = op.codigo where rp.respuesta = op.respuesta")
    RespuestaPregunta obtenerRespuestaCorrecta();
}
