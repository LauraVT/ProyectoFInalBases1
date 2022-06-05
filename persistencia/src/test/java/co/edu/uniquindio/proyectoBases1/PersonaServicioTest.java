package co.edu.uniquindio.proyectoBases1;

import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.servicio.PersonaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class PersonaServicioTest {

    @Autowired
    private PersonaServicio personaServicio;

   /* */@Test
    @Sql("classpath:dataset.sql")
    public void resgistarPersonaTest(){
        Persona p = new Persona();

       try {
           Persona personaRegistrada = personaServicio.registararPersona(p);
           Assertions.assertNotNull(personaRegistrada);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
