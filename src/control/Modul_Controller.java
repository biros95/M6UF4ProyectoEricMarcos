package control;

import exception.ExcepcionGenerica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric & Marcos
 */
public class Modul_Controller extends Generic_Controller {
    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Modul_Controller(EntityManager entityManger) {
        super(entityManger);
    }
    /**
     * Metodo que busca por id de Modulo las UnidadesFormativas que tiene
     * @param id
     * @return 
     */
    public List<UnitatFormativa> BuscarUfModulo(Long id) {
        List<UnitatFormativa> p = null;
        try {
            System.out.println("Busqueda per id");
            Query query = em.createNamedQuery("cercaUFModul", UnitatFormativa.class);
            query.setParameter("id", id);
            p = (List<UnitatFormativa>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", "alumno");
            }
        } catch (ExcepcionGenerica ex) {

        }
        System.out.println(p.size());
        return p;
    }

}
