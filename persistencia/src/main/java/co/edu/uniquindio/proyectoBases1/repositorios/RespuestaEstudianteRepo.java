package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.RespuestaPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaEstudianteRepo extends JpaRepository<RespuestaPregunta, Integer> {
}
