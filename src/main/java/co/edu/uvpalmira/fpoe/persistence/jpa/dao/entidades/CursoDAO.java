/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Curso;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.AbstractDAO;
import jakarta.persistence.EntityManagerFactory;


/**
 *
 * @author David
 */
public class CursoDAO extends AbstractDAO<Curso>{
    public CursoDAO(EntityManagerFactory emf) {
        super(Curso.class, emf);
    }
    
}
