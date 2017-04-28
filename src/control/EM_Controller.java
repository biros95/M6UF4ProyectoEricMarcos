/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eric
 */
public class EM_Controller {

    public static EntityManager getEntityManager() {
         EntityManager em;
        try {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
        em = emf.createEntityManager();
        } catch(Exception ex){
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("EXTERNA");
        em = emf.createEntityManager();
        }
       
        return em;
    }
}
