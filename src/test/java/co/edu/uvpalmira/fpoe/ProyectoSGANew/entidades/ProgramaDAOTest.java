/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
*/
package co.edu.uvpalmira.fpoe.ProyectoSGANew.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.ProgramaDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 
@author David*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramaDAOTest {

    private ProgramaDAO programaDAO;

    public ProgramaDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoSGANewPUPRUEBA");
        this.programaDAO = new ProgramaDAO(emf);
    }

    @Order(1)
    @Test
    public void testCreate() throws Exception {
        Programa programa1 = new Programa(2724, "Desarrollo de Software");
        this.programaDAO.create(programa1);
        assertTrue(true);
    }

    @Order(2)
    @Test
    public void testFind() throws Exception {
        Programa programa1 = this.programaDAO.findByCodigo(2724L);
        assertEquals(programa1.getNombre(), "Desarrollo de Software");
    }

    @Order(3)
    @Test
    public void testUpdate() throws Exception {
        Programa programa1 = this.programaDAO.findByCodigo(2724L);
        programa1.setNombre("Electromecanica");
        this.programaDAO.edit(programa1);
        programa1 = this.programaDAO.findByCodigo(2724L);
        assertEquals(programa1.getNombre(), "Electromecanica");
    }

}