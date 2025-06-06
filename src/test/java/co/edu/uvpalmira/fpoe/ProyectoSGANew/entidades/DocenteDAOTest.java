/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Genero;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.DocenteDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Juan
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocenteDAOTest {

    private DocenteDAO docenteDAO;

    public DocenteDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "ProyectoSGANewPUPRUEBA");
        this.docenteDAO = new DocenteDAO(emf);
    }

    @Order(1)
    @Test
    public void testCreate() throws Exception {
        Docente dct = new Docente("Desarrollo", Genero.FEMENINO, 12456879, "juan", "pituacan");
        this.docenteDAO.create(dct);
        assertTrue(true);
    }
    
    @Order(2)
    @Test
    public void testFind() throws Exception {
        Docente dct = this.docenteDAO.findByNuip(12456879L);
        assertEquals(dct.getNombres(), "juan");
    }

    @Order(3)
    @Test
    public void testUpdate() throws Exception {
        Docente dct = this.docenteDAO.findByNuip(12456879L);
        dct.setNombres("juan illo");
        this.docenteDAO.edit(dct);
        dct = this.docenteDAO.findByNuip(12456879L);
        assertEquals(dct.getNombres(), "juan illo");
    }
    
}
