/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "Modul")
public class Modul implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modulId", unique = true, nullable = false)
    private int id;
    
    @Column(name = "modulNom", length = 50, nullable = false)
    private String nom;
    private ArrayList<UnitatFormativa> llistaUF;

    public Modul(int id, String nom, ArrayList<UnitatFormativa> llistaUF) {
        this.id = id;
        this.nom = nom;
        this.llistaUF = llistaUF;
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

    public ArrayList<UnitatFormativa> getLlistaUF() {
        return llistaUF;
    }

    public void setLlistaUF(ArrayList<UnitatFormativa> llistaUF) {
        this.llistaUF = llistaUF;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modul other = (Modul) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modul{" + "id=" + id + ", nom=" + nom + ", llistaUF=" + llistaUF + '}';
    }
    
    

}
