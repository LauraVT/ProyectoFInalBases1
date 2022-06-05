package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(length = 3)
    private Integer codigo;

    @ToString.Include
    @Column(length = 20, nullable = false)
    private String aula;

    @ToString.Include
    @Column(nullable = false)
    private LocalDateTime horaInicio;

    @ToString.Include
    @Column(nullable = false)
    private LocalDateTime horaFin;

    @ToString.Include
    @Column(nullable = false)
    private LocalDate dia;

    @ManyToOne
    private Curso curso;


}

