/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Cupo;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.AbstractDAO;
import jakarta.persistence.EntityManagerFactory;

/**
 *
 * @author Juan
 */
public class CupoDAO extends AbstractDAO<Cupo> {

    public CupoDAO(EntityManagerFactory emf) {
        super(Cupo.class, emf);
    }

}
