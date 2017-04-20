/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
@Table(name = "FamiliaCicles")
public class FamiliaCicles {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "familiaId", unique = true, nullable = false)
    private int id;

    @Column(name = "nom", nullable = false, length = 20 )
    private String nom;
    private ArrayList<Cicle> llistaCicles;

    public FamiliaCicles(int id, String nom, ArrayList<Cicle> llistaCicles) {
        this.id = id;
        this.nom = nom;
        this.llistaCicles = llistaCicles;
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

    public ArrayList<Cicle> getLlistaCicles() {
        return llistaCicles;
    }

    public void setLlistaCicles(ArrayList<Cicle> llistaCicles) {
        this.llistaCicles = llistaCicles;
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
        final FamiliaCicles other = (FamiliaCicles) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FamiliaCicles{" + "id=" + id + ", nom=" + nom + ", llistaCicles=" + llistaCicles + '}';
    }

}
