/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Eric
 */
public class Modul {

    private int id;
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

}
