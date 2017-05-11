package control;

import exception.ExcepcionGenerica;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Eric & Marcos
 */
public class Generic_Controller<T> {

    EntityManager em;
    /**
     * Constructor que le llega el EntityManager
     *
     * @param entityManger
     */
    public Generic_Controller(EntityManager entityManger) {
        this.em = entityManger;
    }
    /**
     * Metodo generico que inserta los objetos en la BBDD.
     * @param p 
     */
    public void Insertar(T p) {

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
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

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        etx.commit();

        System.out.println("close");

    }

    /**
     * Metode utilitzat per eliminar un client de la BBDD
     *
     * @param p
     */
    public void Eliminar(T p) {

        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
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
    /**
     * Metodo que busca todos los objetos de T tipo y devuelve una lista.
     * @param t
     * @return 
     */
    public List<T> ConsultaTots(String t) {
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
    /**
     * Metodo para cerrar la conexion.
     */
    public void desconectar() {
        em.close();
    }
    /**
     * Metodo para abrir la conexion.
     */
    public void conectar() {
        em = new EM_Controller().getEntityManager();
    }

}
