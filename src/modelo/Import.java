/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table(name = "Import")
public class Import implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "importId", unique = true, nullable = false)
    private int matricula;

    @Column(name = "import", nullable = false)
    private double importe;

    public Import(int matricula, double importe) {
        this.matricula = matricula;
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.matricula;
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
        final Import other = (Import) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Import{" + "matricula=" + matricula + ", importe=" + importe + '}';
    }

    

}
