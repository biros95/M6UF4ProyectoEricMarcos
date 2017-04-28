package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Eric
 */
public class Generic_Controller<T> {

    EntityManager em;
    
    public Generic_Controller(EntityManager entityManger) {
        this.em = entityManger;
    }
    
    
    
    public void Insertar(T p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");

    }

    /**
     * Metode que li arriba per parametre un T per modificar-lo i
     * actualitzar-lo a la BBDD.
     *
     * @param p
     */
    public void Modificar(T p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");

    }

    /**
     * Metode utilitzat per eliminar un client de la BBDD
     *
     * @param p
     */
    public void Eliminar(T p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");

    }

    /**
     * Metode utilitzat per buscar un client per la seva id i tornar el objecte
     * sencer.
     *
     * @param id
     * @return
     */
    public T Buscar(T id, Class<T> classe) {
        // Recupera el entity manager

        System.out.println("busqueda");

        T c = (T) em.find(classe, id);

        System.out.println("close");


        return c;
    }
    
        public List<T> ConsultaTots(String t) {
        // Recupera el entity manager        
        System.out.println("Consulta");
        Query q = em.createQuery("FROM " + t);
        List<T> lista = (List<T>) q.getResultList();
        System.out.println("close");

        return lista;
    }
        
        public void desconectar(){
            em.close();
        }
        
        public void conectar(){
            em = new EM_Controller().getEntityManager();
        }
    
}
