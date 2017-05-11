/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.ExcepcionGenerica;
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

    public Alumne BuscarPerCognom(String cognom){
       Alumne p= null;
               // Recupera el entity manager       
        try{
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
        
        }catch(ExcepcionGenerica ex) {
              
                }
        return p;
    }
    


}
