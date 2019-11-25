package interfaz;

import dominio.*;
import java.util.ArrayList;
import java.util.regex.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class VentanaAgregarEstudiante extends javax.swing.JFrame {

    private Sistema modelo;

    /**
     * Creates new form ventanaAgregarDocente
     */
    public VentanaAgregarEstudiante() {
        initComponents();
    }

    public VentanaAgregarEstudiante(Sistema modelo) {
        initComponents();
        this.modelo = modelo;
        this.setLocationRelativeTo(null);
        this.actualizarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSemestreCrearEstudiante = new javax.swing.JTextField();
        jTextFieldNombreCrearEstudiante = new javax.swing.JTextField();
        jTextFieldCICrearEstudiante = new javax.swing.JTextField();
        jTextFieldNroCrearEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonCrearEstudiante = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMailCrearEstudiante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEstudiantes = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 400));
        setSize(new java.awt.Dimension(250, 440));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel1.setText("Crear estudiante");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 20, 210, 24);

        jLabel2.setText("SEMESTRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 230, 100, 14);

        jTextFieldSemestreCrearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSemestreCrearEstudianteActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldSemestreCrearEstudiante);
        jTextFieldSemestreCrearEstudiante.setBounds(170, 225, 190, 20);

        jTextFieldNombreCrearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreCrearEstudianteActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombreCrearEstudiante);
        jTextFieldNombreCrearEstudiante.setBounds(170, 65, 190, 20);

        jTextFieldCICrearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCICrearEstudianteActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCICrearEstudiante);
        jTextFieldCICrearEstudiante.setBounds(170, 105, 190, 20);
        getContentPane().add(jTextFieldNroCrearEstudiante);
        jTextFieldNroCrearEstudiante.setBounds(170, 185, 190, 20);

        jLabel3.setText("NOMBRE:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 70, 70, 14);

        jLabel4.setText("C.I:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 110, 70, 14);

        jLabel5.setText("MAIL:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 150, 70, 14);

        jButtonCrearEstudiante.setText("CREAR");
        jButtonCrearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearEstudianteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCrearEstudiante);
        jButtonCrearEstudiante.setBounds(120, 270, 180, 23);

        jLabel6.setText("NRO ESTUDIANTE:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 190, 120, 14);
        getContentPane().add(jTextFieldMailCrearEstudiante);
        jTextFieldMailCrearEstudiante.setBounds(170, 145, 190, 20);

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setText("Lista estudiante");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(440, 20, 150, 24);

        jScrollPane1.setViewportView(jListEstudiantes);

        jScrollPane3.setViewportView(jScrollPane1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(410, 60, 190, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreCrearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreCrearEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreCrearEstudianteActionPerformed

    private void jTextFieldCICrearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCICrearEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCICrearEstudianteActionPerformed

    private void jTextFieldSemestreCrearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSemestreCrearEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSemestreCrearEstudianteActionPerformed

    private void jButtonCrearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearEstudianteActionPerformed
        String erroresValidaciones = "";
        String nombre = "";
        String mail = "";
        String ci = "";
        String nroEstudiante = "";
        String semestre = "";
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);

        if (!this.modelo.getHelper().esNumero(jTextFieldNombreCrearEstudiante.getText())) {
            if (jTextFieldNombreCrearEstudiante.getText().equals("")) {
                erroresValidaciones += "El campo nombre no puede ser vacío \n";
            } else {
                nombre = jTextFieldNombreCrearEstudiante.getText();
            }
        } else {
            erroresValidaciones += "El campo nombre no puede contener numeros \n";
        }

        Matcher matcher = pattern.matcher(jTextFieldMailCrearEstudiante.getText());
        if (matcher.matches()) {
            mail = jTextFieldMailCrearEstudiante.getText();
        } else {
            if (jTextFieldMailCrearEstudiante.getText().equals("")) {
                erroresValidaciones += "El campo email no puede ser vacío \n";
            } else {
                erroresValidaciones += "Formato de email incorrecto \n";
            }
        }

        if (this.modelo.getHelper().esNumero(jTextFieldCICrearEstudiante.getText())) {
            ci = jTextFieldCICrearEstudiante.getText();
        } else {
            if (jTextFieldCICrearEstudiante.getText().equals("")) {
                erroresValidaciones += "El campo CI no puede ser vacío \n";
            } else {
                erroresValidaciones += "El campo ci debe contener solamente números \n";
            }
        }

        if (this.modelo.getHelper().esNumero(jTextFieldNroCrearEstudiante.getText())) {
            nroEstudiante = jTextFieldNroCrearEstudiante.getText();
        } else {
            if (jTextFieldNroCrearEstudiante.getText().equals("")) {
                erroresValidaciones += "El campo Nro de estudiante no puede ser vacío \n";
            } else {
                erroresValidaciones += "El campo nro de estudiante debe contener solamente números \n";
            }
        }

        if (this.modelo.getHelper().esNumero(jTextFieldSemestreCrearEstudiante.getText())) {
            semestre = jTextFieldSemestreCrearEstudiante.getText();
        } else {
            if (jTextFieldSemestreCrearEstudiante.getText().equals("")) {
                erroresValidaciones += "El campo semestre no puede ser vacío \n";
            } else {
                erroresValidaciones += "El campo semestre debe contener solamente números \n";
            }
        }

        if (erroresValidaciones.equals("")) {
            Estudiante estudiante = new Estudiante(nombre, ci, mail, nroEstudiante, semestre);
            boolean ok = this.modelo.agregarEstudiante(estudiante);
            if (ok) {
                JOptionPane.showMessageDialog(null, "El Estudiante " + nombre + " se ha dado de alta en el sistema", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                actualizarLista();
            } else {
                JOptionPane.showMessageDialog(null, "El Estudiante " + nombre + " ya se encuentra en el sistema.", "Informacion", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, erroresValidaciones, "Error en validaciones", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonCrearEstudianteActionPerformed

    private void actualizarLista() {

        DefaultListModel l = new DefaultListModel();
        for (Estudiante e : this.modelo.getEstudiantes()) {
            l.addElement(e);
        }
        jListEstudiantes.setModel(l);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrearEstudiante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jListEstudiantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldCICrearEstudiante;
    private javax.swing.JTextField jTextFieldMailCrearEstudiante;
    private javax.swing.JTextField jTextFieldNombreCrearEstudiante;
    private javax.swing.JTextField jTextFieldNroCrearEstudiante;
    private javax.swing.JTextField jTextFieldSemestreCrearEstudiante;
    // End of variables declaration//GEN-END:variables

}
