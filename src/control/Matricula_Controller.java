/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Alumne;
import modelo.Matricula;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric
 */
public class Matricula_Controller extends Generic_Controller{
    
    public Matricula_Controller(EntityManager entityManger) {
        super(entityManger);
    }
    
    public Matricula BuscarPerNif(String nif) {
        // Recupera el entity manager       
        em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per NIF");
        Query query = em.createNamedQuery("nifMatricula", Matricula.class);
        query.setParameter("nif", nif);
        Matricula p = (Matricula) query.getSingleResult();
        System.out.println("close");
        em.close();
        return p;
    }
    
    public List<Alumne> BuscarAlumneUF(String id) {
        // Recupera el entity manager       
        System.out.println("Busqueda per id");        
        UnitatFormativa uf = (UnitatFormativa) super.Buscar(Long.parseLong(id), UnitatFormativa.class);
        Query query = em.createNamedQuery("alumneUFMatricula", Alumne.class);
        query.setParameter("id", uf);
        List<Alumne> p = (List<Alumne>) query.getResultList();
        return p;
    }
    
}
