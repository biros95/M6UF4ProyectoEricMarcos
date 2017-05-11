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
public class ExcepcionGenerica extends Exception {
 String mensaje;
 /**
  * Creado
  * @param message 
  */
    public ExcepcionGenerica(String message, String clase) {
        super(message);
      mensaje  = "No s'ha trobat cap "+clase+" amb aquest ID";
        
     JOptionPane.showMessageDialog(null, mensaje);
    }

     public ExcepcionGenerica(String message) {
        super(message);
      mensaje  = (message.equals("COG")) ? "No s'ha trobat cap alumne amb aquest cognom": "No se han trobat resultats";
        
     JOptionPane.showMessageDialog(null, mensaje);
    }
    public ExcepcionGenerica() {
    }
    
}
