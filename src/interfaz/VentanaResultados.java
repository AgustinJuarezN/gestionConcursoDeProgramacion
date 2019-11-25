package interfaz;

import dominio.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import utils.ordenacionCriterioResueltos;
import utils.ordenacionCriterioTiempo;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class VentanaResultados extends javax.swing.JFrame implements Observer {

    private Sistema ovModelo;
    private JButton[][] botones;
    private JButton[][] botonesProblemas;
    private JButton[][] botonesEquipos;
    ArrayList<Equipo> listEquipos = new ArrayList<>();
    
    @Override
    public void update(Observable obs, Object obj)
   {
      if (obs == ovModelo)
      {
          this.actualizar();
      }
   }

    public VentanaResultados(Sistema modelo) {
        this.ovModelo = modelo;
        this.listEquipos = this.ovModelo.getEquipos();
        if (this.listEquipos.size() != 0) {
            this.setLocationRelativeTo(null);
            initComponents();
            this.actualizar();
        }
    }

    public void cargarBotonesEstadistica() {
        panelMatriz.removeAll();
        this.botones = null;
        int cantFilas = botonesEquipos.length;
        int cantColumnas = botonesProblemas[0].length;
        System.out.println("cant filas: " + cantFilas);
        System.out.println("cant columnas: " + cantColumnas);
        panelMatriz.setLayout(new GridLayout(cantFilas, cantColumnas));
        this.botones = new JButton[cantFilas][cantColumnas];
        for (int i = 0; i < botones.length; i++) {
            Equipo equipo = this.ovModelo.getEquipoPorNombre(this.botonesEquipos[i][0].getText());
            for (int j = 0; j < botones[0].length; j++) {
                Problema problema = this.ovModelo.getProblemaPorTitulo(this.botonesProblemas[0][j].getText());
                JButton jButton = new JButton();
                int info[] = this.ovModelo.infoEquipoPorProblema(equipo, problema);
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

        //IMPORTANT
        panelMatriz.revalidate();
        panelMatriz.repaint();
    }

    public void cargarBotonesEquipos() {
        jPanelEquipos.removeAll();
        this.botonesEquipos = null;
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
                System.out.println("equipo button:" + jButton.getText());
            }
        }

        //IMPORTANT
        jPanelEquipos.revalidate();
        jPanelEquipos.repaint();
    }

    public void cargarBotonesProblemas() {
        jPanelProblemas.removeAll();
        this.botonesProblemas = null;
        int cantFilas = 1;
        int cantColumnas = this.ovModelo.getProblemas().size();
        jPanelProblemas.setLayout(new GridLayout(cantFilas, cantColumnas));
        this.botonesProblemas = new JButton[cantFilas][cantColumnas];

        for (int i = 0; i < this.botonesProblemas.length; i++) {
            for (int j = 0; j < this.botonesProblemas[0].length; j++) {
                JButton jButton = new JButton();
                jButton.setText(this.ovModelo.getProblemas().get(j).getTitulo());
                jPanelProblemas.add(jButton);
                this.botonesProblemas[i][j] = jButton;
            }
        }
    }

    public void actualizar() {
        this.cargarBotonesEquipos();
        this.cargarBotonesProblemas();
        this.cargarBotonesEstadistica();
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
        Equipo eq = this.ovModelo.getEquipoPorNombre(this.botonesEquipos[fila][0].getText());
        Problema pro = this.ovModelo.getProblemaPorTitulo(this.botonesProblemas[0][columna].getText());
        ArrayList<Envio> envios = this.ovModelo.getEnviosPorProblemaYEquipo(eq, pro);

        JPanel panel = new JPanel();
        JTextArea jt = new JTextArea(10, 10);
        String line = "";

        for (Envio env : envios) {
            line += env.getProblema() + " | " + env.getEquipo() + " | " + env.getResolvio() + " | " + env.getTiempo() + "\n";
        }

        jt.setText(line);
        panel.add(jt);
        JOptionPane.showMessageDialog(null, panel, "Información de envíos", JOptionPane.INFORMATION_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(560, 400));
        setSize(new java.awt.Dimension(250, 420));
        getContentPane().setLayout(null);
        getContentPane().add(panelMatriz);
        panelMatriz.setBounds(130, 60, 390, 220);

        jPanelEquipos.setLayout(null);
        getContentPane().add(jPanelEquipos);
        jPanelEquipos.setBounds(20, 20, 110, 260);
        getContentPane().add(jPanelProblemas);
        jPanelProblemas.setBounds(130, 20, 390, 40);

        ButtonOrdenarNombre.setText("Nombre equipo");
        ButtonOrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOrdenarNombreActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonOrdenarNombre);
        ButtonOrdenarNombre.setBounds(120, 310, 120, 23);

        ButtonOrdenarResueltos.setText("Ejercicios resueltos");
        ButtonOrdenarResueltos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOrdenarResueltosActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonOrdenarResueltos);
        ButtonOrdenarResueltos.setBounds(240, 310, 150, 23);

        ButtonOrdenarTiempo.setText("Tiempo total");
        ButtonOrdenarTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOrdenarTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonOrdenarTiempo);
        ButtonOrdenarTiempo.setBounds(390, 310, 130, 23);

        jLabel1.setText("Ordenar por:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 315, 100, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonOrdenarTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOrdenarTiempoActionPerformed
        Collections.sort(this.listEquipos, new ordenacionCriterioTiempo());
        this.actualizar();
    }//GEN-LAST:event_ButtonOrdenarTiempoActionPerformed

    private void ButtonOrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOrdenarNombreActionPerformed

        Collections.sort(this.listEquipos);

        this.actualizar();
    }//GEN-LAST:event_ButtonOrdenarNombreActionPerformed

    private void ButtonOrdenarResueltosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOrdenarResueltosActionPerformed

        Collections.sort(this.listEquipos, new ordenacionCriterioResueltos());

        this.actualizar();
    }//GEN-LAST:event_ButtonOrdenarResueltosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonOrdenarNombre;
    private javax.swing.JButton ButtonOrdenarResueltos;
    private javax.swing.JButton ButtonOrdenarTiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelEquipos;
    private javax.swing.JPanel jPanelProblemas;
    private javax.swing.JPanel panelMatriz;
    // End of variables declaration//GEN-END:variables

}
