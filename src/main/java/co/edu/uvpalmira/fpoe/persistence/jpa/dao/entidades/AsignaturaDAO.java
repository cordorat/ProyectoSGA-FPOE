/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades;

import co.edu.uvpalmira.fpoe.persistence.jpa.dao.AbstractDAO;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 *
 
@author David*/
public class AsignaturaDAO extends AbstractDAO<Asignatura> {

    public AsignaturaDAO(EntityManagerFactory emf) {
        super(Asignatura.class, emf);
    }

    public Asignatura findByCodigo(long codigo) {
        EntityManager em = super.getEntityManager();
        return (Asignatura) em.createNamedQuery("Asignatura.findByCodigo").setParameter("codigo", codigo).getSingleResult();
    }

}
