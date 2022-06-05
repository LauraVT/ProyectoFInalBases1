package co.edu.uniquindio.proyectoBases1.bean;

import co.edu.uniquindio.proyectoBases1.entidades.*;
import co.edu.uniquindio.proyectoBases1.servicio.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class PresentacionExamenBean implements Serializable {

    @Getter
    @Setter
    private PresentacionExamen presentacionExamen;


    @Autowired
    private PresentacionExamenServicio presentacionExamenServicio;

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private TemaServicio temaServicio;

    @Getter @Setter
    private List<Pregunta> preguntaList;
    @Getter @Setter
    private List<Persona> estudiantesList;

    @Getter @Setter
    private List<Persona> docenteList;


    @Getter @Setter
    private List<Tema> temaList;

    @Getter @Setter
    private Examen examen;

    @PostConstruct
    public void init() {
        presentacionExamen = new PresentacionExamen();

        examen = new Examen();

        List<PreguntaExamen> preguntas = new ArrayList<>();

        Pregunta pregunta = new Pregunta();
        pregunta.setDescripcion("Elija la capital de Ecuador");

        List<OpcionPregunta> opciones = new ArrayList<>();
        OpcionPregunta opcionPregunta1 = new OpcionPregunta();
        opcionPregunta1.setDescripcion("Bogotá");
        opcionPregunta1.setRespuesta(0);
        opciones.add(opcionPregunta1);

        OpcionPregunta opcionPregunta2 = new OpcionPregunta();
        opcionPregunta2.setDescripcion("Madrid");
        opcionPregunta2.setRespuesta(0);
        opciones.add(opcionPregunta2);

        OpcionPregunta opcionPregunta3 = new OpcionPregunta();
        opcionPregunta3.setDescripcion("Quito");
        opcionPregunta3.setRespuesta(1);
        opciones.add(opcionPregunta3);

        pregunta.setListaOpcionesPregunta(opciones);

        Pregunta pregunta2 = new Pregunta();
        pregunta2.setDescripcion("Elija la capital de Ecuador otra");
        pregunta2.setListaOpcionesPregunta(opciones);

        Pregunta pregunta3 = new Pregunta();
        pregunta3.setDescripcion("Elija la capital de Ecuador otra dos");
        pregunta3.setListaOpcionesPregunta(opciones);

        PreguntaExamen preguntaExamen = new PreguntaExamen();
        preguntaExamen.setPregunta(pregunta);

        PreguntaExamen preguntaExamen2 = new PreguntaExamen();
        preguntaExamen2.setPregunta(pregunta2);

        PreguntaExamen preguntaExamen3 = new PreguntaExamen();
        preguntaExamen3.setPregunta(pregunta3);

        preguntas.add(preguntaExamen);
        preguntas.add(preguntaExamen2);
        preguntas.add(preguntaExamen3);

        examen.setListaPreguntaExamen(preguntas);

       // preguntaList =  preguntaServicio.listarPregunta();
       // estudiantesList = personaServicio.listaEstudiantes();
       // docenteList = personaServicio.listaDocentes();
       // temaList= temaServicio.listarTemas();
    }

    public void ResolverExamen() {
        try {
            presentacionExamenServicio.enviarExamen(presentacionExamen);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Elaboracion completada");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public void eliminarExamen() {
        try {
          //  examenServicio.eliminarExamen(examen.getCodigo());

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Elaboracion completada");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public void ModificarExamen() {
        try {
            //examenServicio.modificarExamen(examen);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Elaboracion completada");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void asignarExamen() {
        try {
         //   examenServicio.asignarExamen(presentacionExamen);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Elaboracion completada");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void obtenerExamen() {
        try {
           // examenServicio.obtenerExamen(presentacionExamen.getCodigo());

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Elaboracion completada");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

    public  PresentacionExamen cargarExamen(String cedula, int codigoExamen) {

        try {
            return presentacionExamenServicio.cargarExamen(cedula,codigoExamen);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
