package control;

import exception.ExcepcionGenerica;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Alumne;

/**
 *
 * @author Eric
 */
public class Alumne_Controller extends Generic_Controller<Alumne> {

    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Alumne_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    /**
     * Metodo que busca un Alumno por su apellido.
     *
     * @param cognom
     * @return
     */
    public Alumne BuscarPerCognom(String cognom) {
        Alumne p = null;
        try {
            em = new EM_Controller().getEntityManager();
            System.out.println("Busqueda per cognom");
            Query query = em.createNamedQuery("alumneCognom", Alumne.class);
            query.setParameter("cognom", cognom);
            p = (Alumne) query.getSingleResult();
            if (p == null) {
                throw new ExcepcionGenerica("COG");
            }
            System.out.println("close");
            em.close();

        } catch (ExcepcionGenerica ex) {

        }
        return p;
    }

}
