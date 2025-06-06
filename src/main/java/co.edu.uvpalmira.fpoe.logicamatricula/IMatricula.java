/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uvpalmira.fpoe;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Cupo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Curso;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 *
 * @author Univalle
 */
public interface IMatricula {

    public Asignatura findAsignaturaByCodigo(long codigo);

    public void save(Asignatura asignatura) throws SQLIntegrityConstraintViolationException, Exception;

    public Docente findDocente(long nuip);

    public void save(Docente docente) throws SQLIntegrityConstraintViolationException, Exception;

    public List<Docente> findAllDocente();
    
    public Programa findProgramaByCodigo(long codigo);

    public void save(Programa programa) throws SQLIntegrityConstraintViolationException, Exception;
    
    public List<Programa> findAllPrograma();
    
    public void save(Cupo cupo)throws SQLIntegrityConstraintViolationException, Exception;
    
    public List<Asignatura> findAllAsignatura();
    
    public void save(Horario horario)throws SQLIntegrityConstraintViolationException, Exception;
    
    public List<Horario> findAllHorarios();

    public void registrarCurso(Curso curso) throws SQLIntegrityConstraintViolationException, Exception;
}
