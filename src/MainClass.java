
import control.Alumne_Controller;
import control.Cicle_Controller;
import control.Curs_Controller;
import control.Familia_Controller;
import control.Matricula_Controller;
import control.Modul_Controller;
import control.UF_Controller;
import modelo.Alumne;

/**
 *
 * @author Eric
 */
public class MainClass {


    public static void main(String[] args) {
        Alumne_Controller ac = new Alumne_Controller();
        Cicle_Controller cc = new Cicle_Controller();
        Curs_Controller cuc = new Curs_Controller();
        Familia_Controller fc = new Familia_Controller();
        Matricula_Controller mc = new Matricula_Controller();
        Modul_Controller moc = new Modul_Controller();
        UF_Controller uc = new UF_Controller();
        
        Alumne al1 = new Alumne(0L, "Eric", "Dote", "f4fref", 0, null);
        
        ac.Insertar(al1);
    }
    
}
