package co.edu.ude.poo.procesospoliticos.vistas.gui;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ComunaModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.PartidoModel;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CandidatoModelJpaController;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CiudadanoModelJpaController;
import co.edu.ude.poo.procesospoliticos.modelo.crud.ComunaModelJpaController;
import co.edu.ude.poo.procesospoliticos.modelo.crud.PartidoModelJpaController;

import java.awt.Toolkit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * @author camilo castellar
 */
public class VentanaCandidato extends javax.swing.JDialog {

    EntityManagerFactory con = Persistence.createEntityManagerFactory("ProcesosPoliticosPU");
    CandidatoModelJpaController candidatoCrud = new CandidatoModelJpaController(con);
    
    public VentanaCandidato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComunas();
        cargarPartidos();
    }
    
    public void habilitarBotones(boolean agregar, boolean buscar, boolean modificar, boolean eliminar) {
        btnAgregarCandidato.setEnabled(agregar);
        btnBuscarCandidato.setEnabled(buscar);
        btnModificarCandidato.setEnabled(modificar);
        btnEliminarCandidato.setEnabled(eliminar);
    }

    public void cargarComunas() {
        
        ComunaModelJpaController comunaCrud = new ComunaModelJpaController(con);
        ComunaModel comunaModel = new ComunaModel();

        cmbComunaLocal.removeAllItems();
        cmbComunaLocal.addItem("Seleccione una comuna");
        for (ComunaModel c : comunaCrud.findComunaModelEntities()) {
            cmbComunaLocal.addItem(c.getNombre());
        }

        cmbComunaLocal.setSelectedIndex(0);
    }

    public void cargarPartidos() {
        
        PartidoModelJpaController partidoCrud = new PartidoModelJpaController(con);
        PartidoModel partidoModel = new PartidoModel();

        cmbPartidos.removeAllItems();
        cmbPartidos.addItem("Seleccione un partido");
        for (PartidoModel p : partidoCrud.findPartidoModelEntities()) {
            cmbPartidos.addItem(p.getNombre());
        }

        cmbPartidos.setSelectedIndex(0);
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
        txtDNICandidato = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCategoriaCandidato = new javax.swing.JTextField();
        cmbPartidos = new javax.swing.JComboBox<>();
        cmbComunaLocal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarCandidato = new javax.swing.JButton();
        btnBuscarCandidato = new javax.swing.JButton();
        btnModificarCandidato = new javax.swing.JButton();
        btnEliminarCandidato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procesos Politícos - Gestión de Candidatos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del candidato:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("DNI");

        txtDNICandidato.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtDNICandidato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNICandidatoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Partido:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Comuna:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Categoria:");

        txtCategoriaCandidato.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        cmbPartidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbComunaLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDNICandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbComunaLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCategoriaCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNICandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbComunaLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoriaCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3});

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PARA GESTIONAR CANDIDATOS");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/choose-2-icon.png"))); // NOI18N

        btnAgregarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/add-icon.png"))); // NOI18N
        btnAgregarCandidato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAgregarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCandidatoActionPerformed(evt);
            }
        });

        btnBuscarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/search-icon.png"))); // NOI18N
        btnBuscarCandidato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCandidatoActionPerformed(evt);
            }
        });

        btnModificarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/edit-icon.png"))); // NOI18N
        btnModificarCandidato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnModificarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCandidatoActionPerformed(evt);
            }
        });

        btnEliminarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/delete-icon.png"))); // NOI18N
        btnEliminarCandidato.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCandidatoActionPerformed(evt);
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
                        .addComponent(btnEliminarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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
                    .addComponent(btnAgregarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCandidatoActionPerformed
        // Datos de formulario, crear un apoderado de mesa
        String dni = txtDNICandidato.getText();

        // Validar que no este vacio el dni
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el dni del candidato", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNICandidato.setText("");
            txtDNICandidato.requestFocus();
            return;
        }

        // Validar que el combobox de partido no este vacio y luego obten el item elegido
        if(cmbPartidos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            cmbPartidos.requestFocus();
            return;
        }

        String partidoCandidato = cmbPartidos.getSelectedItem().toString();


        // Validar que no este vacio la comuna
        if (cmbComunaLocal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una comuna", "ERROR", JOptionPane.ERROR_MESSAGE);
            cmbComunaLocal.requestFocus();
            return;
        }

        String comunaCandidato = cmbComunaLocal.getSelectedItem().toString();

        
        String categoriaCandidato = txtCategoriaCandidato.getText();
        // Validar que no este vacio la categoria
        if (categoriaCandidato == null || categoriaCandidato.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite la categoria del candidato", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCategoriaCandidato.setText("");
            txtCategoriaCandidato.requestFocus();
            return;
        }

        // bucar ciudadano por DNI
        // Validar que el dni del ciudadano exista
        CiudadanoModelJpaController ciudadanoCrud = new CiudadanoModelJpaController(con);
        CiudadanoModel c = ciudadanoCrud.findCiudadanoModel(Integer.parseInt(dni));
        if (c == null) {
            JOptionPane.showMessageDialog(this, "El ciudadano con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // buscar partido por nombre
        // Validar que el partido exista
        PartidoModelJpaController partidoCrud = new PartidoModelJpaController(con);
        // buscar partido por nombre usando un for
        Integer idPartido = null;
        PartidoModel p = new PartidoModel();
        for (PartidoModel partido : partidoCrud.findPartidoModelEntities()) {
            if (partido.getNombre().equals(partidoCandidato)) {
                idPartido = partido.getId();
            }
        }
        if (p == null) {
            JOptionPane.showMessageDialog(this, "El partido con nombre: " + partidoCandidato + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PartidoModel partido = partidoCrud.findPartidoModel(idPartido);

        // buscar comuna por nombre
        // Validar que la comuna exista
        ComunaModelJpaController comunaCrud = new ComunaModelJpaController(con);
        ComunaModel cm = new ComunaModel();
        String idComuna = null;
        for (ComunaModel comuna : comunaCrud.findComunaModelEntities()) {
            if (comuna.getNombre().equals(comunaCandidato)) {
                idComuna = comuna.getId().toString();
            }
        }
        if (cm == null) {
            JOptionPane.showMessageDialog(this, "La comuna con nombre: " + comunaCandidato + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ComunaModel comuna = comunaCrud.findComunaModel(Integer.parseInt(idComuna));
        
        // Crear un objeto candidato
        CandidatoModel candidato = new CandidatoModel();
        candidato.setDni(Integer.parseInt(dni));
        candidato.setCiudadanoModel(c);
        candidato.setPartido(partido);
        candidato.setComuna(comuna);
        candidato.setCategoria(categoriaCandidato);

        try {
            candidatoCrud.create(candidato);
            // Mensaje de confirmacion
            int totalCandidatosAlmacenados = candidatoCrud.getCandidatoModelCount();
            String msg = "El candidato: " + candidato.getCiudadanoModel().getNombre() + " se guardo con éxito";
            msg += "\n" + " TOTAL: " + totalCandidatosAlmacenados;
            JOptionPane.showMessageDialog(this, msg, "RESULTADO", JOptionPane.WARNING_MESSAGE); 
            txtDNICandidato.setText("");          
            txtCategoriaCandidato.setText("");
            cmbPartidos.setSelectedIndex(0);
            cmbComunaLocal.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarCandidatoActionPerformed

    private void txtDNICandidatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNICandidatoKeyTyped
        // validar que el ID sea Integer
        char tecla = evt.getKeyChar();
        if(!Character.isDigit(tecla)) { 
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDNICandidatoKeyTyped

    private void btnBuscarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCandidatoActionPerformed
        String dni = txtDNICandidato.getText();

        // Validar que no este vacio el dni
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el DNI del vocal de mesa", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNICandidato.setText("");
            txtDNICandidato.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (candidatoCrud.findCandidatoModel(Integer.parseInt(dni)) == null) {
            JOptionPane.showMessageDialog(this, "El candidato con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // se recupera el objeto para mostrarlo en los campos del formulario
        CandidatoModel candidato = candidatoCrud.findCandidatoModel(Integer.parseInt(dni));
        cmbPartidos.setSelectedItem(candidato.getPartido().getNombre());
        cmbComunaLocal.setSelectedItem(candidato.getComuna().getNombre());
        txtCategoriaCandidato.setText(candidato.getCategoria());

        // habilitar botones, y deshabilitar el boton agregar
        habilitarBotones(false, true, true, true);
    }//GEN-LAST:event_btnBuscarCandidatoActionPerformed

    private void btnModificarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCandidatoActionPerformed
        String dni = txtDNICandidato.getText();

        // Validar que no este vacio
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el dni del vocal de mesa", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNICandidato.setText("");
            txtDNICandidato.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (candidatoCrud.findCandidatoModel(Integer.parseInt(dni)) == null) {
            JOptionPane.showMessageDialog(this, "El candidato con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el combobox de partido no este vacio y luego obten el item elegido
        if(cmbPartidos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un partido", "ERROR", JOptionPane.ERROR_MESSAGE);
            cmbPartidos.requestFocus();
            return;
        }

        String partidoCandidato = cmbPartidos.getSelectedItem().toString();


        // Validar que no este vacio la comuna
        if (cmbComunaLocal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una comuna", "ERROR", JOptionPane.ERROR_MESSAGE);
            cmbComunaLocal.requestFocus();
            return;
        }

        String comunaCandidato = cmbComunaLocal.getSelectedItem().toString();

        
        String categoriaCandidato = txtCategoriaCandidato.getText();
        // Validar que no este vacio la categoria
        if (categoriaCandidato == null || categoriaCandidato.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite la categoria del candidato", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCategoriaCandidato.setText("");
            txtCategoriaCandidato.requestFocus();
            return;
        }

        // bucar ciudadano por DNI
        // Validar que el dni del ciudadano exista
        CiudadanoModelJpaController ciudadanoCrud = new CiudadanoModelJpaController(con);
        CiudadanoModel c = ciudadanoCrud.findCiudadanoModel(Integer.parseInt(dni));
        if (c == null) {
            JOptionPane.showMessageDialog(this, "El ciudadano con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // buscar partido por nombre
        // Validar que el partido exista
        PartidoModelJpaController partidoCrud = new PartidoModelJpaController(con);
        // buscar partido por nombre usando un for
        Integer idPartido = null;
        PartidoModel p = new PartidoModel();
        for (PartidoModel partido : partidoCrud.findPartidoModelEntities()) {
            if (partido.getNombre().equals(partidoCandidato)) {
                idPartido = partido.getId();
            }
        }
        if (p == null) {
            JOptionPane.showMessageDialog(this, "El partido con nombre: " + partidoCandidato + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PartidoModel partido = partidoCrud.findPartidoModel(idPartido);

        // buscar comuna por nombre
        // Validar que la comuna exista
        ComunaModelJpaController comunaCrud = new ComunaModelJpaController(con);
        ComunaModel cm = new ComunaModel();
        String idComuna = null;
        for (ComunaModel comuna : comunaCrud.findComunaModelEntities()) {
            if (comuna.getNombre().equals(comunaCandidato)) {
                idComuna = comuna.getId().toString();
            }
        }
        if (cm == null) {
            JOptionPane.showMessageDialog(this, "La comuna con nombre: " + comunaCandidato + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ComunaModel comuna = comunaCrud.findComunaModel(Integer.parseInt(idComuna));

        // Crear un objeto candidato
        CandidatoModel candidato = candidatoCrud.findCandidatoModel(Integer.parseInt(dni));
        candidato.setCiudadanoModel(c);
        candidato.setPartido(partido);
        candidato.setComuna(comuna);
        candidato.setCategoria(categoriaCandidato);

        try {
            candidatoCrud.edit(candidato);
            JOptionPane.showMessageDialog(this, "El candidato con DNI: " + dni + " se actualizo con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
            txtDNICandidato.setText("");
            txtCategoriaCandidato.setText("");
            cmbPartidos.setSelectedIndex(0);
            cmbComunaLocal.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnModificarCandidatoActionPerformed

    private void btnEliminarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCandidatoActionPerformed
        String dni = txtDNICandidato.getText();

        // Validar que no este vacio el DNI
        if (dni == null || dni.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el DNI del vocal de mesa", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDNICandidato.setText("");
            txtDNICandidato.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (candidatoCrud.findCandidatoModel(Integer.parseInt(dni)) == null) {
            JOptionPane.showMessageDialog(this, "El candidato con DNI: " + dni + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el cabdidato de mesa con DNI: " + dni + "?", "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                candidatoCrud.destroy(Integer.parseInt(dni));
                JOptionPane.showMessageDialog(this, "El candidato con DNI: " + dni + " se elimino con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
                txtDNICandidato.setText("");
                txtCategoriaCandidato.setText("");
                cmbPartidos.setSelectedIndex(0);
                cmbComunaLocal.setSelectedIndex(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarCandidatoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaCandidato dialog = new VentanaCandidato(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarCandidato;
    private javax.swing.JButton btnBuscarCandidato;
    private javax.swing.JButton btnEliminarCandidato;
    private javax.swing.JButton btnModificarCandidato;
    private javax.swing.JComboBox<String> cmbComunaLocal;
    private javax.swing.JComboBox<String> cmbPartidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCategoriaCandidato;
    private javax.swing.JTextField txtDNICandidato;
    // End of variables declaration//GEN-END:variables
}
