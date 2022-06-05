package co.edu.uniquindio.proyectoBases1.repositorios;


import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.PreguntaExamen;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaExamenRepo extends JpaRepository<PreguntaExamen,Integer> {

    @Query(nativeQuery = true, value = "select * from PreguntaExamen")
    List<PreguntaExamen> listaPreguntaExamen();



}
