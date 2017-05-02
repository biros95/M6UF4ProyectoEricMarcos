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

/**
 *
 * @author Eric
 */
public class Curs_Controller extends Generic_Controller {
    
    public Curs_Controller(EntityManager entityManger) {
        super(entityManger);
    }
    //TODO acabar de buscar cursos de un ciclo.
    public List<Cicle> BuscarPerId(Long id) {
      
        System.out.println("Busqueda per id");
        Query query = em.createNamedQuery("cercaCiclesFamilia", Cicle.class);
        query.setParameter("id", id);
        List<Cicle> p = (List<Cicle>) query.getResultList();
        System.out.println(p.size());
        System.out.println("close sunormah");        
        return p;
    }
    
}
