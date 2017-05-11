package control;

import exception.ExcepcionGenerica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Modul;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric & Marcos
 */
public class Curs_Controller extends Generic_Controller {

    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Curs_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    /**
     * Metodo que busca las UF que perteneces a un Curso.
     *
     * @param id
     * @return
     */
    public List<UnitatFormativa> BuscarUFCurs(Long id) {
        List<UnitatFormativa> p = null;
        try {

            System.out.println("Busqueda per id");
            Query query = em.createNamedQuery("cercaUFCurs", UnitatFormativa.class);
            query.setParameter("id", id);
            p = (List<UnitatFormativa>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", "Unitats Formatives");
            }
        } catch (ExcepcionGenerica ex) {

        }
        return p;
    }

    /**
     * Metodo que busca los Modulos que pertencen a un Curso.
     *
     * @param id
     * @return
     */
    public List<Modul> BuscarModulsCurs(Long id) {
        List<Modul> p = null;
        try {
            System.out.println("Busqueda per id");
            Query query = em.createNamedQuery("cercaModulCurs", Modul.class);
            query.setParameter("id", id);
            p = (List<Modul>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", "Moduls");
            }
        } catch (ExcepcionGenerica ex) {

        }
        return p;
    }

}
