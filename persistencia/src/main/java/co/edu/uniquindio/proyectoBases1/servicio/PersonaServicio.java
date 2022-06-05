package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.Persona;

import java.util.List;

public interface PersonaServicio {

    Persona registararPersona(Persona persona) throws Exception;

    Persona actualizarPersona(Persona persona) throws Exception;

    Persona obtenerPersona(String cedula) throws Exception;

    void eliminarPersona (String cedula) throws Exception;

    List<Persona> listarPersonas();

    Persona validarLogin(String correo, String password) throws Exception;

    List<Persona> listaEstudiantes();

    List <Persona> listaDocentes();

    /*Persona obtenerDocente(String cedula);*/
}
