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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase de Modulo.
 *
 * @author Eric & Marcos
 */
@Entity
@Table(name = "Modul")
public class Modul implements Serializable {

    private static final long serialVersionUID = 1L;
    //Id de Modulo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modulId", unique = true, nullable = false)
    private Long id;
    //Atributos de Modulo.
    @Column(name = "modulNom", length = 50, nullable = false)
    private String nom;
    //Relacion OneToMany ya que un Modulo puede tener muchas UF y una UF pertenece a un Modulo
    @OneToMany(mappedBy = "modul", cascade = CascadeType.ALL)
    private List<UnitatFormativa> llistaUF;
    //Relacion ManyToOne ya que un Curs puede tener muchos Modulos, pero un Modulo pertenece a un Curso.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurs")
    private Curs curs;
    //Relacion ManyToOne ya que un Ciclo puede tener muchos Modulos, pero Ciclo pertenece a un Curso.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCicle")
    private Cicle cicle;

    public Modul() {
    }

    public Modul(Long id, String nom, Curs curs, Cicle cicle) {
        this.id = id;
        this.nom = nom;
        this.curs = curs;
        this.cicle = cicle;
    }

    public Modul(String nom, Curs curs, Cicle cicle) {
        this.nom = nom;
        this.curs = curs;
        this.cicle = cicle;
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

    public List<UnitatFormativa> getLlistaUF() {
        return llistaUF;
    }

    public void setLlistaUF(List<UnitatFormativa> llistaUF) {
        this.llistaUF = llistaUF;
    }

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    public Cicle getCicle() {
        return cicle;
    }

    public void setCicle(Cicle cicle) {
        this.cicle = cicle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Modul other = (Modul) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
