/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades;

import co.edu.uvpalmira.fpoe.persistence.jpa.dao.AbstractDAO;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 *
 
@author David*/
public class ProgramaDAO extends AbstractDAO<Programa> {

    public ProgramaDAO(EntityManagerFactory emf) {
        super(Programa.class, emf);
    }

    public Programa findByCodigo(long codigo) {
        EntityManager em = super.getEntityManager();
        return (Programa) em.createNamedQuery("Programa.findByCodigo").setParameter("codigo", codigo).getSingleResult();
    }

}
