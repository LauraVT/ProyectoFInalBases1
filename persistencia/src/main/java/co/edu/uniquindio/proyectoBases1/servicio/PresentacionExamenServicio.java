package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.PresentacionExamen;

public interface PresentacionExamenServicio {

    PresentacionExamen enviarExamen(PresentacionExamen presentacionExamen) throws Exception;

    PresentacionExamen cargarExamen(String cedula, int codigoExamen) throws Exception;
}
