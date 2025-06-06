/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew;

import co.edu.uvpalmira.fpoe.persistence.jpa.entity.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author David
 */
@Entity
public class Curso extends AbstractEntity {

    @OneToOne(optional = false)
    private Periodo periodo;

    @OneToOne(optional = false)
    private Asignatura asignatura;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cupo> cupos;

    @OneToOne(optional = true)
    private Docente docente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Horario> horarios;

    @Column(nullable = false)
    private int grupo;

    @Column(nullable = false)
    private int totalCupos;

    public Curso() {
        this.horarios = new LinkedList<>();
        this.cupos = new LinkedList<>();
    }

    public Curso(Periodo periodo, Asignatura asignatura, Docente docente, int grupo) {
        this.periodo = periodo;
        this.asignatura = asignatura;
        this.docente = docente;
        this.grupo = grupo;
        this.totalCupos = 0;
        this.cupos = new LinkedList<>();
        this.horarios = new LinkedList<>();
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public List<Cupo> getCupos() {
        return cupos;
    }

    public Docente getDocente() {
        return docente;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public int getGrupo() {
        return grupo;
    }

    public int getTotalCupos() {
        return totalCupos;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setCupos(List<Cupo> cupos) {
        this.cupos = cupos;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setTotalCupos(int totalCupos) {
        this.totalCupos = totalCupos;
    }

    public void add(Horario horario) {
        if (this.horarios.size() <= 3) {
            this.horarios.add(horario);
        }
    }

    public void add(Cupo cupo) {
        this.cupos.add(cupo);
        this.totalCupos += cupo.getCantidad();
    }

}
