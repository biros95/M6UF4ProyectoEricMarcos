/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import utilitats.*;

/**
 *
 * @author Eric
 */


@Entity
@Table(name = "Matricula")
public class Matricula {
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "matriculaId", unique = true, nullable = false)
    private int id;
    
    private Alumne alumne;
    private Date data;
    private ArrayList<UnitatFormativa> llistaUnitats;
    
    @Column(name = "modalitat",length = 50, nullable = false)
        private String modalitat;
    @Column(name = "descompte",length = 50, nullable = false)
    private String descompte;

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

    public String getModalitat() {
        return modalitat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }

    public String getDescompte() {
        return descompte;
    }

    public void setDescompte(String descompte) {
        this.descompte = descompte;
    }

    public Matricula(int id, Alumne alumne, Date data, ArrayList<UnitatFormativa> llistaUnitats, String modalitat, String descompte) {
        this.id = id;
        this.alumne = alumne;
        this.data = data;
        this.llistaUnitats = llistaUnitats;
        this.modalitat = modalitat;
        this.descompte = descompte;
    }
}
