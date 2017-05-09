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
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import utilitats.Descompte;
import utilitats.Modalitat;

/**
 *
 * @author Eric
 */
@Entity
@NamedQueries({
@NamedQuery(name="nifMatricula", query="SELECT p FROM Matricula p WHERE p.alumneId.nif=:nif")})
@Table(name = "Matricula")
public class Matricula implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matriculaId", unique = true, nullable = false)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "alumneId")
    private Alumne alumneId;

    private Date data;

    @Column(name = "modalitat")
    private Modalitat modalitat;

    @Column(name = "descompte")
    private Descompte descompte;
    
    @Embedded
    private Import importe;
    
    @ManyToMany(mappedBy = "listaMatriculas", cascade = CascadeType.ALL)
    private Set<UnitatFormativa> listaUF;

    public Matricula() {
    }

    public Matricula(Alumne alumneId, Date data, Modalitat modalitat, Descompte descompte, Import importe) {
        this.alumneId = alumneId;
        this.data = data;
        this.modalitat = modalitat;
        this.descompte = descompte;
        this.importe = importe;
       
    }

    public Matricula(Long id, Alumne alumneId, Date data, Modalitat modalitat, Descompte descompte, Import importe) {
        this.id = id;
        this.alumneId = alumneId;
        this.data = data;
        this.modalitat = modalitat;
        this.descompte = descompte;
        this.importe = importe;
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

    public Modalitat getModalitat() {
        return modalitat;
    }

    public void setModalitat(Modalitat modalitat) {
        this.modalitat = modalitat;
    }

    public Descompte getDescompte() {
        return descompte;
    }

    public void setDescompte(Descompte descompte) {
        this.descompte = descompte;
    }

    public Import getImporte() {
        return importe;
    }

    public void setImporte(Import importe) {
        this.importe = importe;
    }

    public Set<UnitatFormativa> getListaUF() {
        return listaUF;
    }

    public void setListaUF(Set<UnitatFormativa> listaUF) {
        this.listaUF = listaUF;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
