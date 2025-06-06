/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades;


import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.AbstractDAO;
import jakarta.persistence.EntityManagerFactory;

/**
 *
 * @author David
 */
public class HorarioDAO extends AbstractDAO<Horario>{
    public HorarioDAO(EntityManagerFactory emf) {
        super(Horario.class, emf);
    }
}
