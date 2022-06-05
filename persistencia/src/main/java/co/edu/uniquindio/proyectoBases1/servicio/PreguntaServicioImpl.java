package co.edu.uniquindio.proyectoBases1.servicio;


import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import co.edu.uniquindio.proyectoBases1.repositorios.PreguntaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PreguntaServicioImpl implements PreguntaServicio {

    @Autowired
    private PreguntaRepo preguntaRepo;

    @Override
    public Pregunta crearPregunta(Pregunta pregunta) throws Exception {
       Pregunta preguntaBuscada = preguntaRepo.obtenerPregunta(pregunta.getCodigo());
        if(preguntaBuscada !=null) {
            throw new Exception("esa pregunta ya existe");
        }
        return preguntaRepo.save(pregunta);
    }



    @Override
    public void eliminarPregunta(Integer codigo) throws Exception {
        Pregunta preguntaEliminada= obtenerPregunta(codigo);
        preguntaRepo.delete(preguntaEliminada);
    }

    @Override
    public Pregunta modificarPregunta(Pregunta pregunta) throws Exception {
        Pregunta preguntaModificada = obtenerPregunta(pregunta.getCodigo());
        return preguntaRepo.save(pregunta);
    }

    @Override
    public Pregunta obtenerPregunta(Integer codigo) throws Exception {
        Pregunta preguntaBuscada =preguntaRepo.obtenerPregunta(codigo);
        if(preguntaBuscada ==null) {
            throw new Exception("ese examen no existe");
        }
        return preguntaBuscada;
    }

    @Override
    public List<Pregunta> listarPregunta() {
        return preguntaRepo.findAll();
    }
}
