package co.edu.uniquindio.proyectoBases1.bean;

import co.edu.uniquindio.proyectoBases1.entidades.Tema;
import co.edu.uniquindio.proyectoBases1.servicio.TemaServicio;
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
public class TemaBean implements Serializable {

    @Autowired
    private TemaServicio temaServicio;

    @Getter @Setter
    private Tema tema;

    @PostConstruct
    public void init(){
        tema = new Tema();
    }
    public void crearTema(){
        try{
            temaServicio.crearTema(tema);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void actualizarTema(){
        try{
           temaServicio.modificarTema(tema);

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }
    public void eliminarTema(){
        try{
            temaServicio.eliminarTema(tema.getCodigo());

            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta",
                    "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msj);

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }

    }

}
