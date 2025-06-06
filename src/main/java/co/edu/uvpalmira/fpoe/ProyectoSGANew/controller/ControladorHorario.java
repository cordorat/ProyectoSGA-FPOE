/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;




import co.edu.uvpalmira.fpoe.IMatricula;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Univalle
 */
@Named
@SessionScoped
public class ControladorHorario implements Serializable{
    
    @Inject
    private IMatricula matricula;
    
    private Horario horario = new Horario();

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    
    public void save(){
        try {
            this.matricula.save(this.horario);
            this.horario = new Horario ();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El horario fue guardado con exito. "));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
            Logger.getLogger(ControladorAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancel(){
        this.horario = new Horario ();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso cancelado "));
    }
            
    
    public List<Horario> getHorarios() {
        return this.matricula.findAllHorarios();
    }
}
