
import control.Alumne_Controller;
import control.Cicle_Controller;
import control.Curs_Controller;
import control.Familia_Controller;
import control.Import_Controller;
import control.Matricula_Controller;
import control.Modul_Controller;
import control.UF_Controller;
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
        Alumne_Controller ac = new Alumne_Controller();
        Cicle_Controller cc = new Cicle_Controller();
        Curs_Controller cuc = new Curs_Controller();
        Familia_Controller fc = new Familia_Controller();
        Matricula_Controller mc = new Matricula_Controller();
        Modul_Controller moc = new Modul_Controller();
        UF_Controller uc = new UF_Controller();
        Import_Controller ic = new Import_Controller();
        
        Alumne al1 = new Alumne(0L, "Eric", "Dote", "f4fref", 0, null);
        FamiliaCicles fa1 = new FamiliaCicles(0L, "Informatica");
        Cicle ci1 = new Cicle(0L, "DAM", "Superior", fa1);
        Curs cu1 = new Curs(0L, "Segon", ci1);
        Modul mo1 = new Modul(0L, "M6", ci1);
        UnitatFormativa uf1 = new UnitatFormativa(0L, "UF1", 20, cu1, mo1);
        date =  (Date) df.parse("21/04/2017");
        Import im1 = new Import(0L, 0, null);
        Matricula ma1 = new Matricula(0L, al1, date, "COMPLET", "TOTAL", im1);
        ac.Insertar(al1); 
        fc.Insertar(fa1);
        cc.Insertar(ci1);
        cuc.Insertar(cu1);
        moc.Insertar(mo1);
        uc.Insertar(uf1);
        ic.Insertar(im1);
        mc.Insertar(ma1);
        
    }
    
}
