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

public class Curso implements Serializable {

    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private Integer codigo;

    @ManyToMany
    private List<Persona> listaEstudiantes;

    @ManyToMany
    private List<Persona> listaDocentes;

    @OneToMany(mappedBy="curso")
    private List<Horario> horarios;

    @ManyToMany
    private List<Unidad> listaUnidades;

    //@ElementCollection para usar listas
    //map<string,string> clave, valor
}
