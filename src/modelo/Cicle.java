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
 * @author MarcosPortatil
 */
@Entity
@Table(name = "Cicles")
public class Cicle implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "cicleId", nullable = false, unique = true)
    private int id;
    
    @Column(name = "nomCicle", length = 50, nullable = false)
    private String nom;
    
    @Column(name = "grauCicle", length = 50)
    private String grau;
    
    private ArrayList<Modul> llistaModuls;
    private ArrayList<Curs> llistaCursos;

    public Cicle(int id, String nom, String grau, ArrayList<Modul> llistaModuls, ArrayList<Curs> llistaCursos) {
        this.id = id;
        this.nom = nom;
        this.grau = grau;
        this.llistaModuls = llistaModuls;
        this.llistaCursos = llistaCursos;
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

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public ArrayList<Modul> getLlistaModuls() {
        return llistaModuls;
    }

    public void setLlistaModuls(ArrayList<Modul> llistaModuls) {
        this.llistaModuls = llistaModuls;
    }

    public ArrayList<Curs> getLlistaCursos() {
        return llistaCursos;
    }

    public void setLlistaCursos(ArrayList<Curs> llistaCursos) {
        this.llistaCursos = llistaCursos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
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
        final Cicle other = (Cicle) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cicle{" + "id=" + id + ", nom=" + nom + ", grau=" + grau + ", llistaModuls=" + llistaModuls + ", llistaCursos=" + llistaCursos + '}';
    }
    
    

}
