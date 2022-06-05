package co.edu.uniquindio.proyectoBases1.repositorios;

import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepo extends JpaRepository<Tema,Integer> {

    @Query(nativeQuery = true, value = "select * from Tema t where t.codigo = codigo")
    Tema ObtenerTema(Integer codigo);

    @Query(nativeQuery = true, value = "select sum(correctas)  from (\n" +
            "select count(*) correctas, 'correctas' respuestas from (select rp.codigo codigo FROM respuesta_pregunta rp join opcion_pregunta op ON op.codigo = rp.opcion_pregunta_codigo join pregunta p on op.pregunta_codigo = p.codigo join tema t on p.tema_codigo = codigoTema where op.respuesta = rp.respuesta) c\n" +
            "union\n" +
            "select count(*) incorrectas, 'incorrectas' mala from(SELECT rp.codigo codigo FROM respuesta_pregunta rp join opcion_pregunta op ON op.codigo = rp.opcion_pregunta_codigo join pregunta p on op.pregunta_codigo = p.codigo join tema t on p.tema_codigo = codigoTema where op.respuesta <> rp.respuesta) i\n" +
            ")t")
    Object obtenerPorcentajeTema(Integer codigoTema);
}