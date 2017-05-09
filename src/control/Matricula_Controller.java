/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Matricula;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric
 */
public class Matricula_Controller extends Generic_Controller{
    
    public Matricula_Controller(EntityManager entityManger) {
        super(entityManger);
    }
    
    public Matricula BuscarPerNif(String nif) {
        // Recupera el entity manager       
        em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per NIF");
        Query query = em.createNamedQuery("nifMatricula", Matricula.class);
        query.setParameter("nif", nif);
        Matricula p = (Matricula) query.getSingleResult();
        System.out.println("close");
        em.close();
        return p;
    }
    
}
