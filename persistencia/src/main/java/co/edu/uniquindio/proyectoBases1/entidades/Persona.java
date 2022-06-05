package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.util.List;
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {

    @ToString.Include
    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @ToString.Include
    @Positive
    @Column(length = 1, nullable = false)
    private Integer tipo;

    @ToString.Include
    @Column(length = 50, nullable = false)
    private String nombre;

    @ToString.Include
    @Positive
    @Column(length = 3)
    private Integer edad;

    @ToString.Include
    @Email
    @Column(length = 70, nullable = false, unique = true)
    private String correo;

    @Column(length = 30, nullable = false)
    private String password;

    @ManyToMany(mappedBy = "listaEstudiantes")
    private List<Curso> listaResivirCursos;

    @ManyToMany(mappedBy = "listaDocentes")
    private List<Curso> listaDarCursos;

    @OneToMany(mappedBy = "docente")
    private List<Examen> listaExamenes;

    @OneToMany(mappedBy = "docente")
    private List<Pregunta> listaPreguntas;

    @OneToMany(mappedBy = "estudiante")
    private List<PresentacionExamen> listaPresentacionExamen;

}
