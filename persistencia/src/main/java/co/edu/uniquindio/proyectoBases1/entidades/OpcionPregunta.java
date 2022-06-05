package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class OpcionPregunta implements Serializable {

    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Include
    @PositiveOrZero
    @Column(length = 200)
    private String descripcion;

    @ToString.Include
    @Column(nullable = false)
    private Integer respuesta;
    @ManyToOne
    Pregunta pregunta;

    @OneToOne(mappedBy = "opcionPregunta")
    private RespuestaPregunta respuestaPregunta;
}
