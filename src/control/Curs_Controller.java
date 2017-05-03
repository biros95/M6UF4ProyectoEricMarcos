/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Cicle;
import modelo.Curs;
import modelo.Modul;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric
 */
public class Curs_Controller extends Generic_Controller {
    
    public Curs_Controller(EntityManager entityManger) {
        super(entityManger);
    }
    
    public List<UnitatFormativa> BuscarUFCurs(Long id) {
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaUFCurs", UnitatFormativa.class);
        query.setParameter("id", id);
        List<UnitatFormativa> p = (List<UnitatFormativa>) query.getResultList();
        return p;
    }
    
    public List<Modul> BuscarModulsCurs(Long id) {
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaModulCurs", Modul.class);
        query.setParameter("id", id);
        List<Modul> p = (List<Modul>) query.getResultList();
        return p;
    }

    
}
