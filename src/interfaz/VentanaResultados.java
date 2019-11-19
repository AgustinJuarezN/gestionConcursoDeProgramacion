/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author agustinjuarez
 */
public class VentanaResultados extends javax.swing.JFrame {

    private Sistema modelo;
    private JButton[][] botones;
    private JButton[][] botonesProblemas;
    private JButton[][] botonesEquipos;
    
    public VentanaResultados(Sistema modelo) {
        initComponents();
        this.modelo = modelo;
        this.setLocationRelativeTo(null);
        this.cargarBotonesEquipos();
        this.cargarBotonesProblemas();
        this.cargarBotonesEstadistica();
    }

    public void cargarBotonesEstadistica() {
        
        int cantFilas = botonesEquipos[0].length;
        int cantColumnas = botonesProblemas[0].length;
        System.out.println("cant filas: "+cantFilas);
        System.out.println("cant columnas: "+cantColumnas);
        panelMatriz.setLayout(new GridLayout(cantFilas, cantColumnas));
        botones = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++) {
            Equipo equipo = this.modelo.getEquipoPorNombre(this.botonesEquipos[i][0].getText());
            for (int j = 0; j < cantColumnas; j++) {
                Problema problema = this.modelo.getProblemaPorTitulo(this.botonesProblemas[i][j].getText());
                JButton jButton = new JButton();
                int info[] = this.modelo.infoEquipoPorProblema(equipo, problema);
                
                System.out.println("resolvio: "+this.modelo.infoEquipoPorProblema(equipo, problema)[0]);
                System.out.println("tiempo: "+this.modelo.infoEquipoPorProblema(equipo, problema)[1]);
                System.out.println("multas: "+this.modelo.infoEquipoPorProblema(equipo, problema)[2]);
                System.out.println("intentos: "+this.modelo.infoEquipoPorProblema(equipo, problema)[3]);
                
                int intentos = info[3];
                int multas = info[2];
                int tiempoMulta = multas*20;
                String textButton="";
                if (info[0] == 1) {
                    textButton += String.valueOf(info[1]+tiempoMulta)+"/"+intentos;
                    jButton.setBackground(Color.green);
                }else {
                    jButton.setText(String.valueOf(intentos));
                    jButton.setBackground(Color.red);
                }
                jButton.setText(textButton);
                jButton.addActionListener(new ListenerBoton(i, j));
                panelMatriz.add(jButton);
                botones[i][j] = jButton;
            }
        }
    }
    
    public void cargarBotonesEquipos() {
        
        int cantFilas = this.modelo.getEquipos().size();
        int cantColumnas = 1;
        jPanelEquipos.setLayout(new GridLayout(cantFilas, cantColumnas));
        this.botonesEquipos = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColumnas; j++) {
                JButton jButton = new JButton();
                jButton.setText(this.modelo.getEquipos().get(i).getNombre());
                jButton.addActionListener(new ListenerBoton(i, j));
                jPanelEquipos.add(jButton);
                this.botonesEquipos[i][j] = jButton;
            }
        }
    }
    
    public void cargarBotonesProblemas() {
        
        int cantFilas = 1;
        int cantColumnas = this.modelo.getProblemas().size();
        jPanelProblemas.setLayout(new GridLayout(cantFilas, cantColumnas));
        this.botonesProblemas = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < cantFilas; i++) {
            for (int j = 0; j < cantColumnas; j++) {
                JButton jButton = new JButton();
                jButton.setText(this.modelo.getProblemas().get(i).getTitulo());
                jButton.addActionListener(new ListenerBoton(i, j));
                jPanelProblemas.add(jButton);
                this.botonesProblemas[i][j] = jButton;
            }
        }
    }
     
    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {

    }

    /**jPanelEquipos
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        jPanelEquipos = new javax.swing.JPanel();
        jPanelProblemas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(250, 440));
        getContentPane().setLayout(null);
        getContentPane().add(panelMatriz);
        panelMatriz.setBounds(150, 90, 380, 220);

        jPanelEquipos.setLayout(null);
        getContentPane().add(jPanelEquipos);
        jPanelEquipos.setBounds(30, 20, 100, 290);
        getContentPane().add(jPanelProblemas);
        jPanelProblemas.setBounds(130, 10, 390, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelEquipos;
    private javax.swing.JPanel jPanelProblemas;
    private javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables

}
