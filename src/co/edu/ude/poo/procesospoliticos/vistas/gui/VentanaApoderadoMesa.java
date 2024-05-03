package co.edu.ude.poo.procesospoliticos.vistas.gui;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoMesa;
import co.edu.ude.poo.procesospoliticos.modelo.crud.ApoderadoMesaCrud;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CiudadanoCrud;


import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 * @author camilo castellar
 */
public class VentanaApoderadoMesa extends javax.swing.JDialog {

    // instacia de clase CRUD ApoderadoMesaCrud
    ApoderadoMesaCrud apoderadoCrud = new ApoderadoMesaCrud();
    
    public VentanaApoderadoMesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    

    public void habilitarBotones(boolean agregar, boolean buscar, boolean modificar, boolean eliminar) {
        btnAgregarApoderado.setEnabled(agregar);
        btnBuscarApoderado.setEnabled(buscar);
        btnModificarApoderado.setEnabled(modificar);
        btnEliminarApoderado.setEnabled(eliminar);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDNIApoderado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRUTApoderado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarApoderado = new javax.swing.JButton();
        btnBuscarApoderado = new javax.swing.JButton();
        btnModificarApoderado = new javax.swing.JButton();
        btnEliminarApoderado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procesos Politícos - Gestión de Apoderados de mesa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del apoderado de mesa:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DNI");

        txtDNIApoderado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtDNIApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIApoderadoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RUT:");

        txtRUTApoderado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtRUTApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUTApoderadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRUTApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNIApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDNIApoderado, txtRUTApoderado});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNIApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRUTApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDNIApoderado, txtRUTApoderado});

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PARA GESTIONAR APODERADOS DE MESA");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/Actions-resource-group-icon.png"))); // NOI18N

        btnAgregarApoderado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/add-icon.png"))); // NOI18N
        btnAgregarApoderado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAgregarApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarApoderadoActionPerformed(evt);
            }
        });

        btnBuscarApoderado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/search-icon.png"))); // NOI18N
        btnBuscarApoderado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscarApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarApoderadoActionPerformed(evt);
            }
        });

        btnModificarApoderado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/edit-icon.png"))); // NOI18N
        btnModificarApoderado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnModificarApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarApoderadoActionPerformed(evt);
            }
        });

        btnEliminarApoderado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/delete-icon.png"))); // NOI18N
        btnEliminarApoderado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminarApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarApoderadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarApoderadoActionPerformed
        // Datos de formulario, crear un apoderado de mesa
        String dni = txtDNIApoderado.getText();

        // Validar que no este vacio el dni
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el dni del apoderado", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNIApoderado.setText("");
            txtDNIApoderado.requestFocus();
            return;
        }  

        String rutApoderado = txtRUTApoderado.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el nombre del partido"
        if (rutApoderado == null || rutApoderado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el RUT del apoderado de mesa", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtRUTApoderado.setText("");
            txtRUTApoderado.requestFocus();
            return;
        }

        
        // bucar ciudadano por DNI
        //CiudadanoCrud ciudadanoCrud = new CiudadanoCrud();

        Ciudadano c = new Ciudadano(100, 20, "Camilo Castellar", "HOMBRE");
        
        /*
        // validar que el ciudadano exista antes de que se cree un apoderado de mesa
        try {
            c = ciudadanoCrud.buscarCiudadano(Integer.parseInt(dni));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El apoderado con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        */

        // Crear objeto apoderado de mesa
        ApoderadoMesa p = new ApoderadoMesa(c, Integer.parseInt(rutApoderado));

        try {
            apoderadoCrud.agregarApoderadoMesa(c.getDNICiudadano(), p);
            
            // Mensaje de confirmacion
            int totalApoderadosAlmacenados = apoderadoCrud.contarApoderados();
            String msg = "El apoderado de mesa: " + c.getNombreCompletoCiudadano() + " se guardo con éxito";
            msg += "\n" + " TOTAL: " + totalApoderadosAlmacenados;
            JOptionPane.showMessageDialog(this, msg, "RESULTADO", JOptionPane.WARNING_MESSAGE); 
            txtDNIApoderado.setText("");          
            txtRUTApoderado.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarApoderadoActionPerformed

    private void txtDNIApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIApoderadoKeyTyped
        // validar que el ID sea Integer
        char tecla = evt.getKeyChar();
        if(!Character.isDigit(tecla)) { 
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIApoderadoKeyTyped

    private void txtRUTApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUTApoderadoKeyTyped
        // validar que el nombre del partido sea String
        char tecla = evt.getKeyChar();
        if(!Character.isDigit(tecla)) { 
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRUTApoderadoKeyTyped

    private void btnBuscarApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarApoderadoActionPerformed
        String dni = txtDNIApoderado.getText();

        // Validar que no este vacio el dni
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el DNI del apoderado de mesa", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNIApoderado.setText("");
            txtDNIApoderado.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (!apoderadoCrud.apoderados.containsKey(Integer.parseInt(dni))) {
            JOptionPane.showMessageDialog(this, "El apoderado con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // se recupera el objeto para mostrarlo en los campos del formulario
        ApoderadoMesa p = apoderadoCrud.apoderados.get(Integer.parseInt(dni));
        txtRUTApoderado.setText(String.valueOf(p.getRUTApoderado()));

        // habilitar botones, y deshabilitar el boton agregar
        habilitarBotones(false, true, true, true);
    }//GEN-LAST:event_btnBuscarApoderadoActionPerformed

    private void btnModificarApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarApoderadoActionPerformed
        String dni = txtDNIApoderado.getText();

        // Validar que no este vacio
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el dni del apoderado", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNIApoderado.setText("");
            txtDNIApoderado.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (!apoderadoCrud.apoderados.containsKey(Integer.parseInt(dni))) {
            JOptionPane.showMessageDialog(this, "El apoderado: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String rutApoderado = txtRUTApoderado.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el nombre del partido"
        if (rutApoderado == null || rutApoderado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el nombre del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtRUTApoderado.setText("");
            txtRUTApoderado.requestFocus();
            return;
        }

        try {
            apoderadoCrud.actualizarApoderadoMesa(Integer.parseInt(dni), Integer.parseInt(rutApoderado));
            JOptionPane.showMessageDialog(this, "El apoderado con DNI: " + dni + " se actualizo con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
            txtDNIApoderado.setText("");
            txtRUTApoderado.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnModificarApoderadoActionPerformed

    private void btnEliminarApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarApoderadoActionPerformed
        String dni = txtDNIApoderado.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el id del partido"
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el DNI del apoderado", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNIApoderado.setText("");
            txtDNIApoderado.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (!apoderadoCrud.apoderados.containsKey(Integer.parseInt(dni))) {
            JOptionPane.showMessageDialog(this, "El apoderado con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el apoderado con DNI: " + dni + "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                apoderadoCrud.eliminarApoderadoMesa(Integer.parseInt(dni));
                JOptionPane.showMessageDialog(this, "El apoderado con DNI: " + dni + " se elimino con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
                txtDNIApoderado.setText("");
                txtRUTApoderado.setText("");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarApoderadoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaApoderadoMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaApoderadoMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaApoderadoMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaApoderadoMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaApoderadoMesa dialog = new VentanaApoderadoMesa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarApoderado;
    private javax.swing.JButton btnBuscarApoderado;
    private javax.swing.JButton btnEliminarApoderado;
    private javax.swing.JButton btnModificarApoderado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDNIApoderado;
    private javax.swing.JTextField txtRUTApoderado;
    // End of variables declaration//GEN-END:variables
}
