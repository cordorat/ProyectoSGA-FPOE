/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.AsignaturaDAO;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.HorarioDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.DayOfWeek;
import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author David
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HorarioDAOTest {
    
    private HorarioDAO horarioDAO;
    
    public HorarioDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoSGANewPUPRUEBA");
        this.horarioDAO = new HorarioDAO(emf);
        
    }
    
    @Test
    @Order(1)
    public void testCreate () throws Exception{
        Horario horario = new Horario(DayOfWeek.MONDAY, LocalTime.of(9, 00), LocalTime.of(11, 00));
        this.horarioDAO.create(horario);
        assertTrue(true);
    }
    
    
    
}
