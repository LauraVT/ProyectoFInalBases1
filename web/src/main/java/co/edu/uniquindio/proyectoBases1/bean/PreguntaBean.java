package co.edu.uniquindio.proyectoBases1.bean;

import co.edu.uniquindio.proyectoBases1.entidades.Pregunta;
import co.edu.uniquindio.proyectoBases1.servicio.PreguntaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class PreguntaBean implements Serializable {

    @Autowired
    private PreguntaServicio preguntaServicio;

    @Getter @Setter
    private Pregunta pregunta;

    @PostConstruct
    public void init(){
        pregunta = new Pregunta();
    }

    public void crearPregunta(){
        try {
        preguntaServicio.crearPregunta(pregunta);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void  modificarPregunta(){
        try{
            preguntaServicio. modificarPregunta(pregunta);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void eliminarPregunta() {
        try {
            preguntaServicio.eliminarPregunta(pregunta.getCodigo());

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
        public void listarPreguntas() {
            preguntaServicio.listarPregunta();

        }
}
