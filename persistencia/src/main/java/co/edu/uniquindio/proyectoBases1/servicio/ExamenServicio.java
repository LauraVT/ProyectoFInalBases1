package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import co.edu.uniquindio.proyectoBases1.entidades.Tema;

import java.util.List;

public interface ExamenServicio {
    Examen elaborarExamen(Examen examen) throws Exception;

    void eliminarExamen(Integer codigo) throws Exception;

    Examen modificarExamen(Examen examen) throws Exception;

    Examen obtenerExamen(Integer codigo) throws Exception;

    List<Examen> listarExamenes(Examen examen);
    Examen asignarExamen(Examen examen)throws Exception;

   /* List<Examen> listarExamenesPorDocentes(String cedula);
    Examen asignarExamen(Examen examen)throws Exception;

    List<Persona> obtenerListaEstudiantes();

    List <Persona> obtenerDocentes();

    List<Tema> listarTemas();

    List<Pregunta> obtenerListaPreguntas();*/
}
