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
public class Cicle {

    private int id;
    private String nom;
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

}
