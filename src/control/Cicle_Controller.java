package control;

import exception.ExcepcionGenerica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Curs;
import modelo.Modul;

/**
 *
 * @author Eric & Marcos.
 */
public class Cicle_Controller extends Generic_Controller {

    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Cicle_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    /**
     * Metodo que busca los Cursos que pertenecen a un Ciclo.
     *
     * @param id
     * @return
     */
    public List<Curs> BuscarCursosCicle(Long id) {
        List<Curs> p = null;
        try {
            System.out.println("Busqueda per id");
            Query query = em.createNamedQuery("cercaCursosCicles", Curs.class);
            query.setParameter("id", id);
            p = (List<Curs>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", "curs");
            }
            System.out.println(p.size());
        } catch (ExcepcionGenerica ex) {

        }
        return p;
    }

    /**
     * Metodo que busca los Modulos que pertencen a un Ciclo.
     *
     * @param id
     * @return
     */
    public List<Modul> BuscarModulsCicle(Long id) {
        List<Modul> p = null;
        try {
            System.out.println("Busqueda per id");
            Query query = em.createNamedQuery("cercaModulsCicles", Modul.class);
            query.setParameter("id", id);
            p = (List<Modul>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", "curs");
            }
            System.out.println(p.size());
        } catch (ExcepcionGenerica ex) {

        }
        System.out.println(p.size());
        return p;
    }

}
