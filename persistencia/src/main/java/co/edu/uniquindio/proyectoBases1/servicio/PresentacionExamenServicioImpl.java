package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.PresentacionExamen;
import co.edu.uniquindio.proyectoBases1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentacionExamenServicioImpl implements PresentacionExamenServicio {

    @Autowired
    private PresentacionExamenRepo presentacionExamenRepo;

    @Override
    public PresentacionExamen enviarExamen(PresentacionExamen presentacionExamen) throws Exception {

        return presentacionExamenRepo.save(presentacionExamen);
    }

    @Override
    public PresentacionExamen cargarExamen(String cedula, int codigoExamen) throws Exception {
        return presentacionExamenRepo.cargarExamen(cedula,codigoExamen);
    }
}
