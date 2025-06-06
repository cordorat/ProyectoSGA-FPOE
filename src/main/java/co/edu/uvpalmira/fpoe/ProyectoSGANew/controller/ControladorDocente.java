/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;

import co.edu.uvpalmira.fpoe.IMatricula;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Genero;


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
 * @author Juan
 */
@Named
@SessionScoped
public class ControladorDocente implements Serializable {
    
    @Inject
    private IMatricula matricula;
    
    private Docente dct = new Docente();
    private Genero[] generos = Genero.values();
    
    public Docente getDct() {
        return dct;
    }
    
      public void setDct(Docente dct) {
        this.dct = dct;
    }
    
    public void save(){
        try {
            this.matricula.save(this.dct);
            this.dct = new Docente ();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El docente fue guardado con exito. "));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }

    }
    public void cancel() {
        this.dct = new Docente();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso cancelado"));
        
    }
    
    public Genero[] getGeneros() {
        return generos;
    }
    public List<Docente> getDocentes() {
        return this.matricula.findAllDocente();
    }
}
