/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import utilitats.NombreDeCurs;

/**
 *
 * @author Eric
 */
@Entity
@NamedQueries({
@NamedQuery(name = "cercaModulCurs", query = "SELECT c FROM Modul c WHERE c.curs.id=:id"),
@NamedQuery(name = "cercaUFCurs", query = "SELECT c FROM UnitatFormativa c WHERE c.curs.id=:id")})
@Table(name = "Curs")
public class Curs implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cursId", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "nombreDeCurs")
    private NombreDeCurs nombreDeCurs;
    
    @OneToMany(mappedBy = "curs")
    private List<UnitatFormativa> listaUF;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCicle")
    private Cicle cicle;
    
    @OneToMany (mappedBy = "curs", cascade = CascadeType.ALL)
    private List<Modul> llistaModuls;

    public Curs() {
    }

    public Curs(NombreDeCurs nombreDeCurs, Cicle cicle) {
        this.nombreDeCurs = nombreDeCurs;
        this.cicle = cicle;
    }

    public Curs(Long id, NombreDeCurs nombreDeCurs, Cicle cicle) {
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

    public NombreDeCurs getNombreDeCurs() {
        return nombreDeCurs;
    }

    public void setNombreDeCurs(NombreDeCurs nombreDeCurs) {
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
        hash = 37 * hash + Objects.hashCode(this.id);
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
