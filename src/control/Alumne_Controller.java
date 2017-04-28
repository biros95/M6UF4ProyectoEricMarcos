/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Alumne;

/**
 *
 * @author Eric
 */
public class Alumne_Controller extends Generic_Controller<Alumne> {
    
    public Alumne_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    public Alumne BuscarPerCognom(String cognom) {
        // Recupera el entity manager       
        em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per cognom");
        Query query = em.createNamedQuery("alumneCognom", Alumne.class);
        query.setParameter("cognom", cognom);
        Alumne p = (Alumne) query.getSingleResult();
        System.out.println("close");
        em.close();
        return p;
    }
    


}
