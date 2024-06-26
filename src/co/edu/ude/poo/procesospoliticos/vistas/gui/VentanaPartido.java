package co.edu.ude.poo.procesospoliticos.vistas.gui;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.PartidoModel;
import co.edu.ude.poo.procesospoliticos.modelo.crud.PartidoModelJpaController;

import java.awt.Toolkit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.JOptionPane;

/**
 * @author camilo castellar
 */
public class VentanaPartido extends javax.swing.JDialog {
    
    // conexion a la base de datos
    EntityManagerFactory con = Persistence.createEntityManagerFactory("ProcesosPoliticosPU");
    // instanciar la clase PartidoEntityJpaController
    PartidoModelJpaController partidoCrud = new PartidoModelJpaController(con);

    public VentanaPartido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void habilitarBotones(boolean agregar, boolean buscar, boolean modificar, boolean eliminar) {
        btnAgregarPartido.setEnabled(agregar);
        btnBuscarPartido.setEnabled(buscar);
        btnModificarPartido.setEnabled(modificar);
        btnEliminarPartido.setEnabled(eliminar);
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
        txtIDPartido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombrePartido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarPartido = new javax.swing.JButton();
        btnBuscarPartido = new javax.swing.JButton();
        btnModificarPartido = new javax.swing.JButton();
        btnEliminarPartido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procesos Politícos - Gestión de Partidos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Partido:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID:");

        txtIDPartido.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtIDPartido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDPartidoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre del partido:");

        txtNombrePartido.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombrePartido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePartidoKeyTyped(evt);
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
                    .addComponent(txtNombrePartido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtIDPartido, txtNombrePartido});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePartido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtIDPartido, txtNombrePartido});

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PARA GESTIONAR PARTIDOS");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/img_ventana_partidos.png"))); // NOI18N

        btnAgregarPartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/add-icon.png"))); // NOI18N
        btnAgregarPartido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAgregarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPartidoActionPerformed(evt);
            }
        });

        btnBuscarPartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/search-icon.png"))); // NOI18N
        btnBuscarPartido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPartidoActionPerformed(evt);
            }
        });

        btnModificarPartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/edit-icon.png"))); // NOI18N
        btnModificarPartido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnModificarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPartidoActionPerformed(evt);
            }
        });

        btnEliminarPartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/delete-icon.png"))); // NOI18N
        btnEliminarPartido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPartidoActionPerformed(evt);
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
                        .addComponent(btnEliminarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnAgregarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPartidoActionPerformed
        // Datos de formulario, crear un partido
        String id = txtIDPartido.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el id del partido"
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDPartido.setText("");
            txtIDPartido.requestFocus();
            return;
        }  

        String nombrePartido = txtNombrePartido.getText();

        if (nombrePartido == null || nombrePartido.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el nombre del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombrePartido.setText("");
            txtNombrePartido.requestFocus();
            return;
        }

        // Crear objetos
        PartidoModel p = new PartidoModel();
        p.setId(Integer.parseInt(id));
        p.setNombre(nombrePartido);
        
        try {
            partidoCrud.create(p);
            // Mensaje de confirmacion
            int totalPartidosAlmacenados = partidoCrud.getPartidoModelCount();
            String msg = "El partido: " + nombrePartido + " se guardo con éxito";
            msg += "\n" + " TOTAL PARTIDOS: " + totalPartidosAlmacenados;
            JOptionPane.showMessageDialog(this, msg, "RESULTADO", JOptionPane.WARNING_MESSAGE); 
            txtIDPartido.setText("");          
            txtNombrePartido.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarPartidoActionPerformed

    private void txtIDPartidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDPartidoKeyTyped
        // validar que el ID sea Integer
        char tecla = evt.getKeyChar();
        if(!Character.isDigit(tecla)) { 
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIDPartidoKeyTyped

    private void txtNombrePartidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePartidoKeyTyped
        // validar que el nombre del partido sea String
        char tecla = evt.getKeyChar();
        if(!Character.isLetter(tecla) && !Character.isSpaceChar(tecla)) { 
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtNombrePartidoKeyTyped

    private void btnBuscarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPartidoActionPerformed
        String id = txtIDPartido.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el id del partido"
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDPartido.setText("");
            txtIDPartido.requestFocus();
            return;
        }

        // validar en la base de datos que exista el partido a buscar
        if(partidoCrud.findPartidoModel(Integer.parseInt(id)) == null){
            JOptionPane.showMessageDialog(this, "El partido con ID: " + id + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        //recupera el objeto para mostrarlo en los campos del formulario
        PartidoModel p = partidoCrud.findPartidoModel(Integer.parseInt(id));
        txtNombrePartido.setText(p.getNombre());

        // habilitar botones, y deshabilitar el boton agregar
        habilitarBotones(false, true, true, true);
    }//GEN-LAST:event_btnBuscarPartidoActionPerformed

    private void btnModificarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPartidoActionPerformed
        // metodo para modifica un elemento del hasmap, se ubica al elemento con el id y se modifica el nombre
        String id = txtIDPartido.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el id del partido"
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDPartido.setText("");
            txtIDPartido.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar en la base de datos
        if(partidoCrud.findPartidoModel(Integer.parseInt(id)) == null){
            JOptionPane.showMessageDialog(this, "El partido con ID: " + id + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombrePartido = txtNombrePartido.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el nombre del partido"
        if (nombrePartido == null || nombrePartido.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el nombre del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombrePartido.setText("");
            txtNombrePartido.requestFocus();
            return;
        }

        // crear un objeto partido para obtener la actualizacion
        PartidoModel p = partidoCrud.findPartidoModel(Integer.parseInt(id));
        p.setNombre(nombrePartido);


        try {
            partidoCrud.edit(p);
            JOptionPane.showMessageDialog(this, "El partido con ID: " + id + " se modifico con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
            txtIDPartido.setText("");
            txtNombrePartido.setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnModificarPartidoActionPerformed

    private void btnEliminarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPartidoActionPerformed
        // metodo para eliminar un elemento del hasmap, se ubica al elemento con el id y se elimina
        String id = txtIDPartido.getText();

        // Validar que no este vacio o empty con trim, si esta vacio lanzar un mensaje JOptionPane: "Digite el id del partido"
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDPartido.setText("");
            txtIDPartido.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if(partidoCrud.findPartidoModel(Integer.parseInt(id)) == null){
            JOptionPane.showMessageDialog(this, "El partido con ID: " + id + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el partido con ID: " + id + "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                partidoCrud.destroy(Integer.parseInt(id));
                JOptionPane.showMessageDialog(this, "El partido con ID: " + id + " se eliminó con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
                txtIDPartido.setText("");
                txtNombrePartido.setText("");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarPartidoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaPartido dialog = new VentanaPartido(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarPartido;
    private javax.swing.JButton btnBuscarPartido;
    private javax.swing.JButton btnEliminarPartido;
    private javax.swing.JButton btnModificarPartido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIDPartido;
    private javax.swing.JTextField txtNombrePartido;
    // End of variables declaration//GEN-END:variables
}
