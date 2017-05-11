package control;

import exception.ExcepcionGenerica;

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
    //EM_Controller oem = new EM_Controller();

    public Generic_Controller(EntityManager entityManger) {
        this.em = entityManger;
    }

    public void Insertar(T p) {
        // Recupera el entity manager

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
     * Metode que li arriba per parametre un T per modificar-lo i actualitzar-lo
     * a la BBDD.
     *
     * @param p
     */
    public void Modificar(T p) {
        // Recupera el entity manager
        //EM_Controller oem = new EM_Controller();

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
        //EM_Controller oem = new EM_Controller();

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
        T c = null;
        try{
        System.out.println("busqueda");

        c = (T) em.find(classe, id);
        if (c == null) {
            throw new ExcepcionGenerica("ID", classe.getSimpleName());
        }

        System.out.println("close");

        
        }  catch(ExcepcionGenerica ex){
                
                }
        return c;
    }

    public List<T> ConsultaTots(String t) {
        // Recupera el entity manager     
        List<T> lista = null;
        try {
            System.out.println("Consulta");
            Query q = em.createQuery("FROM " + t);

            lista = (List<T>) q.getResultList();
            if (lista == null || lista.isEmpty()) {
                throw new ExcepcionGenerica("");
            }
            System.out.println("close");

        } catch (ExcepcionGenerica ex) {

        }
        return lista;
    }

    public void desconectar() {
        em.close();
    }

    public void conectar() {
        em = new EM_Controller().getEntityManager();
    }

}
