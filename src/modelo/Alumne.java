/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author MarcosPortatil
 */
@Entity
@Table(name = "Alumnes")
public class Alumne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId", unique = true, nullable = false)
    private Long id;

    @Column(name = "nom", length = 20, nullable = false)
    private String nom;

    @Column(name = "cognom", length = 50, nullable = false)
    private String cognom;

    @Column(name = "correu", length = 100)
    private String correu;

    @Column(name = "telefon", length = 11)
    private int telefon;

    @OneToOne(mappedBy = "alumneId")
    private Matricula matriculaId;

    public Alumne(Long id, String nom, String cognom, String correu, int telefon, Matricula matriculaId) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.correu = correu;
        this.telefon = telefon;
        this.matriculaId = matriculaId;
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

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public Matricula getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Matricula matriculaId) {
        this.matriculaId = matriculaId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Alumne other = (Alumne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumne{" + "id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", correu=" + correu + ", telefon=" + telefon + ", matriculaId=" + matriculaId + '}';
    }

    
}
