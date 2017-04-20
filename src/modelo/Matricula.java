/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import utilitats.*;

/**
 *
 * @author Eric
 */
public class Matricula {
    private int id;
    private Alumne alumne;
    private Date data;
    private ArrayList<UnitatFormativa> llistaUnitats;
    private Modalitat modalitat;
    private Descompte descompte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<UnitatFormativa> getLlistaUnitats() {
        return llistaUnitats;
    }

    public void setLlistaUnitats(ArrayList<UnitatFormativa> llistaUnitats) {
        this.llistaUnitats = llistaUnitats;
    }

    public Modalitat getModalitat() {
        return modalitat;
    }

    public void setModalitat(Modalitat modalitat) {
        this.modalitat = modalitat;
    }

    public Descompte getDescompte() {
        return descompte;
    }

    public void setDescompte(Descompte descompte) {
        this.descompte = descompte;
    }

    public Matricula(int id, Alumne alumne, Date data, ArrayList<UnitatFormativa> llistaUnitats, Modalitat modalitat, Descompte descompte) {
        this.id = id;
        this.alumne = alumne;
        this.data = data;
        this.llistaUnitats = llistaUnitats;
        this.modalitat = modalitat;
        this.descompte = descompte;
    }
}
