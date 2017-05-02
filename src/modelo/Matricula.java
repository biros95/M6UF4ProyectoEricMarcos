/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "Matricula")
public class Matricula implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "matriculaId", unique = true, nullable = false)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "alumneId")
    private Alumne alumneId;

    private Date data;

    @Column(name = "modalitat", length = 50, nullable = false)
    private String modalitat;

    @Column(name = "descompte", length = 50, nullable = false)
    private String descompte;
    
    @OneToOne(mappedBy = "matricula")
    private Import importId;
    
    @ManyToMany(mappedBy = "listaMatriculas")
    private List<UnitatFormativa> listaUF;

    public Matricula(Long id, Alumne alumneId, Date data, String modalitat, String descompte, Import importId) {
        this.id = id;
        this.alumneId = alumneId;
        this.data = data;
        this.modalitat = modalitat;
        this.descompte = descompte;
        this.importId = importId;
    }

    public Matricula(Alumne alumneId, Date data, String modalitat, String descompte, Import importId) {
        this.alumneId = alumneId;
        this.data = data;
        this.modalitat = modalitat;
        this.descompte = descompte;
        this.importId = importId;
    }    
    
    public Matricula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumne getAlumneId() {
        return alumneId;
    }

    public void setAlumneId(Alumne alumneId) {
        this.alumneId = alumneId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Import getImportId() {
        return importId;
    }

    public void setImportId(Import importId) {
        this.importId = importId;
    }

    public List<UnitatFormativa> getListaUF() {
        return listaUF;
    }

    public void setListaUF(List<UnitatFormativa> listaUF) {
        this.listaUF = listaUF;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
