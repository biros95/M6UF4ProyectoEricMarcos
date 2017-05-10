/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import javax.swing.JOptionPane;

/**
 *
 * @author Eric
 */
public class ExcepcionAlumne extends Exception {
 String mensaje;
 /**
  * Creado
  * @param message 
  */
    public ExcepcionAlumne(String message) {
        super(message);
      mensaje  = message.equals("NIF") ? "No s'ha trobat cap alumne amb aquest NIF": (message.equals("COG")) ?
              "No s'ha trobat cap alumne amb aquest cognom": "No s'han trobat alumnes";
        
     JOptionPane.showMessageDialog(null, mensaje);
    }

    public ExcepcionAlumne() {
    }
    
}
