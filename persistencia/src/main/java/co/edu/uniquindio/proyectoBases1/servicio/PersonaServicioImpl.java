package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.repositorios.PersonaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    private PersonaRepo personaRepo;

    public PersonaServicioImpl(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }


    @Override
    public Persona registararPersona(Persona persona) throws Exception {
        //Persona personaBuscada =obtenerPersonaNull(persona.getCedula());
        Persona personaBuscada = personaRepo.obtenerPersona(persona.getCedula());
        if (personaBuscada != null) {
            throw new Exception("La cedula ya esta registrada");
        }
        Persona personaCorreo = bucarPersonaPorEmail(persona.getCorreo());
        return personaRepo.save(persona);
    }

    private Persona obtenerPersonaNull(String cedula) throws Exception {
        Persona personaBuscada = personaRepo.findById(cedula).orElse(null);
        if (personaBuscada != null) {
            throw new Exception("La cedula ya esta registrada");
        }
        return personaBuscada;
    }

    public Persona bucarPersonaPorEmail(String email) throws Exception {
        Persona personaBuscadaPorCorreo = personaRepo.findByCorreo(email).orElse(null);
        if (personaBuscadaPorCorreo != null) {
            throw new Exception("El correo no es valido");
        }
        return personaBuscadaPorCorreo;
    }

    @Override
    public Persona actualizarPersona(Persona persona) throws Exception {
        Persona personaBuscada = obtenerPersona(persona.getCedula());
        return personaRepo.save(persona);
    }

    @Override
    public Persona obtenerPersona(String cedula) throws Exception {
        Persona personaBuscada = personaRepo.findById(cedula).orElse(null);
        if (personaBuscada == null) {
            throw new Exception("La persona no fue encontrada");
        }
        return personaBuscada;
    }

    @Override
    public void eliminarPersona(String cedula) throws Exception {
        Persona persona = obtenerPersona(cedula);
        personaRepo.delete(persona);
    }


    @Override
    public List<Persona> listarPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public Persona validarLogin(String correo, String password) throws Exception {

        Optional<Persona> persona = personaRepo.findByCorreoAndAndPassword(correo, password);

        if (persona.isEmpty()) {
            throw new Exception("Los datos de autenticacion son incorrectos");
        }

        return persona.get();
    }

    @Override
    public List<Persona> listaEstudiantes() {
        List<Persona> personas = listarPersonas();
        List<Persona> estudiantes = null;
        for (int i = 0; i < listarPersonas().size(); i++) {
            if (personas.get(i).getTipo() == 2) {
                estudiantes.add(personas.get(i));
            }
        }
        return estudiantes;
    }

    @Override
    public List <Persona> listaDocentes() {
        return personaRepo.obtenerDocente();
    }

   /* @Override
    public Persona obtenerDocente(String cedula) {
        List<Persona> personas = listarPersonas();
        Persona docente = null;
        for (int i = 0; i <listarPersonas().size(); i++){
            if(personas.get(i).getTipo()==1){
                if(personas.get(i).getCedula().equals(cedula)){
                    docente = personas.get(i);
                }
            }
        }
        return docente;

    }

    @Override
    public Persona obtenerDocentes() {
        return null;
    }*/

}
