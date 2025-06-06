/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;




import co.edu.uvpalmira.fpoe.IMatricula;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;
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
public class ControladorAsignatura implements Serializable{
    
    @Inject
    private IMatricula matricula;
    
    private Asignatura asignatura = new Asignatura();

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    
    public void save(){
        try {
            this.matricula.save(this.asignatura);
            this.asignatura = new Asignatura ();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La asignatura fue guardada con exito. "));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
            Logger.getLogger(ControladorAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cancel(){
        this.asignatura = new Asignatura ();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso cancelado "));
    }
    
    public void search(){
        try {
            this.asignatura = this.matricula.findAsignaturaByCodigo(this.asignatura.getCodigo());
        } catch (jakarta.persistence.NoResultException ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                            "No se encuentra la asignatura con identificacion " + this.asignatura.getCodigo()));
        } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        ex.getMessage()));
                Logger.getLogger(ControladorAsignatura.class.getName())
                        .log(Level.SEVERE, null, ex);
        }
            
        }
    public List<Asignatura> getAsignaturas() {
        return this.matricula.findAllAsignatura();
    }
}
