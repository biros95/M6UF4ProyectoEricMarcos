package exception;

import javax.swing.JOptionPane;

/**
 *
 * @author Eric & Marcos
 */
public class ExcepcionGenerica extends Exception {

    String mensaje;

    /**
     * Constructor para las excepciones donde le llega el mensaje i la clase para
     * calificar la excepcion por clase. 
     * Esta excepcion es por ID.
     * @param message
     * @param clase
     */
    public ExcepcionGenerica(String message, String clase) {
        super(message);
        mensaje = "No s'ha trobat cap " + clase + " amb aquest ID";

        JOptionPane.showMessageDialog(null, mensaje);
    }
    /**
     * Constructor que le llega un mensaje por parametro por si no se encuentra ningun objeto de X clase.
     * @param message 
     */
    public ExcepcionGenerica(String message) {
        super(message);
        mensaje = (message.equals("COG")) ? "No s'ha trobat cap alumne amb aquest cognom" : "No se han trobat resultats";

        JOptionPane.showMessageDialog(null, mensaje);
    }
    /**
     * Constructor de sobrecarga.
     */
    public ExcepcionGenerica() {
    }

}
