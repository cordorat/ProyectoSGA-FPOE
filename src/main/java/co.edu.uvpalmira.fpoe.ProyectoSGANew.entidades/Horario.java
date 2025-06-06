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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author David
 */
@Entity
public class Horario extends AbstractEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaSemana;
    @Column (name = "LOCALTIMEI", nullable = false)
    private LocalTime localTimeI;
    @Column (name = "LOCALTIMEF", nullable = false)
    private LocalTime localTimeF;
    

    public Horario() {
    }

    public Horario(DayOfWeek diaSemana, LocalTime localTimeI, LocalTime localTimeF) {
        this.diaSemana = diaSemana;
        this.localTimeI = localTimeI;
        this.localTimeF = localTimeF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public LocalTime getLocalTimeI() {
        return localTimeI;
    }

    public LocalTime getLocalTimeF() {
        return localTimeF;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setLocalTimeI(LocalTime localTimeI) {
        this.localTimeI = localTimeI;
    }

    public void setLocalTimeF(LocalTime localTimeF) {
        this.localTimeF = localTimeF;
    }



}
