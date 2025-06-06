/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.entidades;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Cupo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Curso;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Genero;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Periodo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David
 */
public class CursoTest {

    
    @Test
    public void testCurso(){
        Programa programa = new Programa(111, "Desarrollo de Software");
        Cupo cupo = new Cupo(programa, 25);
        Cupo cupo1 = new Cupo(programa, 30);
        Asignatura asignatura = new Asignatura(2274, "Calculo", 2, "2 horas");
        Docente docente = new Docente("Programador", Genero.MASCULINO, 1111478656, "David", "Cordoba");
        Periodo periodo = new Periodo(Month.FEBRUARY, Year.parse("2024"), Month.JUNE, Year.parse("2024"));
        Horario horario = new Horario(DayOfWeek.TUESDAY, LocalTime.of(13, 00), LocalTime.of(15, 00));
        //Curso curso = new Curso(periodo, asignatura, docente, 52);

        
        //assertEquals(100, curso.getTotalCupos());
    }

}  