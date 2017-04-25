
import control.Generic_Controller;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.Alumne;
import modelo.Cicle;
import modelo.Curs;
import modelo.FamiliaCicles;
import modelo.Import;
import modelo.Matricula;
import modelo.Modul;
import modelo.UnitatFormativa;

/**
 *
 * @author Eric
 */
public class MainClass {


    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        Generic_Controller gc = new Generic_Controller();
        
        Alumne al1 = new Alumne("54545454X", "Eric", "Dote", "f4fref", 0, null);
        FamiliaCicles fa1 = new FamiliaCicles(0L, "Informatica");
        Cicle ci1 = new Cicle(0L, "DAM", "Superior", fa1);
        Curs cu1 = new Curs(0L, "Segon", ci1);
        Modul mo1 = new Modul(0L, "M6", ci1);
        UnitatFormativa uf1 = new UnitatFormativa(0L, "UF1", 20, cu1, mo1);
        date =  (Date) df.parse("21/04/2017");
        Import im1 = new Import(0L, 0, null);
        Matricula ma1 = new Matricula(0L, al1, date, "COMPLET", "TOTAL", im1);
        gc.Insertar(al1); 
        gc.Insertar(fa1);
        gc.Insertar(ci1);
        gc.Insertar(cu1);
        gc.Insertar(mo1);
        gc.Insertar(uf1);
        gc.Insertar(im1);
        gc.Insertar(ma1);
        
    }
    
}
