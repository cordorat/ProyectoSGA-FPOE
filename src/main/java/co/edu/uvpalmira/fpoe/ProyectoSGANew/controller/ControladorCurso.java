/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;

import co.edu.uvpalmira.fpoe.IMatricula;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Cupo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Curso;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Periodo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
@Named
@SessionScoped
public class ControladorCurso implements Serializable {

    @Inject
    private IMatricula matricula;
    
    private Periodo periodo;

    private Curso curso = new Curso();

    private Asignatura asignatura = new Asignatura();

    private Docente docente = new Docente();

    private Cupo cupo = new Cupo();

    private Horario horario = new Horario();

    private Programa programa = new Programa();

    private DayOfWeek[] dias = DayOfWeek.values();
    
    private Month[] meses = Month.values();

    public Month[] getMeses() {
        return meses;
    }

    public IMatricula getMatricula() {
        return matricula;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public DayOfWeek[] getDias() {
        return dias;
    }

    public Curso getCurso() {
        return curso;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Docente getDocente() {
        return docente;
    }

    public Cupo getCupo() {
        return cupo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setDias(DayOfWeek[] dias) {
        this.dias = dias;
    }

    public void setMatricula(IMatricula matricula) {
        this.matricula = matricula;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setMeses(Month[] meses) {
        this.meses = meses;
    }   

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setCupo(Cupo cupo) {
        this.cupo = cupo;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void findAsignatura() {
        try {
            this.asignatura = this.matricula.findAsignaturaByCodigo(this.asignatura.getCodigo());
            this.curso.setAsignatura(this.asignatura);
        } catch (jakarta.persistence.NoResultException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                            "No se encuentra la asignatura con el codigo: " + this.asignatura.getCodigo()));
            this.asignatura = new Asignatura();
        }
    }

    public void findDocente() {
        try {
            this.docente = this.matricula.findDocente(this.docente.getNuip());
            this.curso.setDocente(this.docente);
        } catch (jakarta.persistence.NoResultException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                            "No se encuentra el docente con identificacion: "
                            + this.docente.getNuip()));
            this.docente = new Docente();
        }
    }

    public void cancel() {
        this.asignatura = new Asignatura();
        this.docente = new Docente();
        this.cupo = new Cupo();
        this.curso = new Curso();
        this.horario = new Horario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proceso cancelado"));

    }

    public void addProgramaAcademico() throws Exception {
        try {
            this.matricula.save(this.cupo);
            this.curso.add(this.cupo);
            this.cupo = new Cupo();
        } catch (jakarta.persistence.NoResultException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                            "No se ha seleccionado programa"
                            + this.cupo.getPrograma().getCodigo()));
        }
    }

    public void addHorario() throws Exception {
        this.matricula.save(this.horario);
        this.curso.add(this.horario);
        this.horario = new Horario();
    }

    public void registrarCurso() throws Exception {
        try {
            this.curso.setPeriodo(this.periodo);
            this.matricula.registrarCurso(this.curso);
            this.horario = new Horario();
            this.curso = new Curso();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El curso fue guardado con exito. "));
        } catch (jakarta.persistence.NoResultException ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
                            "No se ha podido matricular el curso " + this.curso.getGrupo()));
            this.curso = new Curso();
            this.horario = new Horario();
        }

    }

    public List<Programa> getProgramas() {
        return this.matricula.findAllPrograma();
    }

}
