package interfaz;

import dominio.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class VentanaAgregarProblema extends javax.swing.JFrame {

    private String path;
    private Sistema modelo;

    /**
     * Creates new form ventanaAgregarDocente
     */
    public VentanaAgregarProblema() {
        initComponents();
    }

    public VentanaAgregarProblema(Sistema modelo) {
        initComponents();
        jFileChooser.setApproveButtonText("Seleccionar");
        this.modelo = modelo;
        this.setLocationRelativeTo(null);
        this.cargarListaDocentes();
        this.actualizarLista();
    }

    public void cargarListaDocentes() {
        this.modelo.getDocentes().forEach((d) -> {
            jComboBoxResponsableProblema.addItem(d.getCi());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTituloProblema = new javax.swing.JTextField();
        jTextFieldDescripcionProblema = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonCrearProblema = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProblemas = new javax.swing.JList<>();
        jComboBoxResponsableProblema = new javax.swing.JComboBox<>();
        jFileChooser = new javax.swing.JFileChooser();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 650));
        setSize(new java.awt.Dimension(250, 460));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel1.setText("Crear problema");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 20, 170, 24);

        jLabel2.setText("C.I DOCENTE RESPONSABLE:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 480, 200, 14);

        jTextFieldTituloProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloProblemaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTituloProblema);
        jTextFieldTituloProblema.setBounds(110, 70, 260, 20);

        jTextFieldDescripcionProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescripcionProblemaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldDescripcionProblema);
        jTextFieldDescripcionProblema.setBounds(110, 110, 260, 20);

        jLabel3.setText("TITULO:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 70, 14);

        jLabel4.setText("DESCRIPCION:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 110, 90, 14);

        jLabel5.setText("Seleccione datos de salida oficial del problema:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 170, 310, 14);

        jButtonCrearProblema.setText("CREAR");
        jButtonCrearProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearProblemaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCrearProblema);
        jButtonCrearProblema.setBounds(100, 540, 180, 23);

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jLabel7.setText("Lista problemas");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(530, 20, 200, 24);

        jScrollPane1.setViewportView(jListProblemas);

        jScrollPane3.setViewportView(jScrollPane1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(450, 70, 290, 160);

        getContentPane().add(jComboBoxResponsableProblema);
        jComboBoxResponsableProblema.setBounds(260, 480, 140, 20);

        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser);
        jFileChooser.setBounds(20, 190, 400, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTituloProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloProblemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTituloProblemaActionPerformed

    private void jTextFieldDescripcionProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescripcionProblemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescripcionProblemaActionPerformed

    private void jButtonCrearProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearProblemaActionPerformed
        String titulo = "";
        String descripcion = "";
        String erroresValidaciones = "";
        Docente responsable = null;
        if (!this.path.equals("")) {
            if (!this.modelo.getHelper().esNumero(jTextFieldTituloProblema.getText())) {
                if (jTextFieldTituloProblema.getText().equals("")) {
                    erroresValidaciones += "El campo titulo no puede ser vacío \n";
                } else {
                    titulo = jTextFieldTituloProblema.getText();
                }
            } else {
                erroresValidaciones += "El campo titulo no puede contener números \n";
            }

            if (!this.modelo.getHelper().esNumero(jTextFieldDescripcionProblema.getText())) {
                if (jTextFieldDescripcionProblema.getText().equals("")) {
                    erroresValidaciones += "El campo descripción no puede ser vacío \n";
                } else {
                    descripcion = jTextFieldDescripcionProblema.getText();
                }
            } else {
                erroresValidaciones += "El campo descripción no puede contener números \n";
            }
            
            if (this.modelo.getDocentes().size() == 0) {
                erroresValidaciones += "No hay docentes registrados en el sistema \n";
            }

            if (erroresValidaciones.equals("")) {
                responsable = this.modelo.getDocentePorCi(jComboBoxResponsableProblema.getSelectedItem().toString());
                Problema p = new Problema(titulo, descripcion, responsable, this.path);
                if (!this.modelo.agregarProblema(p)) {
                    JOptionPane.showMessageDialog(null, "Ya existe un problema con ese titulo.", "Informacion", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, erroresValidaciones, "Error en validaciones", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un archivo.", "Informacion", JOptionPane.WARNING_MESSAGE);
        }
        actualizarLista();
    }//GEN-LAST:event_jButtonCrearProblemaActionPerformed

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            JOptionPane.showMessageDialog(null, "El archivo ha sido seleccionado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            this.path = jFileChooser.getSelectedFile().getPath();
        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            this.path = "";
            JOptionPane.showMessageDialog(null, "El archivo ha sido deseleccionado.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jFileChooserActionPerformed

    private void actualizarLista() {

        DefaultListModel l = new DefaultListModel();
        for (Problema pro : this.modelo.getProblemas()) {
            l.addElement(pro);
        }
        jListProblemas.setModel(l);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrearProblema;
    private javax.swing.JComboBox<String> jComboBoxResponsableProblema;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jListProblemas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextFieldDescripcionProblema;
    private javax.swing.JTextField jTextFieldTituloProblema;
    // End of variables declaration//GEN-END:variables

}
