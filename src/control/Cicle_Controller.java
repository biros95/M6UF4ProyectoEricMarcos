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
import modelo.Curs;
import modelo.Modul;

/**
 *
 * @author Eric
 */
public class Cicle_Controller extends Generic_Controller {

    public Cicle_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    public List<Curs> BuscarCursosCicle(Long id) {
        List<Curs> p = null;
        try{
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaCursosCicles", Curs.class);
        query.setParameter("id", id);
        p = (List<Curs>) query.getResultList();
        if(p.isEmpty() || p==null){
            throw new ExcepcionGenerica("ID", "curs");
        }
        System.out.println(p.size());
        }catch(ExcepcionGenerica ex){
            
        }
        return p;
    }

    public List<Modul> BuscarModulsCicle(Long id) {
        List<Modul> p=null;
        try{
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaModulsCicles", Modul.class);
        query.setParameter("id", id);
        p = (List<Modul>) query.getResultList();
        if(p.isEmpty() || p==null){
            throw new ExcepcionGenerica("ID", "curs");
        }
        System.out.println(p.size());
        }catch(ExcepcionGenerica ex){
            
        }
        System.out.println(p.size());
        return p;
    }

}
