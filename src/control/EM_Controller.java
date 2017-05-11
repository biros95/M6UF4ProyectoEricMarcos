package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eric & Marcos
 */
public class EM_Controller {

    public static EntityManager getEntityManager() {
        EntityManager em;
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXTERNA");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
        em = emf.createEntityManager();

        return em;
    }
}
