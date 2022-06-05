package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pregunta implements Serializable {

    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Include
    private boolean publica;

    @ToString.Include
    @Positive
    @Column(length = 1, nullable = false)
    private Integer tipo;

    @ToString.Include
    @Column(length = 250, nullable = false)
    private String descripcion;

    @ManyToOne
    private Persona docente;

    @ManyToOne
    private Tema tema;

    /*
    @OneToMany
    private List<Pregunta> Listapregunta;
    */

    @OneToMany(mappedBy = "pregunta")
    private List<OpcionPregunta> listaOpcionesPregunta;

    @OneToMany(mappedBy = "pregunta")
    private List<PreguntaExamen> ListaPreguntasExamen;

    //RespuestaOpciones (esto se une con las preguntas del cliente)
}
