/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/**
 *
 * @author David
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Docente.findByNuip",
            query = "SELECT d FROM Docente AS d WHERE d.nuip = :nuip")
        })
public class Docente extends Persona{
    @Column (nullable = false)
    private String profesion;

  
    public Docente(String profesion, Genero genero, long nuip, String nombres, String apellidos) {
        super(genero, nuip, nombres, apellidos);
        this.profesion = profesion;
    }

    public Docente() {
    }
    
    
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    
}
