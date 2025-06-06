/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package co.edu.uvpalmira.fpoe.ProyectoSGANew;

import co.edu.uvpalmira.fpoe.persistence.jpa.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/**
 *
 
@author David*/
@Entity
@NamedQueries({
    @NamedQuery(name = "Asignatura.findByCodigo", query = "SELECT a FROM Asignatura AS a WHERE a.codigo = :codigo")
})
public class Asignatura extends AbstractEntity {
    @Column (nullable = false)
    private long codigo;
    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private int creditos;
    @Column (nullable = false)
    private String intensidad;

    public Asignatura(long codigo, String nombre, int creditos, String intensidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.intensidad = intensidad;
    }

    public Asignatura() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

}
