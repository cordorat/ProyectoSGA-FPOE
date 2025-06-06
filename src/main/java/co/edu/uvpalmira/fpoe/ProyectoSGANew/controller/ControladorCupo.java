/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;

import co.edu.uvpalmira.fpoe.IMatricula;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Cupo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
@Named
@SessionScoped
public class ControladorCupo implements Serializable {
    
    @Inject
    private IMatricula matricula;
    
    private Cupo cup = new Cupo();
    
    public Cupo getCup(){
        return cup;
    }
    
    public void save(){
        try {
            this.matricula.save(this.cup);
            this.cup = new Cupo ();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El Cupo fue guardado con exito. "));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }

    }
    public void cancel() {
        this.cup = new Cupo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso cancelado"));
        
    }
    
    public List<Programa> getProgramas() {
        return this.matricula.findAllPrograma();
    }
}
