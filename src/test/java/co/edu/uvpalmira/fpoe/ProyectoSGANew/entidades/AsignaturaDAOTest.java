/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
*/
package co.edu.uvpalmira.fpoe.ProyectoSGANew.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.AsignaturaDAO;
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
public class AsignaturaDAOTest {

    private AsignaturaDAO asignaturaDAO;

    public AsignaturaDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoSGANewPUPRUEBA");
        this.asignaturaDAO = new AsignaturaDAO(emf);
    }

    @Order(1)
    @Test
    public void testCreate() throws Exception {
        Asignatura asignatura1 = new Asignatura(11075, "FPOE", 3, "4 horas");
        this.asignaturaDAO.create(asignatura1);
        assertTrue(true);
    }

    @Order(2)
    @Test
    public void testFind() throws Exception {
        Asignatura asignatura1 = this.asignaturaDAO.findByCodigo(11075L);
        assertEquals(asignatura1.getNombre(), "FPOE");
    }

    @Order(3)
    @Test
    public void testUpdate() throws Exception {
        Asignatura asignatura1 = this.asignaturaDAO.findByCodigo(11075L);
        asignatura1.setNombre("Programacion Orientada a Eventos");
        this.asignaturaDAO.edit(asignatura1);
        asignatura1 = this.asignaturaDAO.findByCodigo(11075L);
        assertEquals(asignatura1.getNombre(), "Programacion Orientada a Eventos");
    }

}