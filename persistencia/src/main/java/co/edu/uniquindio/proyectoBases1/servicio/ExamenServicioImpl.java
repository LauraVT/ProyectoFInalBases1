package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import co.edu.uniquindio.proyectoBases1.entidades.Tema;
import co.edu.uniquindio.proyectoBases1.repositorios.ExamenRepo;
import co.edu.uniquindio.proyectoBases1.repositorios.PersonaRepo;
import co.edu.uniquindio.proyectoBases1.repositorios.PreguntaRepo;
import co.edu.uniquindio.proyectoBases1.repositorios.TemaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServicioImpl implements ExamenServicio {

    private PersonaRepo personaRepo;
    private ExamenRepo examenRepo;
    private TemaRepo temaRepo;
    private PersonaServicio personaServicio;
    private PreguntaServicio preguntaServicio;
    private TemaServicio temaServicio;

    private PreguntaRepo preguntaRepo;

    public ExamenServicioImpl(PersonaRepo personaRepo, ExamenRepo examenRepo, PersonaServicio personaServicio, PreguntaServicio preguntaServicio, TemaServicio temaServicio,TemaRepo temaRepo,PreguntaRepo preguntaRepo) {
        this.personaRepo = personaRepo;
        this.examenRepo = examenRepo;
        this.personaServicio = personaServicio;
        this.preguntaServicio = preguntaServicio;
        this.temaServicio = temaServicio;
        this.temaRepo = temaRepo;
        this.preguntaRepo =preguntaRepo;
    }

    @Override
    public Examen elaborarExamen(Examen examen) throws Exception {

        Examen examenBuscado =examenRepo.obtenerExamen(examen.getCodigo());
        if(examenBuscado !=null) {
            throw new Exception("ese examen ya existe");
        }
        return examenRepo.save(examen);
    }

    @Override
    public void eliminarExamen(Integer codigo) throws Exception {
        Examen examenEliminado= obtenerExamen(codigo);
        examenRepo.delete(examenEliminado);
    }

    @Override
    public Examen modificarExamen(Examen examen) throws Exception {
     Examen examenModificado = obtenerExamen(examen.getCodigo());
     return examenRepo.save(examen);
    }

    @Override
    public Examen obtenerExamen(Integer codigo) throws Exception {
        Examen examenBuscado =examenRepo.obtenerExamen(codigo);
        if(examenBuscado ==null) {
            throw new Exception("ese examen no existe");
        }
        return examenBuscado;
    }

    @Override
    public List<Examen> listarExamenes(Examen examen){
        return examenRepo.findAll();
    }

    @Override
    public Examen asignarExamen(Examen examen) throws Exception {
        return null;
    }

  /*  @Override
    public List<Examen> listarExamenesPorDocentes(String cedula) {
        return null;
    }

    @Override
    public Examen asignarExamen(Examen examen) throws Exception {
        return null;
    }

    @Override
    public List<Persona> obtenerListaEstudiantes() {
        return personaRepo.findAll();
    }

    @Override
    public List<Persona> obtenerDocentes() {
        return personaRepo.obtenerDocente();
    }

    @Override
    public List<Tema> listarTemas() {
        return temaRepo.findAll();
    }

    @Override
    public List<Pregunta> obtenerListaPreguntas() {
        return  preguntaRepo.findAll();
    }*/


}
