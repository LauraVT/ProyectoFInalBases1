package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RespuestaPregunta implements Serializable {

    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ToString.Include
    @Column(nullable = false)
    private Integer respuesta;

    @ManyToOne
    private PreguntasPresentacion preguntasPresentacion;

    @OneToOne
    private OpcionPregunta opcionPregunta;
}
