package control;


import control.Generic_Controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.UnitatFormativa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class Modul_Controller extends Generic_Controller{
    
    public Modul_Controller(EntityManager entityManger) {
        super(entityManger);
    }
    
    public List<UnitatFormativa> BuscarCursosCicle(Long id) {
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaUFModul", UnitatFormativa.class);
        query.setParameter("id", id);
        List<UnitatFormativa> p = (List<UnitatFormativa>) query.getResultList();
        System.out.println(p.size());
        return p;
    }
    
}
