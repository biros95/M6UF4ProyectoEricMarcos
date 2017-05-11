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
        Matricula p = null;
        try{
        em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per NIF");
        Query query = em.createNamedQuery("nifMatricula", Matricula.class);
        query.setParameter("nif", nif);
        p = (Matricula) query.getSingleResult();
            if (p == null) {
                throw new ExcepcionGenerica("ID", "Matricula");
            }
        System.out.println("close");
        em.close();
        } catch(ExcepcionGenerica ex){
            
        }
        return p;
    }
    
    public List<Alumne> BuscarAlumneUF(UnitatFormativa id) {
        // Recupera el entity manager    
        List<Alumne> p =null;
        try{
            
        
        System.out.println("Busqueda per id");        
        Query query = em.createNamedQuery("alumneUFMatricula", Alumne.class);
        query.setParameter("id", id);
        System.out.println(query.getResultList().size());
        p = (List<Alumne>) query.getResultList();
            if (p.isEmpty() || p ==null) {
            throw new ExcepcionGenerica("ID","Alumno");
            }
        }catch(ExcepcionGenerica ex){
            
        }
        
        return p;
    }
    
    public List<UnitatFormativa> BuscarUFMatricula(Long id) {
        // Recupera el entity manager      
        List<UnitatFormativa> p = null;
        try{
        System.out.println("Busqueda per matricula");        
        Query query = em.createNamedQuery("ufsMatricula", UnitatFormativa.class);
        query.setParameter("id", id);
        System.out.println(query.getResultList().size());
        p = (List<UnitatFormativa>) query.getResultList();
           if (p == null) {
                throw new ExcepcionGenerica("ID", "UF");
            }
        System.out.println("close");
        em.close();
        } catch(ExcepcionGenerica ex){
            
        }
        return p;
    }
    
    public List<Alumne> BuscarAlumneCurs(Long id) {
        // Recupera el entity manager
        List<Alumne> p = null;
        try{
        System.out.println("Busqueda per id");        
        Query query = em.createNamedQuery("alumnePerCurs", Alumne.class);
        query.setParameter("id", id);
        System.out.println(query.getResultList().size());
        p = (List<Alumne>) query.getResultList();
           if (p == null) {
                throw new ExcepcionGenerica("ID", "alumno");
            }
        System.out.println("close");
        em.close();
        } catch(ExcepcionGenerica ex){
            
        }
        return p;
    }
    
    public List<Alumne> BuscarAlumneFamilia(Long id) {
        // Recupera el entity manager      
        List<Alumne> p = null;
        try{
        System.out.println("Busqueda per id");        
        Query query = em.createNamedQuery("alumnePerFamilia", Alumne.class);
        query.setParameter("id", id);
        System.out.println(query.getResultList().size());
       p = (List<Alumne>) query.getResultList();
        if (p == null) {
            throw new ExcepcionGenerica("ID", "Alumno");
        }
        }catch(ExcepcionGenerica ex){
            
        }
        return p;
    }
    
}
