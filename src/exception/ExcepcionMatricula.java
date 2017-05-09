/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import javax.swing.JOptionPane;

/**
 *
 * @author MarcosPortatil
 */
public class ExcepcionMatricula extends Exception{
    String mensaje;
    public ExcepcionMatricula() {
    }

    public ExcepcionMatricula(String message) {
            super(message);
      mensaje  = message.equals("NIF") ? "No s'ha trobat cap alumne amb aquest NIF": (message.equals("COG")) ?
              "No s'ha trobat cap alumne amb aquest cognom": "No s'han trobat alumnes";
        
     JOptionPane.showMessageDialog(null, mensaje);
    }
    
}
