package co.edu.uniquindio.proyectoBases1.servicio;


import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;

import java.util.List;

public interface PreguntaServicio {

    Pregunta crearPregunta(Pregunta pregunta) throws Exception;

    void eliminarPregunta(Integer codigo) throws Exception;

    Pregunta modificarPregunta(Pregunta pregunta) throws Exception;

    Pregunta obtenerPregunta(Integer codigo) throws Exception;

    List<Pregunta> listarPregunta();

}
