package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.PresentacionExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentacionExamenRepo extends JpaRepository <PresentacionExamen, Integer> {

    
    @Query(nativeQuery = true, value = "select * from Examen e where e.codigo = codigo")
    Examen obtenerExamen(Integer codigo);

    @Query(nativeQuery = true, value = "select * from PresentacionExamen p where p.estudiante.cedula = cedula and p.examen.codigo = codigoExamen")
    PresentacionExamen cargarExamen(String cedula, Integer codigoExamen);
}

