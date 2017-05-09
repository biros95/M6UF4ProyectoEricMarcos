/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Alumne_Controller;
import control.Cicle_Controller;
import control.Curs_Controller;
import control.EM_Controller;
import control.Familia_Controller;
import control.Generic_Controller;
import control.Matricula_Controller;
import control.Modul_Controller;
import exception.ExcepcionAlumne;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javafx.scene.control.RadioButton;
import javax.persistence.EntityManager;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumne;
import modelo.Cicle;
import modelo.Curs;
import modelo.FamiliaCicles;
import modelo.Import;
import modelo.Matricula;
import modelo.Modul;
import modelo.UnitatFormativa;
import utilitats.Descompte;
import utilitats.Modalitat;
import utilitats.NombreDeCurs;

/**
 *
 * @author Eric
 */
public class Vista extends javax.swing.JFrame {

    Alumne al;
    Cicle ci;
    FamiliaCicles fc;
    Modul mo;
    Curs cr;
    UnitatFormativa uf;
    Alumne_Controller ac;
    Generic_Controller gc;
    Familia_Controller fco;
    Curs_Controller cc;
    Cicle_Controller cic;
    Modul_Controller mc;
    NombreDeCurs ndc;
    Matricula matricula;
    Matricula_Controller mac;

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        BuidarCamps();
        BuidarTaula();
        EntityManager em = EM_Controller.getEntityManager();
        gc = new Generic_Controller(em);
        fco = new Familia_Controller(em);
        ac = new Alumne_Controller(em);
        cic = new Cicle_Controller(em);
        cc = new Curs_Controller(em);
        mc = new Modul_Controller(em);
        mac = new Matricula_Controller(em);
    }

    public void BuidarCamps() {
        //Vaciar campos de texto.

        //Alumno
        tfNif.setText("");
        tfNomAl.setText("");
        tfCognomAl.setText("");
        tfCorreuAl.setText("");
        tfTlfAl.setText("");
        tfCercaAl.setText("");

        //Familia
        tfIdFamilia.setText("");
        tfIdFamiCicle.setText("");
        tfNomFamilia.setText("");
        tfCercaIDFC.setText("");

        //Ciclos
        tfNomCicle.setText("");
        tfIdCicle.setText("");
        tfGrauCicle.setText("");
        tfCercaCicle.setText("");

        //Curso
        tfIdCurs.setText("");
        tfIdCicleCurs.setText("");
        tfCercaCurs.setText("");

        //Modul
        tfIdModul.setText("");
        tfNomModul.setText("");
        tfIdCursModul.setText("");
        tfIdModulCicle.setText("");
        tfIdModulCerca.setText("");

        //UF
        tfIdUF.setText("");
        tfNomUF.setText("");
        tfHoresUF.setText("");
        tfIdCursUF.setText("");
        tfIdModulUF.setText("");
        tfCercaIDUF.setText("");

        //Matricula
        //Desactivar botones
        btnEliminarAl.setEnabled(false);
        btnModiAl.setEnabled(false);
        btnEliminarFamilia.setEnabled(false);
        btnModificarFamilia.setEnabled(false);
        btnModiCicle.setEnabled(false);
        btnEliminarCicle.setEnabled(false);
        tfNif.setEnabled(true);
        btnEliminarCurs.setEnabled(false);
        btnModiCurs.setEnabled(false);
        rbPrimer.setSelected(true);
        btnEliminarModul.setEnabled(false);
        btnModificarModul.setEnabled(false);
        btnModiUF.setEnabled(false);
        btnEliUF.setEnabled(false);
    }

    public void BuidarTaula() {
        String col[] = {"NIF", "NOM", "COGNOMS", "CORREU", "TELEFON"};
        DefaultTableModel taulaAlumnes = new DefaultTableModel(col, 0);
        tablaTotsAl.setModel(taulaAlumnes);
        String col2[] = {"ID", "NOM"};
        DefaultTableModel taulaFamilia = new DefaultTableModel(col2, 0);
        tablaTodasFamilias.setModel(taulaFamilia);
        String col3[] = {"ID", "NOM", "GRAU"};
        DefaultTableModel taulaCiclesFamilia = new DefaultTableModel(col3, 0);
        tablaCicles.setModel(taulaCiclesFamilia);
        String col4[] = {"ID", "NOM"};
        DefaultTableModel taulaModuls = new DefaultTableModel(col4, 0);
        tableListaModuls.setModel(taulaModuls);
        String col5[] = {"ID", "NOM"};
        DefaultTableModel taulaCurs = new DefaultTableModel(col5, 0);
        tableCursos.setModel(taulaCurs);
        String col6[] = {"ID", "NOM", "GRAU", "IDFAMILIA"};
        DefaultTableModel taulaCicles = new DefaultTableModel(col6, 0);
        tablaTotsCicles.setModel(taulaCicles);
        String col7[] = {"ID", "NOM"};
        DefaultTableModel taulaModulsCicle = new DefaultTableModel(col7, 0);
        taulaModulCurs.setModel(taulaModulsCicle);
        String col8[] = {"ID", "NOM"};
        DefaultTableModel taulaUFCurs = new DefaultTableModel(col8, 0);
        taulaUfCurs.setModel(taulaUFCurs);
        String col9[] = {"ID", "NOM", "CICLEID"};
        DefaultTableModel taulaCursos = new DefaultTableModel(col9, 0);
        taulaTotsCursos.setModel(taulaCursos);
        String col10[] = {"ID", "NOM", "HORES"};
        DefaultTableModel taulaUFModul = new DefaultTableModel(col10, 0);
        taulaModulUF.setModel(taulaUFModul);
        String col11[] = {"ID", "NOM", "CURSID", "CICLEID"};
        DefaultTableModel taulaModul = new DefaultTableModel(col11, 0);
        tableTotsModuls.setModel(taulaModul);
        String col12[] = {"ID", "NOM", "HORES", "IDCURS", "IDMODUL"};
        DefaultTableModel taulaUF = new DefaultTableModel(col12, 0);
        tablaTotesUF.setModel(taulaUF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        menuBar4 = new java.awt.MenuBar();
        menu7 = new java.awt.Menu();
        menu8 = new java.awt.Menu();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        grupNomCurs = new javax.swing.ButtonGroup();
        bgDescompte = new javax.swing.ButtonGroup();
        bgModalitat = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNif = new javax.swing.JTextField();
        tfNomAl = new javax.swing.JTextField();
        tfCognomAl = new javax.swing.JTextField();
        tfCorreuAl = new javax.swing.JTextField();
        tfTlfAl = new javax.swing.JTextField();
        btnCrearAlumn = new javax.swing.JButton();
        btnModiAl = new javax.swing.JButton();
        btnEliminarAl = new javax.swing.JButton();
        btnClearAl = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        rbIdAl = new javax.swing.JRadioButton();
        rbCogAl = new javax.swing.JRadioButton();
        tfCercaAl = new javax.swing.JTextField();
        btnCercaAl = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTotsAl = new javax.swing.JTable();
        btnCercaTotsAl = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfIdFamilia = new javax.swing.JTextField();
        btnCrearFamilia = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfNomFamilia = new javax.swing.JTextField();
        btnModificarFamilia = new javax.swing.JButton();
        btnEliminarFamilia = new javax.swing.JButton();
        btnClearFamilia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTodasFamilias = new javax.swing.JTable();
        tfCercaIDFC = new javax.swing.JTextField();
        btnCercarFamilia = new javax.swing.JButton();
        btnTotsFC = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCicles = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfIdCicle = new javax.swing.JTextField();
        tfNomCicle = new javax.swing.JTextField();
        tfGrauCicle = new javax.swing.JTextField();
        tfIdFamiCicle = new javax.swing.JTextField();
        btnCrearCicle = new javax.swing.JButton();
        btnModiCicle = new javax.swing.JButton();
        btnEliminarCicle = new javax.swing.JButton();
        btnClearCicle = new javax.swing.JButton();
        tfCercaCicle = new javax.swing.JTextField();
        btnCercaCicle = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableListaModuls = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableCursos = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaTotsCicles = new javax.swing.JTable();
        btnCercaTotsCicles = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfIdCurs = new javax.swing.JTextField();
        tfIdCicleCurs = new javax.swing.JTextField();
        btnLimpiCurs = new javax.swing.JButton();
        btnEliminarCurs = new javax.swing.JButton();
        btnModiCurs = new javax.swing.JButton();
        btnCrearCurs = new javax.swing.JButton();
        btnCercaCurs = new javax.swing.JButton();
        tfCercaCurs = new javax.swing.JTextField();
        rbPrimer = new javax.swing.JRadioButton();
        rbSegon = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        taulaUfCurs = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        taulaTotsCursos = new javax.swing.JTable();
        btnCercaTotsCursos = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        taulaModulCurs = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        tfIdModul = new javax.swing.JTextField();
        tfIdModulCicle = new javax.swing.JTextField();
        tfNomModul = new javax.swing.JTextField();
        tfIdCursModul = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnCrearModul = new javax.swing.JButton();
        btnModificarModul = new javax.swing.JButton();
        btnEliminarModul = new javax.swing.JButton();
        btnNetejaModul = new javax.swing.JButton();
        btnCercaModul = new javax.swing.JButton();
        tfIdModulCerca = new javax.swing.JTextField();
        tableUFModul = new javax.swing.JScrollPane();
        taulaModulUF = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableTotsModuls = new javax.swing.JTable();
        btnCercaTotsModuls = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        tfIdCursUF = new javax.swing.JTextField();
        tfHoresUF = new javax.swing.JTextField();
        tfNomUF = new javax.swing.JTextField();
        tfIdUF = new javax.swing.JTextField();
        btnCreaUF = new javax.swing.JButton();
        btnModiUF = new javax.swing.JButton();
        btnEliUF = new javax.swing.JButton();
        btnNetejaUF = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        tfIdModulUF = new javax.swing.JTextField();
        btnCercaIDUF = new javax.swing.JButton();
        tfCercaIDUF = new javax.swing.JTextField();
        tableTotesUF = new javax.swing.JScrollPane();
        tablaTotesUF = new javax.swing.JTable();
        btnCercaTotesUF = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        tfIdMatricula = new javax.swing.JTextField();
        tfIdAlumneMatricula = new javax.swing.JTextField();
        rbComplet = new javax.swing.JRadioButton();
        rbSoltes = new javax.swing.JRadioButton();
        rbCap = new javax.swing.JRadioButton();
        rbMig = new javax.swing.JRadioButton();
        rbTotal = new javax.swing.JRadioButton();
        tfImport = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnCrearMatricula = new javax.swing.JButton();
        btnModificarMatricula = new javax.swing.JButton();
        btnEliminarMatricula = new javax.swing.JButton();
        btnNetejarMatricula = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        tfCercaNifMatricula = new javax.swing.JTextField();
        btnCercaNifMatricula = new javax.swing.JButton();
        btnRefrescaUF = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        listaUFs = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tfUFNOM = new javax.swing.JTextField();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        menu7.setLabel("File");
        menuBar4.add(menu7);

        menu8.setLabel("Edit");
        menuBar4.add(menu8);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("NIF");

        jLabel3.setText("Nom");

        jLabel4.setText("Cognom");

        jLabel5.setText("Correu");

        jLabel6.setText("Telefon");

        btnCrearAlumn.setText("Crear");
        btnCrearAlumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlumnActionPerformed(evt);
            }
        });

        btnModiAl.setText("Modificar");
        btnModiAl.setEnabled(false);
        btnModiAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiAlActionPerformed(evt);
            }
        });

        btnEliminarAl.setText("Eliminar");
        btnEliminarAl.setEnabled(false);
        btnEliminarAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlActionPerformed(evt);
            }
        });

        btnClearAl.setText("Neteja");
        btnClearAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAlActionPerformed(evt);
            }
        });

        jLabel37.setText("Selecciona com vols cercar:");

        buttonGroup1.add(rbIdAl);
        rbIdAl.setSelected(true);
        rbIdAl.setText("NIF");

        buttonGroup1.add(rbCogAl);
        rbCogAl.setText("Cognom");
        rbCogAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCogAlActionPerformed(evt);
            }
        });

        btnCercaAl.setText("Cerca");
        btnCercaAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaAlActionPerformed(evt);
            }
        });

        tablaTotsAl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaTotsAl);

        btnCercaTotsAl.setText("Cerca Tots");
        btnCercaTotsAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaTotsAlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbCogAl)
                            .addComponent(rbIdAl)
                            .addComponent(jLabel37)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNomAl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCorreuAl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTlfAl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModiAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClearAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfCognomAl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfNif, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrearAlumn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfCercaAl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCercaAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCercaTotsAl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearAlumn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNomAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModiAl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfCognomAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarAl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCorreuAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearAl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfTlfAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbIdAl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCogAl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCercaAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCercaAl)
                    .addComponent(btnCercaTotsAl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alumne", jPanel1);

        jLabel7.setText("Id");

        tfIdFamilia.setEditable(false);

        btnCrearFamilia.setText("Crear");
        btnCrearFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFamiliaActionPerformed(evt);
            }
        });

        jLabel8.setText("Nom");

        btnModificarFamilia.setText("Modificar");
        btnModificarFamilia.setEnabled(false);
        btnModificarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFamiliaActionPerformed(evt);
            }
        });

        btnEliminarFamilia.setText("Eliminar");
        btnEliminarFamilia.setEnabled(false);
        btnEliminarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFamiliaActionPerformed(evt);
            }
        });

        btnClearFamilia.setText("Neteja");
        btnClearFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFamiliaActionPerformed(evt);
            }
        });

        tablaTodasFamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaTodasFamilias);

        btnCercarFamilia.setText("Cercar per ID");
        btnCercarFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercarFamiliaActionPerformed(evt);
            }
        });

        btnTotsFC.setText("Cerca totes les families");
        btnTotsFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotsFCActionPerformed(evt);
            }
        });

        tablaCicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaCicles);

        jLabel17.setText("Cicles de la Familia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTotsFC)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfIdFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrearFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNomFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(tfCercaIDFC))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminarFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificarFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnClearFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCercarFamilia))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfIdFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearFamilia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfNomFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarFamilia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarFamilia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearFamilia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCercarFamilia)
                            .addComponent(tfCercaIDFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)))
                .addComponent(btnTotsFC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Familia Cicles", jPanel3);

        jLabel9.setText("ID");

        jLabel10.setText("Nom Cicle");

        jLabel11.setText("Grau Cicle");

        jLabel12.setText("Id Familia");

        tfIdCicle.setEditable(false);

        btnCrearCicle.setText("Crear");
        btnCrearCicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCicleActionPerformed(evt);
            }
        });

        btnModiCicle.setText("Modificar");
        btnModiCicle.setEnabled(false);
        btnModiCicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiCicleActionPerformed(evt);
            }
        });

        btnEliminarCicle.setText("Eliminar");
        btnEliminarCicle.setEnabled(false);
        btnEliminarCicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCicleActionPerformed(evt);
            }
        });

        btnClearCicle.setText("Neteja");
        btnClearCicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCicleActionPerformed(evt);
            }
        });

        btnCercaCicle.setText("Cerca");
        btnCercaCicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaCicleActionPerformed(evt);
            }
        });

        jLabel13.setText("Cerca per ID");

        tableListaModuls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableListaModuls);

        tableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableCursos);

        jLabel21.setText("Lista de moduls");

        jLabel22.setText("Lista de cursos");

        tablaTotsCicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablaTotsCicles);

        btnCercaTotsCicles.setText("Tots els cicles");
        btnCercaTotsCicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaTotsCiclesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                            .addComponent(jLabel11)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(tfIdCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnCrearCicle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(tfNomCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnModiCicle))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfGrauCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfIdFamiCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnEliminarCicle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnClearCicle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfCercaCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCercaCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane6)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCercaTotsCicles)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfIdCicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearCicle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfNomCicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModiCicle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfGrauCicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCicle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfIdFamiCicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClearCicle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCercaCicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCercaCicle)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(btnCercaTotsCicles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cicles", jPanel5);

        jLabel14.setText("Id");

        jLabel15.setText("Nom");

        jLabel16.setText("Id Cicle");

        tfIdCurs.setEditable(false);

        btnLimpiCurs.setText("Neteja");
        btnLimpiCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiCursActionPerformed(evt);
            }
        });

        btnEliminarCurs.setText("Eliminar");
        btnEliminarCurs.setEnabled(false);
        btnEliminarCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursActionPerformed(evt);
            }
        });

        btnModiCurs.setText("Modificar");
        btnModiCurs.setEnabled(false);
        btnModiCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiCursActionPerformed(evt);
            }
        });

        btnCrearCurs.setText("Crear");
        btnCrearCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCursActionPerformed(evt);
            }
        });

        btnCercaCurs.setText("Cerca Per ID");
        btnCercaCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaCursActionPerformed(evt);
            }
        });

        grupNomCurs.add(rbPrimer);
        rbPrimer.setSelected(true);
        rbPrimer.setText("1r");

        grupNomCurs.add(rbSegon);
        rbSegon.setText("2n");

        taulaUfCurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(taulaUfCurs);

        jLabel23.setText("UF del curs");

        taulaTotsCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(taulaTotsCursos);

        btnCercaTotsCursos.setText("Cerca tots els cursos");
        btnCercaTotsCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaTotsCursosActionPerformed(evt);
            }
        });

        taulaModulCurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(taulaModulCurs);

        jLabel24.setText("Modul del curs");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(tfIdCicleCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(tfIdCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCrearCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfCercaCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(rbPrimer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbSegon)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCercaCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnLimpiCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnModiCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnCercaTotsCursos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfIdCurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearCurs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(btnModiCurs)
                    .addComponent(rbPrimer)
                    .addComponent(rbSegon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfIdCicleCurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCurs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiCurs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCercaCurs)
                    .addComponent(tfCercaCurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCercaTotsCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Curs", jPanel6);

        tfIdModul.setEditable(false);

        jLabel25.setText("ID");

        jLabel26.setText("Nom");

        jLabel27.setText("ID Curs");

        jLabel28.setText("ID Cicle");

        btnCrearModul.setText("Crear");
        btnCrearModul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearModulActionPerformed(evt);
            }
        });

        btnModificarModul.setText("Modificar");
        btnModificarModul.setEnabled(false);
        btnModificarModul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarModulActionPerformed(evt);
            }
        });

        btnEliminarModul.setText("Eliminar");
        btnEliminarModul.setEnabled(false);
        btnEliminarModul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarModulActionPerformed(evt);
            }
        });

        btnNetejaModul.setText("Netejar");
        btnNetejaModul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetejaModulActionPerformed(evt);
            }
        });

        btnCercaModul.setText("Cerca per ID");
        btnCercaModul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaModulActionPerformed(evt);
            }
        });

        taulaModulUF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableUFModul.setViewportView(taulaModulUF);

        jLabel18.setText("UF del Modul");

        tableTotsModuls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tableTotsModuls);

        btnCercaTotsModuls.setText("Cerca tots els Moduls");
        btnCercaTotsModuls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaTotsModulsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(tfIdCursModul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarModul, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(tfIdModul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCrearModul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfIdModulCicle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfIdModulCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnCercaModul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnNetejaModul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(tfNomModul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificarModul, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(tableUFModul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCercaTotsModuls)))
                        .addGap(0, 162, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdModul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(btnCrearModul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNomModul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(btnModificarModul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdCursModul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(btnEliminarModul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdModulCicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(btnNetejaModul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCercaModul)
                            .addComponent(tfIdModulCerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tableUFModul, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(btnCercaTotsModuls)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mòdul", jPanel7);

        jLabel32.setText("ID");

        jLabel33.setText("Nom");

        jLabel34.setText("Hores");

        jLabel35.setText("Id Curs");

        tfIdUF.setEditable(false);

        btnCreaUF.setText("Crear");
        btnCreaUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaUFActionPerformed(evt);
            }
        });

        btnModiUF.setText("Modificar");
        btnModiUF.setEnabled(false);
        btnModiUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiUFActionPerformed(evt);
            }
        });

        btnEliUF.setText("Eliminar");
        btnEliUF.setEnabled(false);
        btnEliUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliUFActionPerformed(evt);
            }
        });

        btnNetejaUF.setText("Neteja");
        btnNetejaUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetejaUFActionPerformed(evt);
            }
        });

        jLabel36.setText("Id Modul");

        tfIdModulUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdModulUFActionPerformed(evt);
            }
        });

        btnCercaIDUF.setText("Cerca per ID");
        btnCercaIDUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaIDUFActionPerformed(evt);
            }
        });

        tablaTotesUF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTotesUF.setViewportView(tablaTotesUF);

        btnCercaTotesUF.setText("Cerca totes les UF");
        btnCercaTotesUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaTotesUFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfHoresUF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfCercaIDUF)
                                        .addComponent(tfIdModulUF)
                                        .addComponent(tfIdCursUF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfNomUF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfIdUF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCercaIDUF)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnNetejaUF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliUF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCreaUF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnModiUF, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCercaTotesUF)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableTotesUF, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreaUF)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModiUF)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHoresUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliUF)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdCursUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNetejaUF)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdModulUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCercaIDUF)
                    .addComponent(tfCercaIDUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(btnCercaTotesUF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableTotesUF, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Unitat Formativa", jPanel8);

        tfIdMatricula.setEditable(false);

        bgModalitat.add(rbComplet);
        rbComplet.setSelected(true);
        rbComplet.setText("Curs Complet");
        rbComplet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        bgModalitat.add(rbSoltes);
        rbSoltes.setText("UF Soltes");
        rbSoltes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        bgDescompte.add(rbCap);
        rbCap.setSelected(true);
        rbCap.setText("0%");

        bgDescompte.add(rbMig);
        rbMig.setText("50%");

        bgDescompte.add(rbTotal);
        rbTotal.setText("100%");

        jLabel19.setText("ID");

        jLabel20.setText("Alumne ID");

        jLabel29.setText("Modalitat");

        jLabel30.setText("Descompte");

        jLabel31.setText("Import");

        btnCrearMatricula.setText("Crear");
        btnCrearMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMatriculaActionPerformed(evt);
            }
        });

        btnModificarMatricula.setText("Modificar");
        btnModificarMatricula.setEnabled(false);

        btnEliminarMatricula.setText("Eliminar");
        btnEliminarMatricula.setEnabled(false);

        btnNetejarMatricula.setText("Netejar");

        jLabel38.setText("UF de la matricula");

        btnCercaNifMatricula.setText("Cerca per NIF");
        btnCercaNifMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCercaNifMatriculaActionPerformed(evt);
            }
        });

        btnRefrescaUF.setText("Refresca UF's");
        btnRefrescaUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescaUFActionPerformed(evt);
            }
        });

        listaUFs.setToolTipText("");
        jScrollPane12.setViewportView(listaUFs);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(jTable1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbComplet)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(rbCap)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbMig)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSoltes)
                                    .addComponent(rbTotal))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnCercaNifMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNetejarMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfCercaNifMatricula, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfImport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIdMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfIdAlumneMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(btnModificarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnCrearMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRefrescaUF)
                            .addComponent(jLabel38)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUFNOM, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(btnCrearMatricula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdAlumneMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(btnModificarMatricula))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSoltes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbComplet)
                                        .addComponent(jLabel29)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbCap)
                                    .addComponent(rbMig)
                                    .addComponent(rbTotal)
                                    .addComponent(jLabel30))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnEliminarMatricula)
                                .addGap(8, 8, 8)
                                .addComponent(btnNetejarMatricula)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCercaNifMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCercaNifMatricula)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefrescaUF)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(tfUFNOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Matrícula", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearAlumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlumnActionPerformed
        gc.conectar();
        al = new Alumne(tfNif.getText(), tfNomAl.getText(), tfCognomAl.getText(), tfCorreuAl.getText(), Integer.parseInt(tfTlfAl.getText()));
        gc.Insertar(al);
        gc.desconectar();
    }//GEN-LAST:event_btnCrearAlumnActionPerformed

    private void btnCrearFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFamiliaActionPerformed
        gc.conectar();
        fc = new FamiliaCicles(tfNomFamilia.getText());
        gc.Insertar(fc);
        gc.desconectar();
    }//GEN-LAST:event_btnCrearFamiliaActionPerformed

    private void btnCrearCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCursActionPerformed
        gc.conectar();
        ci = (Cicle) gc.Buscar(Long.parseLong(tfIdCicleCurs.getText()), Cicle.class);
        if (rbPrimer.isSelected()) {
            cr = new Curs(NombreDeCurs.PRIMER, ci);
        } else {
            cr = new Curs(NombreDeCurs.SEGON, ci);
        }
        gc.Insertar(cr);
        gc.desconectar();
    }//GEN-LAST:event_btnCrearCursActionPerformed

    private void btnCercaCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaCursActionPerformed
        gc.conectar();
        cr = (Curs) gc.Buscar(Long.parseLong(tfCercaCurs.getText()), Curs.class);
        tfIdCurs.setText(String.valueOf(cr.getId()));
        if (cr.getNombreDeCurs() == NombreDeCurs.PRIMER) {
            rbPrimer.setSelected(true);
        } else {
            rbSegon.setSelected(true);
        }
        tfIdCicleCurs.setText(String.valueOf(cr.getCicle().getId()));
        List<Modul> listaModul = cc.BuscarModulsCurs(cr.getId());
        String col[] = {"ID", "NOM"};
        DefaultTableModel taulaModulsCicle = new DefaultTableModel(col, 0);
        taulaModulCurs.setModel(taulaModulsCicle);
        for (Modul mo : listaModul) {
            taulaModulsCicle.addRow(new Object[]{mo.getId(), mo.getNom()});
        }
        List<UnitatFormativa> listaUF = cc.BuscarUFCurs(cr.getId());
        String col2[] = {"ID", "NOM"};
        DefaultTableModel taulaUFCurs = new DefaultTableModel(col2, 0);
        taulaUfCurs.setModel(taulaUFCurs);
        for (UnitatFormativa uf : listaUF) {
            taulaUFCurs.addRow(new Object[]{uf.getId(), uf.getNom()});
        }
        gc.desconectar();
        btnModiCurs.setEnabled(true);
        btnEliminarCurs.setEnabled(true);
    }//GEN-LAST:event_btnCercaCursActionPerformed

    private void btnCercaAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaAlActionPerformed

        try {
            gc.conectar();
            if (rbIdAl.isSelected()) {
                al = (Alumne) gc.Buscar(tfCercaAl.getText(), Alumne.class);
                if (al == null) {
                    throw new ExcepcionAlumne("NIF");
                }
                tfNomAl.setText(al.getNom());
                tfNif.setText(al.getNif());
                tfCognomAl.setText(al.getCognom());
                tfCorreuAl.setText(al.getCorreu());
                tfTlfAl.setText(String.valueOf(al.getTelefon()));
                btnEliminarAl.setEnabled(true);
                btnModiAl.setEnabled(true);
            } else if (rbCogAl.isSelected()) {

                al = (Alumne) ac.BuscarPerCognom(tfCercaAl.getText());
                tfNomAl.setText(al.getNom());
                tfNif.setText(al.getNif());
                tfCognomAl.setText(al.getCognom());
                tfCorreuAl.setText(al.getCorreu());
                tfTlfAl.setText(String.valueOf(al.getTelefon()));
                btnEliminarAl.setEnabled(true);
                btnModiAl.setEnabled(true);
            }
            tfNif.setEnabled(false);
            gc.desconectar();
        } catch (ExcepcionAlumne ex) {

        }
    }//GEN-LAST:event_btnCercaAlActionPerformed

    private void btnClearAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAlActionPerformed
        BuidarCamps();
        BuidarTaula();
    }//GEN-LAST:event_btnClearAlActionPerformed

    private void btnEliminarAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlActionPerformed
        gc.conectar();
        gc.Eliminar(gc.Buscar(tfNif.getText(), Alumne.class));
        gc.desconectar();
    }//GEN-LAST:event_btnEliminarAlActionPerformed

    private void btnModiAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiAlActionPerformed
        gc.conectar();
        al = (Alumne) gc.Buscar(tfNif.getText(), Alumne.class);
        al = new Alumne(tfNif.getText(), tfNomAl.getText(), tfCognomAl.getText(), tfCorreuAl.getText(), Integer.parseInt(tfTlfAl.getText()));
        gc.Modificar(al);
        gc.desconectar();
    }//GEN-LAST:event_btnModiAlActionPerformed

    private void btnCercaTotsAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaTotsAlActionPerformed
        try {
            gc.conectar();
            List<Alumne> listaAlumnes = gc.ConsultaTots("Alumne");
            if (listaAlumnes.isEmpty()) {
                throw new ExcepcionAlumne("TOTS");
            }
            String col[] = {"NIF", "NOM", "COGNOMS", "CORREU", "TELEFON"};
            DefaultTableModel taulaAlumnes = new DefaultTableModel(col, 0);
            tablaTotsAl.setModel(taulaAlumnes);
            for (Alumne alumne : listaAlumnes) {
                taulaAlumnes.addRow(new Object[]{alumne.getNif(), alumne.getNom(), alumne.getCognom(), alumne.getCorreu(), alumne.getTelefon()});

                gc.desconectar();
            }
        } catch (ExcepcionAlumne ex) {

        }
    }//GEN-LAST:event_btnCercaTotsAlActionPerformed

    private void btnCercarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercarFamiliaActionPerformed
        gc.conectar();
        fc = (FamiliaCicles) gc.Buscar(Long.parseLong(tfCercaIDFC.getText()), FamiliaCicles.class);
        tfIdFamilia.setText(String.valueOf(fc.getId()));
        tfNomFamilia.setText(fc.getNom());
        List<Cicle> listaCiclesFamilies = fco.BuscarPerFamilia(fc.getId());
        String col[] = {"ID", "NOM", "GRAU"};
        DefaultTableModel taulaCiclesFamilia = new DefaultTableModel(col, 0);
        tablaCicles.setModel(taulaCiclesFamilia);
        for (Cicle ci1 : listaCiclesFamilies) {
            taulaCiclesFamilia.addRow(new Object[]{ci1.getId(), ci1.getNom(), ci1.getGrau()});
        }
        gc.desconectar();
        btnModificarFamilia.setEnabled(true);
        btnEliminarFamilia.setEnabled(true);
    }//GEN-LAST:event_btnCercarFamiliaActionPerformed

    private void btnClearFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFamiliaActionPerformed
        BuidarCamps();
        BuidarTaula();
    }//GEN-LAST:event_btnClearFamiliaActionPerformed

    private void btnEliminarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFamiliaActionPerformed
        gc.conectar();
        gc.Eliminar(gc.Buscar(Long.parseLong(tfCercaIDFC.getText()), FamiliaCicles.class));
        gc.desconectar();
    }//GEN-LAST:event_btnEliminarFamiliaActionPerformed

    private void btnModificarFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFamiliaActionPerformed
        gc.conectar();
        fc = (FamiliaCicles) gc.Buscar(Long.parseLong(tfCercaIDFC.getText()), FamiliaCicles.class);
        fc = new FamiliaCicles(fc.getId(), tfNomFamilia.getText());
        gc.Modificar(fc);
        gc.desconectar();
    }//GEN-LAST:event_btnModificarFamiliaActionPerformed

    private void btnTotsFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotsFCActionPerformed
        gc.conectar();
        List<FamiliaCicles> listaFamilies = gc.ConsultaTots("FamiliaCicles");
        String col[] = {"ID", "NOM"};
        DefaultTableModel taulaFamilias = new DefaultTableModel(col, 0);
        tablaTodasFamilias.setModel(taulaFamilias);
        for (FamiliaCicles fc1 : listaFamilies) {
            taulaFamilias.addRow(new Object[]{fc1.getId(), fc1.getNom()});
        }
        gc.desconectar();
    }//GEN-LAST:event_btnTotsFCActionPerformed

    private void btnLimpiCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiCursActionPerformed
        BuidarCamps();
        BuidarTaula();
    }//GEN-LAST:event_btnLimpiCursActionPerformed

    private void btnCercaTotsCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaTotsCursosActionPerformed
        gc.conectar();
        List<Curs> llistaCurs = gc.ConsultaTots("Curs");
        String col[] = {"ID", "NOM", "CICLEID"};
        DefaultTableModel taulaCursos = new DefaultTableModel(col, 0);
        taulaTotsCursos.setModel(taulaCursos);
        for (Curs fc1 : llistaCurs) {
            taulaCursos.addRow(new Object[]{fc1.getId(), fc1.getNombreDeCurs(), fc1.getCicle().getId()});
        }
        gc.desconectar();
    }//GEN-LAST:event_btnCercaTotsCursosActionPerformed

    private void btnModiCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiCursActionPerformed
        gc.conectar();
        cr = (Curs) gc.Buscar(Long.parseLong(tfIdCurs.getText()), Curs.class);
        cr.setId(cr.getId());
        if (rbPrimer.isSelected()) {
            cr.setNombreDeCurs(NombreDeCurs.PRIMER);
        } else {
            cr.setNombreDeCurs(NombreDeCurs.SEGON);
        }
        cr.setCicle((Cicle) gc.Buscar(Long.parseLong(tfIdCicleCurs.getText()), Cicle.class));
        gc.Modificar(cr);
        gc.desconectar();
    }//GEN-LAST:event_btnModiCursActionPerformed

    private void btnCercaTotsCiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaTotsCiclesActionPerformed
        gc.conectar();
        List<Cicle> listaCicles = gc.ConsultaTots("Cicle");
        String col[] = {"ID", "NOM", "GRAU", "IDFAMILIA"};
        DefaultTableModel taulaCicles = new DefaultTableModel(col, 0);
        tablaTotsCicles.setModel(taulaCicles);
        for (Cicle ci1 : listaCicles) {
            taulaCicles.addRow(new Object[]{ci1.getId(), ci1.getNom(), ci1.getGrau(), ci1.getFamilia().getId()});
        }
        gc.desconectar();
    }//GEN-LAST:event_btnCercaTotsCiclesActionPerformed

    private void btnCercaCicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaCicleActionPerformed
        gc.conectar();
        ci = (Cicle) gc.Buscar(Long.parseLong(tfCercaCicle.getText()), Cicle.class);
        tfIdCicle.setText(String.valueOf(ci.getId()));
        tfNomCicle.setText(ci.getNom());
        tfGrauCicle.setText(ci.getGrau());
        tfIdFamiCicle.setText(String.valueOf(ci.getFamilia().getId()));
        List<Modul> listaModul = cic.BuscarModulsCicle(Long.parseLong(tfIdCicle.getText()));
        String col[] = {"ID", "NOM"};
        DefaultTableModel taulaModuls = new DefaultTableModel(col, 0);
        tableListaModuls.setModel(taulaModuls);
        for (Modul fc1 : listaModul) {
            taulaModuls.addRow(new Object[]{fc1.getId(), fc1.getNom()});
        }
        List<Curs> listaCurs = cic.BuscarCursosCicle(Long.parseLong(tfIdCicle.getText()));
        String col2[] = {"ID", "NOM"};
        DefaultTableModel taulaCurs = new DefaultTableModel(col2, 0);
        tableCursos.setModel(taulaCurs);
        for (Curs fc2 : listaCurs) {
            taulaCurs.addRow(new Object[]{fc2.getId(), fc2.getNombreDeCurs()});
        }
        gc.desconectar();
        btnModiCicle.setEnabled(true);
        btnEliminarCicle.setEnabled(true);
    }//GEN-LAST:event_btnCercaCicleActionPerformed

    private void btnClearCicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCicleActionPerformed
        BuidarCamps();
        BuidarTaula();
    }//GEN-LAST:event_btnClearCicleActionPerformed

    private void btnEliminarCicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCicleActionPerformed
        gc.conectar();
        ci = (Cicle) gc.Buscar(Long.parseLong(tfIdCicle.getText()), Cicle.class);
        gc.Eliminar(ci);
        gc.desconectar();
    }//GEN-LAST:event_btnEliminarCicleActionPerformed

    private void btnModiCicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiCicleActionPerformed
        gc.conectar();
        ci = (Cicle) gc.Buscar(Long.parseLong(tfCercaCicle.getText()), Cicle.class);
        ci = new Cicle(Long.parseLong(tfIdCicle.getText()), tfNomCicle.getText(), tfGrauCicle.getText(), (FamiliaCicles) gc.Buscar(Long.parseLong(tfIdFamiCicle.getText()), FamiliaCicles.class));
        gc.Modificar(ci);
        gc.desconectar();
    }//GEN-LAST:event_btnModiCicleActionPerformed

    private void btnCrearCicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCicleActionPerformed
        gc.conectar();
        ci = new Cicle(tfNomCicle.getText(), tfGrauCicle.getText(), (FamiliaCicles) gc.Buscar(Long.parseLong(tfIdFamiCicle.getText()), FamiliaCicles.class));
        gc.Insertar(ci);
        gc.desconectar();
    }//GEN-LAST:event_btnCrearCicleActionPerformed


    private void btnEliminarCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursActionPerformed
        gc.conectar();
        cr = (Curs) gc.Buscar(Long.parseLong(tfIdCurs.getText()), Curs.class);
        gc.Eliminar(cr);
        gc.desconectar();
    }//GEN-LAST:event_btnEliminarCursActionPerformed

    private void btnCrearModulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearModulActionPerformed
        gc.conectar();
        mo = new Modul(tfNomModul.getText(), (Curs) gc.Buscar(Long.parseLong(tfIdCursModul.getText()), Curs.class), (Cicle) gc.Buscar(Long.parseLong(tfIdModulCicle.getText()), Cicle.class));
        gc.Insertar(mo);
        gc.desconectar();
    }//GEN-LAST:event_btnCrearModulActionPerformed

    private void btnCercaModulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaModulActionPerformed
        gc.conectar();
        mo = (Modul) gc.Buscar(Long.parseLong(tfIdModulCerca.getText()), Modul.class);
        tfIdModul.setText(String.valueOf(mo.getId()));
        tfNomModul.setText(mo.getNom());
        tfIdCursModul.setText(String.valueOf(mo.getCurs().getId()));
        tfIdModulCicle.setText(String.valueOf(mo.getCicle().getId()));
        List<UnitatFormativa> listaUF = mc.BuscarCursosCicle(mo.getId());
        String col[] = {"ID", "NOM", "HORES"};
        DefaultTableModel taulaUFModul = new DefaultTableModel(col, 0);
        taulaModulUF.setModel(taulaUFModul);
        for (UnitatFormativa uf1 : listaUF) {
            taulaUFModul.addRow(new Object[]{uf1.getId(), uf1.getNom(), uf1.getHores()});
        }
        gc.desconectar();
        btnModificarModul.setEnabled(true);
        btnEliminarModul.setEnabled(true);
    }//GEN-LAST:event_btnCercaModulActionPerformed

    private void btnNetejaModulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetejaModulActionPerformed
        BuidarCamps();
        BuidarTaula();
    }//GEN-LAST:event_btnNetejaModulActionPerformed

    private void btnCercaTotsModulsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaTotsModulsActionPerformed
        gc.conectar();
        List<Modul> listaModul = gc.ConsultaTots("Modul");
        String col[] = {"ID", "NOM", "CURSID", "CICLEID"};
        DefaultTableModel taulaModul = new DefaultTableModel(col, 0);
        tableTotsModuls.setModel(taulaModul);
        for (Modul modul : listaModul) {
            taulaModul.addRow(new Object[]{modul.getId(), modul.getNom(), modul.getCurs().getId(), modul.getCicle().getId()});
        }
        gc.desconectar();
    }//GEN-LAST:event_btnCercaTotsModulsActionPerformed

    private void btnModificarModulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarModulActionPerformed
        gc.conectar();
        mo = (Modul) gc.Buscar(Long.parseLong(tfIdModul.getText()), Modul.class);
        mo = new Modul(mo.getId(), tfNomModul.getText(), (Curs) gc.Buscar(Long.parseLong(tfIdCursModul.getText()), Curs.class), (Cicle) gc.Buscar(Long.parseLong(tfIdModulCicle.getText()), Cicle.class));
        gc.Modificar(mo);
        gc.desconectar();
    }//GEN-LAST:event_btnModificarModulActionPerformed

    private void btnEliminarModulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarModulActionPerformed
        gc.conectar();
        mo = (Modul) gc.Buscar(Long.parseLong(tfIdModul.getText()), Modul.class);
        gc.Eliminar(mo);
        gc.desconectar();
    }//GEN-LAST:event_btnEliminarModulActionPerformed

    private void btnCercaIDUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaIDUFActionPerformed
        gc.conectar();
        uf = (UnitatFormativa) gc.Buscar(Long.parseLong(tfCercaIDUF.getText()), UnitatFormativa.class);
        tfIdUF.setText(String.valueOf(uf.getId()));
        tfNomUF.setText(uf.getNom());
        tfHoresUF.setText(String.valueOf(uf.getHores()));
        tfIdCursUF.setText(String.valueOf(uf.getCurs().getId()));
        tfIdModulUF.setText(String.valueOf(uf.getModul().getId()));
        gc.desconectar();
        btnModiUF.setEnabled(true);
        btnEliUF.setEnabled(true);
    }//GEN-LAST:event_btnCercaIDUFActionPerformed

    private void tfIdModulUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdModulUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdModulUFActionPerformed

    private void btnEliUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliUFActionPerformed
        gc.conectar();
        uf = (UnitatFormativa) gc.Buscar(Long.parseLong(tfIdUF.getText()), UnitatFormativa.class);
        gc.Eliminar(uf);
        gc.desconectar();
    }//GEN-LAST:event_btnEliUFActionPerformed

    private void btnCreaUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaUFActionPerformed
        gc.conectar();
        uf = new UnitatFormativa(tfNomUF.getText(), Integer.parseInt(tfHoresUF.getText()), (Curs) gc.Buscar(Long.parseLong(tfIdCursUF.getText()), Curs.class), (Modul) gc.Buscar(Long.parseLong(tfIdModulUF.getText()), Modul.class));
        gc.Insertar(uf);
        gc.desconectar();
    }//GEN-LAST:event_btnCreaUFActionPerformed

    private void btnModiUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiUFActionPerformed
        gc.conectar();
        uf = (UnitatFormativa) gc.Buscar(Long.parseLong(tfIdUF.getText()), UnitatFormativa.class);
        uf = new UnitatFormativa(Long.parseLong(tfIdUF.getText()), tfNomUF.getText(), Integer.parseInt(tfHoresUF.getText()), (Curs) gc.Buscar(Long.parseLong(tfIdCursUF.getText()), Curs.class), (Modul) gc.Buscar(Long.parseLong(tfIdModulUF.getText()), Modul.class));
        gc.Modificar(uf);
        gc.desconectar();

    }//GEN-LAST:event_btnModiUFActionPerformed

    private void btnNetejaUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetejaUFActionPerformed
        BuidarCamps();
        BuidarTaula();
    }//GEN-LAST:event_btnNetejaUFActionPerformed

    private void btnCercaTotesUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaTotesUFActionPerformed
        gc.conectar();
        List<UnitatFormativa> listaUF = gc.ConsultaTots("UnitatFormativa");
        String col[] = {"ID", "NOM", "HORES", "IDCURS", "IDMODUL"};
        DefaultTableModel taulaUF = new DefaultTableModel(col, 0);
        tablaTotesUF.setModel(taulaUF);
        for (UnitatFormativa uf1 : listaUF) {
            taulaUF.addRow(new Object[]{uf1.getId(), uf1.getNom(), uf1.getHores(), uf1.getCurs().getId(), uf1.getModul().getId()});
        }
        gc.desconectar();
    }//GEN-LAST:event_btnCercaTotesUFActionPerformed

    private void btnRefrescaUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescaUFActionPerformed
        gc.conectar();
        List<UnitatFormativa> listaUF = gc.ConsultaTots("UnitatFormativa");
        String col[] = {"ID", "NOM", "HORES", "Nom Curs", "Any Curs", "Modul Nom"};
        DefaultListModel taulaUFModul = new DefaultListModel();
        listaUFs.setModel(taulaUFModul);
        for (UnitatFormativa uf1 : listaUF) {
            taulaUFModul.add(listaUF.indexOf(uf1), Arrays.toString(new Object[]{uf1.getId(), uf1.getNom(), uf1.getHores(), uf1.getCurs().getCicle().getNom(), uf1.getCurs().getNombreDeCurs(), uf1.getModul().getNom(),}));
        }
    }//GEN-LAST:event_btnRefrescaUFActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void btnCrearMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMatriculaActionPerformed
        gc.conectar();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        al = (Alumne) gc.Buscar(tfIdAlumneMatricula.getText(), Alumne.class);
        List<String> llistaUF = null;
        if (rbComplet.isSelected()) {
            Descompte desc = estadoRadioButon();
            matricula = new Matricula(al, date, Modalitat.COMPLET, desc, new Import(Double.parseDouble(tfImport.getText())));
        } else {
            Descompte desc = estadoRadioButon();
            matricula = new Matricula(al, date, Modalitat.UFS, desc, new Import(Double.parseDouble(tfImport.getText())));
        }
        List<String> list = listaUFs.getSelectedValuesList();
        String[] partes;
        List<UnitatFormativa> ufs = new ArrayList<UnitatFormativa>();
        for (String string : list) {
            string = string.replace("[", "");
            partes = string.split(",");
            uf = (UnitatFormativa) gc.Buscar(Long.parseLong(partes[0]), UnitatFormativa.class);
            ufs.add(uf);
        }
        matricula.setListaUF(ufs);
        gc.Insertar(matricula);
        gc.desconectar();
    }//GEN-LAST:event_btnCrearMatriculaActionPerformed

    private void btnCercaNifMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCercaNifMatriculaActionPerformed
        gc.conectar();
        matricula = mac.BuscarPerNif(tfCercaNifMatricula.getText());
        tfIdMatricula.setText(String.valueOf(matricula.getId()));
        tfIdAlumneMatricula.setText(matricula.getAlumneId().getNif());
        if (matricula.getModalitat() == Modalitat.COMPLET) {
            rbComplet.setSelected(true);
        } else {
            rbSoltes.setSelected(true);
        }
        if (matricula.getDescompte() == Descompte.CAP) {
            rbCap.setSelected(true);
        } else if (matricula.getDescompte() == Descompte.PARCIAL) {
            rbMig.setSelected(true);
        } else {
            rbTotal.setSelected(true);
        }
        tfImport.setText(String.valueOf(matricula.getImporte().getImporte()));
        gc.desconectar();
    }//GEN-LAST:event_btnCercaNifMatriculaActionPerformed

    private void rbCogAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCogAlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCogAlActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gc.conectar();
        List<Alumne> list = mac.BuscarAlumneUF(tfUFNOM.getText());
        String col[] = {"NOM"};
        DefaultTableModel taulaUFModuls = new DefaultTableModel();
        jTable1.setModel(taulaUFModuls);
        for (Alumne uf1 : list) {
            taulaUFModuls.addRow(new Object[]{uf1.getNom()});
        }
        gc.desconectar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private Descompte estadoRadioButon() {
        if (rbCap.isSelected()) {
            return Descompte.CAP;
        } else if (rbMig.isSelected()) {
            return Descompte.PARCIAL;
        }
        return Descompte.TOTAL;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDescompte;
    private javax.swing.ButtonGroup bgModalitat;
    private javax.swing.JButton btnCercaAl;
    private javax.swing.JButton btnCercaCicle;
    private javax.swing.JButton btnCercaCurs;
    private javax.swing.JButton btnCercaIDUF;
    private javax.swing.JButton btnCercaModul;
    private javax.swing.JButton btnCercaNifMatricula;
    private javax.swing.JButton btnCercaTotesUF;
    private javax.swing.JButton btnCercaTotsAl;
    private javax.swing.JButton btnCercaTotsCicles;
    private javax.swing.JButton btnCercaTotsCursos;
    private javax.swing.JButton btnCercaTotsModuls;
    private javax.swing.JButton btnCercarFamilia;
    private javax.swing.JButton btnClearAl;
    private javax.swing.JButton btnClearCicle;
    private javax.swing.JButton btnClearFamilia;
    private javax.swing.JButton btnCreaUF;
    private javax.swing.JButton btnCrearAlumn;
    private javax.swing.JButton btnCrearCicle;
    private javax.swing.JButton btnCrearCurs;
    private javax.swing.JButton btnCrearFamilia;
    private javax.swing.JButton btnCrearMatricula;
    private javax.swing.JButton btnCrearModul;
    private javax.swing.JButton btnEliUF;
    private javax.swing.JButton btnEliminarAl;
    private javax.swing.JButton btnEliminarCicle;
    private javax.swing.JButton btnEliminarCurs;
    private javax.swing.JButton btnEliminarFamilia;
    private javax.swing.JButton btnEliminarMatricula;
    private javax.swing.JButton btnEliminarModul;
    private javax.swing.JButton btnLimpiCurs;
    private javax.swing.JButton btnModiAl;
    private javax.swing.JButton btnModiCicle;
    private javax.swing.JButton btnModiCurs;
    private javax.swing.JButton btnModiUF;
    private javax.swing.JButton btnModificarFamilia;
    private javax.swing.JButton btnModificarMatricula;
    private javax.swing.JButton btnModificarModul;
    private javax.swing.JButton btnNetejaModul;
    private javax.swing.JButton btnNetejaUF;
    private javax.swing.JButton btnNetejarMatricula;
    private javax.swing.JButton btnRefrescaUF;
    private javax.swing.JButton btnTotsFC;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup grupNomCurs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> listaUFs;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.Menu menu7;
    private java.awt.Menu menu8;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private java.awt.MenuBar menuBar4;
    private javax.swing.JRadioButton rbCap;
    private javax.swing.JRadioButton rbCogAl;
    private javax.swing.JRadioButton rbComplet;
    private javax.swing.JRadioButton rbIdAl;
    private javax.swing.JRadioButton rbMig;
    private javax.swing.JRadioButton rbPrimer;
    private javax.swing.JRadioButton rbSegon;
    private javax.swing.JRadioButton rbSoltes;
    private javax.swing.JRadioButton rbTotal;
    private javax.swing.JTable tablaCicles;
    private javax.swing.JTable tablaTodasFamilias;
    private javax.swing.JTable tablaTotesUF;
    private javax.swing.JTable tablaTotsAl;
    private javax.swing.JTable tablaTotsCicles;
    private javax.swing.JTable tableCursos;
    private javax.swing.JTable tableListaModuls;
    private javax.swing.JScrollPane tableTotesUF;
    private javax.swing.JTable tableTotsModuls;
    private javax.swing.JScrollPane tableUFModul;
    private javax.swing.JTable taulaModulCurs;
    private javax.swing.JTable taulaModulUF;
    private javax.swing.JTable taulaTotsCursos;
    private javax.swing.JTable taulaUfCurs;
    private javax.swing.JTextField tfCercaAl;
    private javax.swing.JTextField tfCercaCicle;
    private javax.swing.JTextField tfCercaCurs;
    private javax.swing.JTextField tfCercaIDFC;
    private javax.swing.JTextField tfCercaIDUF;
    private javax.swing.JTextField tfCercaNifMatricula;
    private javax.swing.JTextField tfCognomAl;
    private javax.swing.JTextField tfCorreuAl;
    private javax.swing.JTextField tfGrauCicle;
    private javax.swing.JTextField tfHoresUF;
    private javax.swing.JTextField tfIdAlumneMatricula;
    private javax.swing.JTextField tfIdCicle;
    private javax.swing.JTextField tfIdCicleCurs;
    private javax.swing.JTextField tfIdCurs;
    private javax.swing.JTextField tfIdCursModul;
    private javax.swing.JTextField tfIdCursUF;
    private javax.swing.JTextField tfIdFamiCicle;
    private javax.swing.JTextField tfIdFamilia;
    private javax.swing.JTextField tfIdMatricula;
    private javax.swing.JTextField tfIdModul;
    private javax.swing.JTextField tfIdModulCerca;
    private javax.swing.JTextField tfIdModulCicle;
    private javax.swing.JTextField tfIdModulUF;
    private javax.swing.JTextField tfIdUF;
    private javax.swing.JTextField tfImport;
    private javax.swing.JTextField tfNif;
    private javax.swing.JTextField tfNomAl;
    private javax.swing.JTextField tfNomCicle;
    private javax.swing.JTextField tfNomFamilia;
    private javax.swing.JTextField tfNomModul;
    private javax.swing.JTextField tfNomUF;
    private javax.swing.JTextField tfTlfAl;
    private javax.swing.JTextField tfUFNOM;
    // End of variables declaration//GEN-END:variables
}
