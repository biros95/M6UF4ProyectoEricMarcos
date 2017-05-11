/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase Importe
 *
 * @author Eric & Marcos
 */
@Embeddable
@Table(name = "Import")
public class Import implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "import", nullable = false)
    private double importe;

    public Import() {
    }

    public Import(double importe) {
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
