/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.AbstractDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 *
 * @author Juan
 */
public class DocenteDAO extends AbstractDAO<Docente> {
    
    public DocenteDAO(EntityManagerFactory emf) {
        super(Docente.class, emf);
    }
    
    public Docente findByNuip(long nuip){
        EntityManager em = super.getEntityManager();
        return (Docente) em.createNamedQuery("Docente.findByNuip")
                .setParameter("nuip",nuip).getSingleResult();
    }
    
}
