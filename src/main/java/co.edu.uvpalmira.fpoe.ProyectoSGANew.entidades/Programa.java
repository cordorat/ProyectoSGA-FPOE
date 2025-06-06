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
 * @author David
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Programa.findByCodigo", query = "SELECT p FROM Programa AS p WHERE p.codigo = :codigo")
})
public class Programa extends AbstractEntity {

    @Column(nullable = false)
    private long codigo;
    @Column(nullable = false)
    private String nombre;

    public Programa(long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Programa() {
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
