package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Unidad {

    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    private Integer codigo;

    @OneToMany(mappedBy = "unidad")
    private List<Tema> Listatemas;

    @ManyToMany(mappedBy = "listaUnidades")
    private List<Curso> ListaCursos;
}
