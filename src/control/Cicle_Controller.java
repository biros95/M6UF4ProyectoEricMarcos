/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaCursosCicles", Curs.class);
        query.setParameter("id", id);
        List<Curs> p = (List<Curs>) query.getResultList();
        System.out.println(p.size());
        return p;
    }

    public List<Modul> BuscarModulsCicle(Long id) {
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaModulsCicles", Modul.class);
        query.setParameter("id", id);
        List<Modul> p = (List<Modul>) query.getResultList();
        System.out.println(p.size());
        return p;
    }

}
