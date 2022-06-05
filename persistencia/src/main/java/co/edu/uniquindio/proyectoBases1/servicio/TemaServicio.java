package co.edu.uniquindio.proyectoBases1.servicio;


import co.edu.uniquindio.proyectoBases1.entidades.Tema;

import java.util.List;

public interface TemaServicio {

    Tema crearTema(Tema tema) throws Exception;

    void eliminarTema(Integer codigo) throws Exception;

    Tema modificarTema(Tema tema) throws Exception;

    Tema obtenerTema(Integer codigo) throws Exception;

    List<Tema> listarTemas();

}
