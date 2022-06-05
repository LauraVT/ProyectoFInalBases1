package co.edu.uniquindio.proyectoBases1.bean;

import co.edu.uniquindio.proyectoBases1.entidades.Persona;
import co.edu.uniquindio.proyectoBases1.servicio.PersonaServicio;
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

public class PersonaBean implements Serializable {

    @Autowired
    private PersonaServicio personaServicio;

    @Getter @Setter
    private Persona persona;

    @PostConstruct
    public void init(){
        persona = new Persona();
    }

    public void registarPersona(){
        try{
            personaServicio.registararPersona(persona);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void actualizarPersona(){
        try{
            personaServicio.actualizarPersona(persona);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void eliminarPersona(){
        try{
            personaServicio.eliminarPersona(persona.getCedula());

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
}
