/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase FamiliaCicles
 *
 * @author Eric & Marcos
 */
@Entity
@Table(name = "FamiliaCicles")
public class FamiliaCicles implements Serializable {

    private static final long serialVersionUID = 1L;
    //Id de FamiliaCicles
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "familiaId", unique = true, nullable = false)
    private Long id;
    //Atributos de FamiliaCicles
    @Column(name = "nom", nullable = false, length = 20)
    private String nom;
    //Relacion OneToMnay ya que una Familia puede tener muchos ciclos, pero un ciclo solo puede pertenecer a una familia.
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<Cicle> llistaCicles;

    public FamiliaCicles() {
    }

    public FamiliaCicles(String nom) {
        this.nom = nom;
    }

    public FamiliaCicles(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Cicle> getLlistaCicles() {
        return llistaCicles;
    }

    public void setLlistaCicles(List<Cicle> llistaCicles) {
        this.llistaCicles = llistaCicles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
