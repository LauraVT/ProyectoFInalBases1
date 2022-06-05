package co.edu.uniquindio.proyectoBases1.entidades;

import lombok.*;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Examen implements Serializable {

    @ToString.Include
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private Integer codigo;

    @ToString.Include
    @PositiveOrZero
    @Column(length = 3)
    private Integer notaMaxima;

    @ToString.Include
    @PositiveOrZero
    @Column(length = 3)
    private Integer notaMinima;

    @ToString.Include
    @Column(length = 70, nullable = false)
    private String descripcion;

    @ToString.Include
    @PositiveOrZero
    @Column(nullable = false)
    private Double peso;

    @ToString.Include
    @PositiveOrZero
    @Column(length = 3, nullable = false)
    private Integer numeroPreguntas;

    @Column(length = 15, nullable = false)
    private LocalDate fecha;

    @Column(length = 15, nullable = false)
    private String tiempoLimite;

    @Column(length = 15, nullable = false)
    private String horaInicio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Persona docente;

    @ManyToMany
    @JoinColumn(nullable = false)
    private List<Tema> listaTema;

    @OneToMany(mappedBy = "examen")
    private List<PreguntaExamen> listaPreguntaExamen;

    @OneToMany(mappedBy = "examen")
    private List<PresentacionExamen> listaPresentacionExamen;

    /*
      <p:outputLabel for="descripcion_e"  value="Descripcion: " />
                <p:inputText id ="descripcion_e"    value="#{examenBean.examen.descripcion}" required="true"/>

                <div class="p-field p-col-12 p-md-4" >
                    <p:outputLabel for="button" value="Fecha: "/>
                    <p:datePicker id="button" value="#{examenBean.examen.fecha}" showIcon="true"/>
                </div>

                <p:outputLabel for="preguntas"   value="Lista Preguntas: " />
                <p:selectOneMenu id="preguntas"      value="#{examenBean.examen.listapreguntaExamen}" required="true">
                    <f:selectItems value="#{examenBean.preguntaList}" var="pregunta" itemLabel="pregunta.nombre" itemValue="#{pregunta}"/>
                </p:selectOneMenu>

                <p:outputLabel for="temas"   value="Lista Temas: " />
                <p:selectOneMenu id="temas"      value="#{examenBean.examen.listapreguntaExamen}" required="true">
                    <f:selectItems value="#{examenBean.temaList}" var="tema" itemLabel="tema.nombre" itemValue="#{tema}"/>
                </p:selectOneMenu>

                <p:outputLabel for="estudiantes"   value="Lista Estudiantes: " />
                <p:selectOneMenu id="estudiantes"      value="#{examenBean.examen.listapreguntaExamen}" required="true">
                    <f:selectItems value="#{examenBean.estudiantesList}" var="estudiante" itemLabel="estudiantes.nombre" itemValue="#{estudiantes}"/>
                </p:selectOneMenu>

                <p:outputLabel for="docentes"   value="Lista Docentes: " />
                <p:selectOneMenu id="docentes"      value="#{examenBean.examen.listapreguntaExamen}" required="true">
                    <f:selectItems value="#{examenBean.docenteList}" var="docente" itemLabel="docentes.nombre" itemValue="#{docentes}"/>
                </p:selectOneMenu>

                <p:outputLabel for="notaMaxima_e"   value="Nota Maxima: " />
                <p:inputText id="notaMaxima_e"      value="#{examenBean.examen.notaMaxima}" required="true" />

                <p:outputLabel for="notaMinima_e"   value="Nota Minima: " />
                <p:inputText id="notaMinima_e"      value="#{examenBean.examen.notaMinima}" required="true" />

                <p:outputLabel for="peso_e" value="Peso: " />
                <p:inputText id="peso_e"    value="#{examenBean.examen.peso}" required="true" />

                <p:outputLabel for="n_Pregunta_e" value="Numero Preguntas: " />
                <p:inputText id="n_Pregunta_e"    value="#{examenBean.examen.numeroPreguntas}" required="true" />

                <p:outputLabel for="horaInicio_e"        value="Hora de inicio: " />
                <p:inputText id="horaInicio_e"           value="#{examenBean.examen.horaInicio}" required="true"/>

                <p:outputLabel for="tiempoLimite_e"        value="tiempo Limite " />
                <p:inputText id="tiempoLimite_e"           value="#{examenBean.examen.tiempoLimite}" required="true"/>
     */
}
