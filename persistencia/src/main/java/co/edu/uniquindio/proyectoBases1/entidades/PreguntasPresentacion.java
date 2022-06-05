package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PreguntasPresentacion implements Serializable {
    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Integer codigo;

    @ManyToOne
    private PresentacionExamen presentacionExamen;

    @OneToMany(mappedBy = "preguntasPresentacion")
    private List<RespuestaPregunta> respuestaPresentacion;



}
