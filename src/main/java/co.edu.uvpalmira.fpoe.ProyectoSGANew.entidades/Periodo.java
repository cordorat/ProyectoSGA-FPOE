/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package co.edu.uvpalmira.fpoe.ProyectoSGANew;
import co.edu.uvpalmira.fpoe.persistence.jpa.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author David
 */

@Entity
public class Periodo extends AbstractEntity {
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private Month mesI;
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private Month mesF;
    @Column (nullable = false)
    private Year anioI;
    @Column (nullable = false)
    private Year anioF;

    public Periodo() {
    }
    
    public Periodo(Month mesI, Year anioI, Month mesF, Year anioF) {
        this.mesI = mesI;
        this.mesF = mesF;
        this.anioI = anioI;
        this.anioF = anioF;
    }

    public Month getMesI() {
        return mesI;
    }

    public Month getMesF() {
        return mesF;
    }

    public Year getAnioI() {
        return anioI;
    }

    public Year getAnioF() {
        return anioF;
    }

    public void setMesI(Month mesI) {
        this.mesI = mesI;
    }

    public void setMesF(Month mesF) {
        this.mesF = mesF;
    }

    public void setAnioI(Year anioI) {
        this.anioI = anioI;
    }

    public void setAnioF(Year anioF) {
        this.anioF = anioF;
    }



}
