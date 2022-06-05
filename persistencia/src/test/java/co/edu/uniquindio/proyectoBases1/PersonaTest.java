package co.edu.uniquindio.proyectoBases1;

import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.repositorios.PersonaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonaTest {

    @Autowired
    private PersonaRepo personaRepo;

    @Test
    public void registaPersona(){
        Persona persona = new Persona("1233", 1, "samuel", 28, "samuel@uq", "1q2w3e",null,null,null,null,null);
        Persona personaRegistarda = personaRepo.save(persona);
        Assertions.assertNotNull(personaRegistarda);
    }

    @Test
    public void eliminarPersona(){
        Persona persona = new Persona("1233", 1, "samuel", 28, "samuel@uq", "1q2w3e",null,null,null,null,null);
        Persona personaRegistarda = personaRepo.save(persona);

        personaRepo.delete(personaRegistarda);

        Persona personaBuscada = personaRepo.findById("1233").orElse(null);
        Assertions.assertNull(personaBuscada);
    }

    @Test
    public void actualizarPersona(){
        Persona persona = new Persona("1233", 1, "samuel", 28, "samuel@uq", "1q2w3e",null,null,null,null,null);

        Persona personaRegistrada = personaRepo.save(persona);
        personaRegistrada.setEdad(30);

        personaRepo.save(personaRegistrada);

        Persona personaBuscada = personaRepo.findById("1233").orElse(null);
        Assertions.assertEquals(30, personaBuscada.getEdad());
    }

    @Test
    public void listarPersonas() {

        Persona persona = new Persona("1233", 1, "samuel", 28, "samuel@uq", "1q2w3e",null,null,null,null,null);
        Persona personaRegistarda = personaRepo.save(persona);

        Persona persona2 = new Persona("1111", 1, "samuel", 28, "samuel@uq", "1q2w3e",null,null,null,null,null);
        Persona personaRegistarda2 = personaRepo.save(persona2);

        List<Persona> listaPersonas = personaRepo.findAll();

    }

}


