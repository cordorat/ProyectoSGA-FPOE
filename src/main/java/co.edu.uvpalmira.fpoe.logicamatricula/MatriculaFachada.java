/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe;

import co.edu.uvpalmira.fpoe.ProyectoSGANew.Asignatura;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Cupo;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Curso;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Docente;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Horario;
import co.edu.uvpalmira.fpoe.ProyectoSGANew.Programa;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.AsignaturaDAO;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.CupoDAO;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.CursoDAO;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.DocenteDAO;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.HorarioDAO;
import co.edu.uvpalmira.fpoe.persistence.jpa.dao.entidades.ProgramaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.List;

/**
 *
 *
 * @author Univalle
 */
@ApplicationScoped
public class MatriculaFachada implements IMatricula {

    @PersistenceUnit(name = "ProyectoSGANewPU")
    private EntityManagerFactory emf;
    private AsignaturaDAO asignaturaDAO;
    private DocenteDAO docenteDAO;
    private ProgramaDAO programaDAO;
    private CupoDAO cupoDAO;
    private HorarioDAO horarioDAO;
    private CursoDAO cursoDAO;

    public MatriculaFachada() {
    }

    @PostConstruct
    public void init() {
        this.asignaturaDAO = new AsignaturaDAO(emf);
        this.docenteDAO = new DocenteDAO(emf);
        this.programaDAO = new ProgramaDAO(emf);
        this.cupoDAO = new CupoDAO(emf);
        this.horarioDAO = new HorarioDAO(emf);
        this.cursoDAO = new CursoDAO(emf);
    }

    @Override
    public Asignatura findAsignaturaByCodigo(long codigo) {
        return this.asignaturaDAO.findByCodigo(codigo);
    }

    @Override

    public void save(Asignatura asignatura) throws SQLIntegrityConstraintViolationException, Exception {
        this.asignaturaDAO.save(asignatura);
    }

    @Override

    public List<Asignatura> findAllAsignatura() {
        return this.asignaturaDAO.findEntities();
    }

    @Override
    public Docente findDocente(long nuip) {
        return this.docenteDAO.findByNuip(nuip);
    }

    @Override
    public void save(Docente docente) throws SQLIntegrityConstraintViolationException, Exception {
        this.docenteDAO.save(docente);
    }

    @Override
    public List<Docente> findAllDocente() {
        return this.docenteDAO.findEntities();
    }

    @Override
    public Programa findProgramaByCodigo(long codigo) {
        return this.programaDAO.findByCodigo(codigo);
    }

    @Override

    public void save(Programa programa) throws SQLIntegrityConstraintViolationException, Exception {
        this.programaDAO.save(programa);
    }

    @Override
    public void save(Cupo cupo) throws SQLIntegrityConstraintViolationException, Exception {
        this.cupoDAO.save(cupo);
    }

    @Override
    public List<Programa> findAllPrograma() {
        return this.programaDAO.findEntities();
    }

    @Override
    public void save(Horario horario) throws SQLIntegrityConstraintViolationException, Exception {
        this.horarioDAO.save(horario);
    }

    @Override
    public List<Horario> findAllHorarios() {
        return this.horarioDAO.findEntities();
    }

    @Override
    public void registrarCurso(Curso curso) throws SQLIntegrityConstraintViolationException, Exception {
        this.cursoDAO.save(curso);
    }
}
