/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;




import co.edu.uvpalmira.fpoe.IMatricula;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Univalle
 */
@Named
@SessionScoped
public class ControladorPrograma implements Serializable{
    
    @Inject
    private IMatricula matricula;
    
    private Programa programa = new Programa();

    public IMatricula getMatricula() {
        return matricula;
    }

    public Programa getPrograma() {
        return programa;
    }

    
    public void save(){
        try {
            this.matricula.save(this.programa);
            this.programa = new Programa ();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El programa fue guardada con exito. "));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
            Logger.getLogger(ControladorAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancel(){
        this.programa = new Programa ();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso cancelado "));
    }
    
    public void search(){
        try {
            this.programa = this.matricula.findProgramaByCodigo(this.programa.getCodigo());
        } catch (jakarta.persistence.NoResultException ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                            "No se encuentra el programa con codigo" + this.programa.getCodigo()));
        } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        ex.getMessage()));
                Logger.getLogger(ControladorAsignatura.class.getName())
                        .log(Level.SEVERE, null, ex);
        }
            
        }

}
