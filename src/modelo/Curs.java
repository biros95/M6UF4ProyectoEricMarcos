/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import utilitats.NumeroDeCurs;

/**
 *
 * @author Eric
 */
public class Curs {
    private int id;
    private NumeroDeCurs numeroDeCurs;

    public Curs(int id, NumeroDeCurs numeroDeCurs) {
        this.id = id;
        this.numeroDeCurs = numeroDeCurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NumeroDeCurs getNumeroDeCurs() {
        return numeroDeCurs;
    }

    public void setNumeroDeCurs(NumeroDeCurs numeroDeCurs) {
        this.numeroDeCurs = numeroDeCurs;
    }
}
