/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Alumne;

/**
 *
 * @author Eric
 */
public class Alumne_Controller extends Generic_Controller<Alumne>{
    
    public Alumne BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery("PersonaNom", Alumne.class);
        query.setParameter("nombre", nom);
        Alumne p = (Alumne) query.getSingleResult();
        System.out.println("close");
        em.close();

        return p;
    }
    
}
