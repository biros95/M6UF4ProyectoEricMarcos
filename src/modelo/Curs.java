/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import utilitats.NombreDeCurs;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "Curs")
public class Curs implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cursId", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "nombreDeCurs", length = 5)
    private String nombreDeCurs;
    
    @OneToMany(mappedBy = "curs")
    private List<UnitatFormativa> listaUF;
    
    @ManyToOne
    @JoinColumn(name = "idCicle")
    private Cicle cicle;
    
    @OneToMany (mappedBy = "curs")
    private List<Modul> llistaModuls;

    public Curs() {
    }

    public Curs(Long id, String nombreDeCurs, Cicle cicle) {
        this.id = id;
        this.nombreDeCurs = nombreDeCurs;
        this.cicle = cicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDeCurs() {
        return nombreDeCurs;
    }

    public void setNombreDeCurs(String nombreDeCurs) {
        this.nombreDeCurs = nombreDeCurs;
    }

    public List<UnitatFormativa> getListaUF() {
        return listaUF;
    }

    public void setListaUF(List<UnitatFormativa> listaUF) {
        this.listaUF = listaUF;
    }

    public Cicle getCicle() {
        return cicle;
    }

    public void setCicle(Cicle cicle) {
        this.cicle = cicle;
    }

    public List<Modul> getLlistaModuls() {
        return llistaModuls;
    }

    public void setLlistaModuls(List<Modul> llistaModuls) {
        this.llistaModuls = llistaModuls;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Curs other = (Curs) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
