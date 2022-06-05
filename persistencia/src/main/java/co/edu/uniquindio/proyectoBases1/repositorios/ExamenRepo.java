package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepo extends JpaRepository <Examen, Integer> {
   // Examen obtenerExamen(Integer codigo);

    //List<Persona> listaPersonas();
    
    @Query(nativeQuery = true, value = "select * from Examen e where e.codigo = codigo")
    Examen obtenerExamen(Integer codigo);


   // List<Persona> listaPersonas();*/

    /*@Query(nativeQuery = true, value = "select * from Examen e right join Pregunta p 0n e.codigo = p.codigoExamen")
    List<Pregunta>listaPreguntas();
    List<Pregunta> listarPreguntas(Integer codigo, Integer codigo1);*/
}

