package control;

import exception.ExcepcionGenerica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Cicle;

/**
 *
 * @author Eric & Marcos
 */
public class Familia_Controller extends Generic_Controller {

    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Familia_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    /**
     * Metodo que busca los ciclos de una Familia por su ID.
     *
     * @param id
     * @return
     */
    public List<Cicle> BuscarPerFamilia(Long id) {
        System.out.println("Busqueda per id");
        List<Cicle> p = null;
        try {

            Query query = em.createNamedQuery("cercaCiclesFamilia", Cicle.class);
            query.setParameter("id", id);
            p = (List<Cicle>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", Cicle.class.getSimpleName());
            }
            System.out.println(p.size());
            System.out.println("close");
        } catch (ExcepcionGenerica ex) {

        }

        return p;
    }

}
