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
import utilitats.NombreDeCurs;

/**
 *
 * @author Eric
 */


@Entity
@Table(name = "Curs")
public class Curs {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cursId", unique = true, nullable = false)
    private int id;
    @Column(name = "nombreDeCurs", length = 5)
    private String nombreDeCurs;

    public Curs(int id, String nombreDeCurs) {
        this.id = id;
        this.nombreDeCurs = nombreDeCurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDeCurs() {
        return nombreDeCurs;
    }

    public void setNombreDeCurs(String nombreDeCurs) {
        this.nombreDeCurs = nombreDeCurs;
    }

 
}
