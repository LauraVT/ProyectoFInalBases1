package co.edu.uniquindio.proyectoBases1.bean;

import co.edu.uniquindio.proyectoBases1.entidades.Examen;
import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import co.edu.uniquindio.proyectoBases1.entidades.Tema;
import co.edu.uniquindio.proyectoBases1.servicio.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ExamenBean implements Serializable {

    @Getter @Setter
    private Examen examen;

    @Autowired
    private ExamenServicio examenServicio;
    @Autowired
    private PreguntaServicio preguntaServicio;
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
    @PostConstruct
    public void init() {
        examen = new Examen();
        preguntaList =  preguntaServicio.listarPregunta();
        estudiantesList = personaServicio.listaEstudiantes();
        docenteList = personaServicio.listaDocentes();
        temaList= temaServicio.listarTemas();
    }

    public void ElaborarExamen() {
        try {
            examenServicio.elaborarExamen(examen);

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
            examenServicio.eliminarExamen(examen.getCodigo());

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
            examenServicio.modificarExamen(examen);

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
            examenServicio.asignarExamen(examen);

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
            examenServicio.obtenerExamen(examen.getCodigo());

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Elaboracion completada");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
}

