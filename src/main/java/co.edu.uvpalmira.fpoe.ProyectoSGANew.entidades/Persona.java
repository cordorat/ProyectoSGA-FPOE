/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Genero;
import co.edu.uvpalmira.fpoe.persistence.jpa.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author David
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona extends AbstractEntity {
    @Enumerated (EnumType.STRING)
    private Genero genero;
    @Column(nullable = false, unique = true)
    private long nuip;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String apellidos;

    public Persona(Genero genero, long nuip, String nombres, String apellidos) {
        this.genero = genero;
        this.nuip = nuip;
        this.nombres = nombres;
        this.apellidos = apellidos;

    }

    public Persona() {
    }

    public Genero getGenero() {
        return genero;
    }

    public long getNuip() {
        return nuip;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setNuip(long nuip) {
        this.nuip = nuip;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
