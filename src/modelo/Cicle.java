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

/**
 * Clase de Ciclo
 *
 * @author Eric & Marcos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "cercaCiclesFamilia", query = "SELECT c FROM Cicle c WHERE c.familia.id=:id")
    ,
@NamedQuery(name = "cercaCursosCicles", query = "SELECT c FROM Curs c WHERE c.cicle.id=:id")
    ,
@NamedQuery(name = "cercaModulsCicles", query = "SELECT c FROM Modul c WHERE c.cicle.id=:id")})
@Table(name = "Cicles")
public class Cicle implements Serializable {

    private static final long serialVersionUID = 1L;
    //Id de Ciclo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cicleId", nullable = false, unique = true)
    private Long id;
    //Atributos de Ciclo
    @Column(name = "nomCicle", length = 50, nullable = false)
    private String nom;

    @Column(name = "grauCicle", length = 50)
    private String grau;
    //Relacion OneToMany con Curso, ya que un Ciclo puede tener muchos Cursos, pero un Curso solo puede pertencer a un Ciclo.
    @OneToMany(mappedBy = "cicle", cascade = CascadeType.ALL)
    private List<Curs> llistaCursos;
    //Relacion OneToMany con Modulo, ya que un Ciclo puede tener muchos Modulos, pero un Modulo solo puede pertenecer a un Ciclo.
    @OneToMany(mappedBy = "cicle", cascade = CascadeType.ALL)
    private List<Modul> llistaModuls;
    //Relacion ManyToOne con FamiliaCicles, ya que un Ciclo solo puede pertenecer a una Familia, pero una Familia puede tener varios ciclos.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFamilia")
    private FamiliaCicles familia;

    public Cicle(Long id, String nom, String grau, FamiliaCicles familia) {
        this.id = id;
        this.nom = nom;
        this.grau = grau;
        this.familia = familia;
    }

    public Cicle(String nom, String grau, FamiliaCicles familia) {
        this.nom = nom;
        this.grau = grau;
        this.familia = familia;
    }

    public Cicle() {
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

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public List<Curs> getLlistaCursos() {
        return llistaCursos;
    }

    public void setLlistaCursos(List<Curs> llistaCursos) {
        this.llistaCursos = llistaCursos;
    }

    public FamiliaCicles getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaCicles familia) {
        this.familia = familia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Cicle other = (Cicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
