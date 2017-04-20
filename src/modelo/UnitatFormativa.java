/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */

@Entity
@Table(name = "UnitatFormativa")

public class UnitatFormativa {
      @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "unitatId", unique = true, nullable = false)
      
    private int id;
      
      @Column(name = "nom", nullable = false)
    private String nom;
      
    @Column(name = "hores", nullable = false)  
    private int hores;

    public UnitatFormativa(int id, String nom, int hores) {
        this.id = id;
        this.nom = nom;
        this.hores = hores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }
    
    
}
