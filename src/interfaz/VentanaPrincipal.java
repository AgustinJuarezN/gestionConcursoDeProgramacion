/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import dominio.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
/**
 *
 * @author agustinjuarez
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private Sistema modelo;
    /**
     * Creates new form Main2
     */
    public VentanaPrincipal() {
        initComponents();
    }

    public VentanaPrincipal(Sistema unSistema) {
        initComponents();
        this.modelo = unSistema;
        this.setLocationRelativeTo(null);
    }
   
    
    private void guardarSistema(){
        this.modelo.getHelper().guardarSistema(this.modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        fileMenu = new javax.swing.JMenu();
        registroEstudianteMenu = new javax.swing.JMenuItem();
        registroDocenteMenu = new javax.swing.JMenuItem();
        registroEquipoMenu = new javax.swing.JMenuItem();
        registroProblemaMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        CargaIndividualMenu = new javax.swing.JMenuItem();
        CargaGlobalMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        VisualizacionMenu = new javax.swing.JMenuItem();
        EstadisticasMenu = new javax.swing.JMenuItem();
        VisualizacionMenu1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concurso de programacion");
        setBackground(new java.awt.Color(0, 51, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel2)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(122, 122, 122))
        );

        jPanel2.setBackground(new java.awt.Color(102, 16, 32));

        jButton3.setBackground(new java.awt.Color(102, 16, 32));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CARGA");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 16, 32));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CARGA");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(102, 16, 32));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CARGA");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 16, 32));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CARGA");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu3.setText("Sistema");

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menuBar.add(jMenu3);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Registro");

        registroEstudianteMenu.setMnemonic('o');
        registroEstudianteMenu.setText("Estudiante");
        registroEstudianteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEstudianteMenuActionPerformed(evt);
            }
        });
        fileMenu.add(registroEstudianteMenu);

        registroDocenteMenu.setMnemonic('s');
        registroDocenteMenu.setText("Docente");
        registroDocenteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroDocenteMenuActionPerformed(evt);
            }
        });
        fileMenu.add(registroDocenteMenu);

        registroEquipoMenu.setMnemonic('a');
        registroEquipoMenu.setText("Equipo");
        registroEquipoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroEquipoMenuActionPerformed(evt);
            }
        });
        fileMenu.add(registroEquipoMenu);

        registroProblemaMenu.setText("Problema");
        registroProblemaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroProblemaMenuActionPerformed(evt);
            }
        });
        fileMenu.add(registroProblemaMenu);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Solucion");

        CargaIndividualMenu.setMnemonic('t');
        CargaIndividualMenu.setText("Carga individual");
        CargaIndividualMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaIndividualMenuActionPerformed(evt);
            }
        });
        editMenu.add(CargaIndividualMenu);

        CargaGlobalMenu.setMnemonic('y');
        CargaGlobalMenu.setText("Carga global");
        editMenu.add(CargaGlobalMenu);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Resultados");

        VisualizacionMenu.setMnemonic('c');
        VisualizacionMenu.setText("Visualizacion");
        VisualizacionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizacionMenuActionPerformed(evt);
            }
        });
        helpMenu.add(VisualizacionMenu);

        EstadisticasMenu.setMnemonic('a');
        EstadisticasMenu.setText("Estadisticas");
        EstadisticasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadisticasMenuActionPerformed(evt);
            }
        });
        helpMenu.add(EstadisticasMenu);

        VisualizacionMenu1.setMnemonic('c');
        VisualizacionMenu1.setText("Envios");
        VisualizacionMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizacionMenu1ActionPerformed(evt);
            }
        });
        helpMenu.add(VisualizacionMenu1);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void registroEstudianteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEstudianteMenuActionPerformed
        VentanaAgregarEstudiante vent = new VentanaAgregarEstudiante(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_registroEstudianteMenuActionPerformed

    private void registroDocenteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroDocenteMenuActionPerformed
        VentanaAgregarDocente vent = new VentanaAgregarDocente(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_registroDocenteMenuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.guardarSistema();
    }//GEN-LAST:event_formWindowClosing

    private void registroEquipoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroEquipoMenuActionPerformed
        VentanaAgregarEquipo vent = new VentanaAgregarEquipo(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_registroEquipoMenuActionPerformed

    private void registroProblemaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroProblemaMenuActionPerformed
        VentanaAgregarProblema vent = new VentanaAgregarProblema(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_registroProblemaMenuActionPerformed

    private void CargaIndividualMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaIndividualMenuActionPerformed
        VentanaCargaIndividual vent = new VentanaCargaIndividual(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_CargaIndividualMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void VisualizacionMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizacionMenu1ActionPerformed
        VentanaEnvios vent = new VentanaEnvios(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_VisualizacionMenu1ActionPerformed

    private void VisualizacionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizacionMenuActionPerformed
        VentanaResultados vent = new VentanaResultados(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_VisualizacionMenuActionPerformed

    private void EstadisticasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadisticasMenuActionPerformed
        VentanaEstadisticas vent = new VentanaEstadisticas(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_EstadisticasMenuActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CargaGlobalMenu;
    private javax.swing.JMenuItem CargaIndividualMenu;
    private javax.swing.JMenuItem EstadisticasMenu;
    private javax.swing.JMenuItem VisualizacionMenu;
    private javax.swing.JMenuItem VisualizacionMenu1;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem registroDocenteMenu;
    private javax.swing.JMenuItem registroEquipoMenu;
    private javax.swing.JMenuItem registroEstudianteMenu;
    private javax.swing.JMenuItem registroProblemaMenu;
    // End of variables declaration//GEN-END:variables
    
}
