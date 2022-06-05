package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,String> {

    @Query(nativeQuery = true, value = "select * from Persona p where p.cedula = cedula")
    Persona obtenerPersona(String cedula);

    @Query("select p from Persona p")
    List<Persona> listaPersonas();

    //  @Query("select p from Persona p where p.correo = :email")
    // Persona obtenerePersonaPorEmail(String email);

    Optional<Persona> findByCorreo(String correo);

    Optional<Persona> findByCorreoAndAndPassword(String email, String password);

    @Query(value = "select p.nombre from Persona p", nativeQuery = true)
    List<String> listaNombre();

    @Query(nativeQuery = true, value = "select * from Persona p where p.tipo = 1")
    List<Persona> obtenerDocente();

}