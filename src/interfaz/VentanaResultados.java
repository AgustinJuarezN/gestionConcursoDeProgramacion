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
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author agustinjuarez
 */
public class VentanaResultados extends javax.swing.JFrame {

    private Sistema modelo;
    private JButton[][] botones;
    private JButton[][] botonesProblemas;
    private JButton[][] botonesEquipos;
    private boolean ordenarPorNombre = false;
    private boolean ordenarPorResueltos = false;
    private boolean ordenarPorTiempo = false;
    ArrayList<Equipo> listEquipos = new ArrayList<>();
    public VentanaResultados(Sistema modelo) {
        initComponents();
        this.modelo = modelo;
        this.listEquipos = this.modelo.getEquipos();
        this.setLocationRelativeTo(null);
        this.actualizar();
    }

    public void cargarBotonesEstadistica() {

        int cantFilas = botonesEquipos.length;
        int cantColumnas = botonesProblemas[0].length;
        System.out.println("cant filas: " + cantFilas);
        System.out.println("cant columnas: " + cantColumnas);
        panelMatriz.setLayout(new GridLayout(cantFilas, cantColumnas));
        this.botones = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < botones.length; i++) {
            Equipo equipo = this.modelo.getEquipoPorNombre(this.botonesEquipos[i][0].getText());
            for (int j = 0; j < botones[0].length; j++) {
                Problema problema = this.modelo.getProblemaPorTitulo(this.botonesProblemas[i][j].getText());

                for (int k = 0; k < this.botonesProblemas.length; k++) {
                    for (int l = 0; l < this.botonesProblemas[0].length; l++) {
                        System.out.print(this.botonesProblemas[k][l].getText() + " |");
                    }
                    System.out.println("");
                }
                JButton jButton = new JButton();
                int info[] = this.modelo.infoEquipoPorProblema(equipo, problema);

                System.out.println("resolvio: " + this.modelo.infoEquipoPorProblema(equipo, problema)[0]);
                System.out.println("tiempo: " + this.modelo.infoEquipoPorProblema(equipo, problema)[1]);
                System.out.println("multas: " + this.modelo.infoEquipoPorProblema(equipo, problema)[2]);
                System.out.println("intentos: " + this.modelo.infoEquipoPorProblema(equipo, problema)[3]);

                int intentos = info[3];
                int multas = info[2];
                int tiempoMulta = multas * 20;
                String textButton = "";
                jButton.setForeground(Color.WHITE);
                if (info[0] == 1) {
                    textButton += String.valueOf(info[1] + tiempoMulta) + "/" + intentos;
                    jButton.setBackground(Color.green);
                } else if (intentos != 0) {
                    textButton += intentos;
                    jButton.setBackground(Color.red);
                } else {
                    jButton.setBackground(Color.white);
                }
                jButton.setText(textButton);
                jButton.addActionListener(new ListenerBoton(i, j));
                panelMatriz.add(jButton);
                this.botones[i][j] = jButton;
            }
        }
    }

    public void cargarBotonesEquipos() {

        int cantFilas = this.listEquipos.size();
        int cantColumnas = 1;
        jPanelEquipos.setLayout(new GridLayout(cantFilas, cantColumnas));
        this.botonesEquipos = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < this.botonesEquipos.length; i++) {
            for (int j = 0; j < this.botonesEquipos[0].length; j++) {
                JButton jButton = new JButton();
                jButton.setText(this.listEquipos.get(i).getNombre());
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
        
        for (JButton[] botonesProblema : this.botonesProblemas) {
            for (int j = 0; j < this.botonesProblemas[0].length; j++) {
                JButton jButton = new JButton();
                jButton.setText(this.modelo.getProblemas().get(j).getTitulo());
                jPanelProblemas.add(jButton);
                botonesProblema[j] = jButton;
            }
        }
    }
    
    public void actualizar() {
        this.cargarBotonesEquipos();
        this.cargarBotonesProblemas();
       // this.cargarBotonesEstadistica();
    }

    private class ListenerBoton implements ActionListener {

        private final int x;
        private final int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {
        Equipo eq = this.modelo.getEquipoPorNombre(this.botonesEquipos[fila][0].getText());
        Problema pro = this.modelo.getProblemaPorTitulo(this.botonesProblemas[0][columna].getText());
        ArrayList<Envio> envios = this.modelo.getEnviosPorProblemaYEquipo(eq, pro);
        System.out.println("Envios: " + envios);

        JPanel panel = new JPanel();
        JTextArea jt = new JTextArea(10, 10);
        String line = "";
        
        for (Envio env : envios) {
            line += env.getProblema() + " | " + env.getEquipo() + " | " + env.getResolvio() + " | " + env.getTiempo() + "\n";
        }

        jt.setText(line);
        panel.add(jt);
        JOptionPane.showMessageDialog(null, panel, "Información de envíos",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * jPanelEquipos This method is called from within the constructor to
     * initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        jPanelEquipos = new javax.swing.JPanel();
        jPanelProblemas = new javax.swing.JPanel();
        ButtonOrdenarNombre = new javax.swing.JButton();
        ButtonOrdenarResueltos = new javax.swing.JButton();
        ButtonOrdenarTiempo = new javax.swing.JButton();

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

        ButtonOrdenarNombre.setText("Nombre");
        ButtonOrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOrdenarNombreActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonOrdenarNombre);
        ButtonOrdenarNombre.setBounds(530, 120, 110, 23);

        ButtonOrdenarResueltos.setText("Resueltos");
        getContentPane().add(ButtonOrdenarResueltos);
        ButtonOrdenarResueltos.setBounds(530, 160, 110, 23);

        ButtonOrdenarTiempo.setText("Tiempo");
        ButtonOrdenarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOrdenarTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonOrdenarTiempo);
        ButtonOrdenarTiempo.setBounds(530, 200, 110, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonOrdenarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOrdenarTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonOrdenarTiempoActionPerformed

    private void ButtonOrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOrdenarNombreActionPerformed

        if(!this.ordenarPorNombre) {
            Collections.sort(this.listEquipos);
            this.ordenarPorNombre = true;
        }else {
            Collections.reverse(this.listEquipos);
            this.ordenarPorNombre = false;
        }
        this.actualizar();
    }//GEN-LAST:event_ButtonOrdenarNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonOrdenarNombre;
    private javax.swing.JButton ButtonOrdenarResueltos;
    private javax.swing.JButton ButtonOrdenarTiempo;
    private javax.swing.JPanel jPanelEquipos;
    private javax.swing.JPanel jPanelProblemas;
    private javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables

}
