/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author MarcosPortatil
 */
public class FamiliaCicles {
    private int id;
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
    
}
