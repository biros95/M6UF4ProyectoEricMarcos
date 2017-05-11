package control;

import exception.ExcepcionGenerica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Alumne;
import modelo.Matricula;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric & Marcos
 */
public class Matricula_Controller extends Generic_Controller {

    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Matricula_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    /**
     * Metodo que busca una Matricula por el NIF del alumno.
     *
     * @param nif
     * @return
     */
    public Matricula BuscarPerNif(String nif) {
        Matricula p = null;
        try {
            System.out.println("Busqueda per NIF");
            Query query = em.createNamedQuery("nifMatricula", Matricula.class);
            query.setParameter("nif", nif);
            p = (Matricula) query.getSingleResult();
            if (p == null) {
                throw new ExcepcionGenerica("ID", "Matricula");
            }
            System.out.println("close");
            em.close();
        } catch (ExcepcionGenerica ex) {

        }
        return p;
    }

    /**
     * Metodo que busca los Alumnos que hay matriculados en una UF.
     *
     * @param id
     * @return
     */
    public List<Alumne> BuscarAlumneUF(UnitatFormativa id) {
        List<Alumne> p = null;
        try {
            System.out.println("Busqueda per id");
            Query query = em.createNamedQuery("alumneUFMatricula", Alumne.class);
            query.setParameter("id", id);
            System.out.println(query.getResultList().size());
            p = (List<Alumne>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", "Alumno");
            }
        } catch (ExcepcionGenerica ex) {
        }
        return p;
    }

    /**
     * Metodo que busca UFS que tiene una Matricula.
     *
     * @param id
     * @return
     */
    public List<UnitatFormativa> BuscarUFMatricula(Long id) {
        List<UnitatFormativa> p = null;
        try {
            System.out.println("Busqueda per matricula");
            Query query = em.createNamedQuery("ufsMatricula", UnitatFormativa.class);
            query.setParameter("id", id);
            System.out.println(query.getResultList().size());
            p = (List<UnitatFormativa>) query.getResultList();
            if (p == null) {
                throw new ExcepcionGenerica("ID", "UF");
            }
            System.out.println("close");
            em.close();
        } catch (ExcepcionGenerica ex) {

        }
        return p;
    }
}
