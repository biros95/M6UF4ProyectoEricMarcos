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

    public EntityManager getEntityManager() {
        //Crear el gestor de persistencia EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("INTERNA");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaJPAPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
