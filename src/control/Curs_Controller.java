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
         List<UnitatFormativa> p = null;
         try{
             
         
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaUFCurs", UnitatFormativa.class);
        query.setParameter("id", id);
        p=(List<UnitatFormativa>) query.getResultList();
        if (p.isEmpty()||p==null) {
            throw new ExcepcionGenerica("ID", "Unitats Formatives");
        }
         }
         catch(ExcepcionGenerica ex){
             
         }
        return p;
    }
    
    public List<Modul> BuscarModulsCurs(Long id) {
        List<Modul> p = null;
        try{
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaModulCurs", Modul.class);
        query.setParameter("id", id);
        p = (List<Modul>) query.getResultList();
        if (p.isEmpty()||p==null) {
            throw new ExcepcionGenerica("ID", "Moduls");
        }
         }
         catch(ExcepcionGenerica ex){
             
         }
        return p;
    }

    
}
