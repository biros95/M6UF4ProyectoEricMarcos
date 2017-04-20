/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Eric
 */
public class UnitatFormativa {
    
    private int id;
    private String nom;
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
