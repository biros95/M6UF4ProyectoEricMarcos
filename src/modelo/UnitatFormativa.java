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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para UnitatFormativa
 *
 * @author Eric & Marcos
 */
@Entity
@Table(name = "UnitatFormativa")
public class UnitatFormativa implements Serializable {

    private static final long serialVersionUID = 1L;
    //Id de UnitatFormativa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unitatId", unique = true, nullable = false)
    private Long id;
    //Atributos de UnitatFormativa
    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "hores", nullable = false)
    private int hores;
    //Relacion ManyToMany con Matricula, ya que una UF puede estar en muchas matriculas y viceversa
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Matricula> listaMatriculas;
    //Relacion ManyToOne ya que una UF puede estar en un Curso, pero un Curso puede tener muchas UF.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurs")
    private Curs curs;
    //Relacion ManyToOne con Modulo, ya que una UF puede estar en un Modulo pero un Modulo puede tener muchas UF.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idModul")
    private Modul modul;

    public UnitatFormativa() {
    }

    public UnitatFormativa(Long id, String nom, int hores, Curs curs, Modul modul) {
        this.id = id;
        this.nom = nom;
        this.hores = hores;
        this.curs = curs;
        this.modul = modul;
    }

    public UnitatFormativa(String nom, int hores, Curs curs, Modul modul) {
        this.nom = nom;
        this.hores = hores;
        this.curs = curs;
        this.modul = modul;
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

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public List<Matricula> getListaMatriculas() {
        return listaMatriculas;
    }

    public void setListaMatriculas(List<Matricula> listaMatriculas) {
        this.listaMatriculas = listaMatriculas;
    }

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final UnitatFormativa other = (UnitatFormativa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UnitatFormativa{" + "id=" + id + ", nom=" + nom + ", hores=" + hores + ", curs=" + curs + ", modul=" + modul + '}';
    }

}
