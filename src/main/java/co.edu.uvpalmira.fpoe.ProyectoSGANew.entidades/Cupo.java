/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew;

import co.edu.uvpalmira.fpoe.persistence.jpa.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

/**
 *
 * @author David
 */
@Entity
public class Cupo extends AbstractEntity {

    @OneToOne(optional = false)
    private Programa programa;
    @Column(nullable = false)
    private int cantidad;

    public Cupo(Programa programa, int cantidad) {
        this.programa = programa;
        this.cantidad = cantidad;
    }

    public Cupo() {
    }

    public Programa getPrograma() {
        return programa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
