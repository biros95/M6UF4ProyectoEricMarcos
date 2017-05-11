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
import modelo.Cicle;
import modelo.FamiliaCicles;

/**
 *
 * @author Eric
 */
public class Familia_Controller extends Generic_Controller {

    public Familia_Controller(EntityManager entityManger) {
        super(entityManger);
    }

    public List<Cicle> BuscarPerFamilia(Long id) {
        System.out.println("Busqueda per id");
        List<Cicle> p = null;
        try {

            Query query = em.createNamedQuery("cercaCiclesFamilia", Cicle.class);
            query.setParameter("id", id);
             p= (List<Cicle>) query.getResultList();
            if (p.isEmpty() || p == null) {
                throw new ExcepcionGenerica("ID", Cicle.class.getSimpleName());
            }
            System.out.println(p.size());
            System.out.println("close");
        } catch (ExcepcionGenerica ex) {

        }
       
return p;
    }
     
}
