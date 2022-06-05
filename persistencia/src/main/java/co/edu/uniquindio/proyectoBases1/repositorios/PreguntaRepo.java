package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepo extends JpaRepository<Pregunta,Integer> {

    @Query(nativeQuery = true, value = "select * from Pregunta p where p.codigo = codigo")
    Pregunta obtenerPregunta(Integer codigo);

    //Preguntas disponibles por docente para obtener del banco (Privado 0 y publico 1)
    @Query(nativeQuery = true, value = "select * from pregunta p where p.docente_cedula = cedula or p.publica = 1")
    List<Pregunta> obtenerListaPreguntasDisponibles(String cedula);


}
