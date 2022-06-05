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

public class Tema implements Serializable {

    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    private Integer codigo;

    @ToString.Include
    @Column(length = 50, nullable = false)
    private String nombre;

    @ToString.Include
    @Column(length = 250, nullable = false)
    private String descripcion;

    @ManyToMany (mappedBy = "listaTema")
    private List<Examen> listaExamen;

    @OneToMany (mappedBy = "tema")
    private List<Pregunta> ListaPreguntas;

    @ManyToOne
    private Unidad unidad;
}
