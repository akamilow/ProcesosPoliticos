package co.edu.ude.poo.procesospoliticos.vistas.gui;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.VotoModel;
import co.edu.ude.poo.procesospoliticos.modelo.crud.VotoModelJpaController;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CandidatoModelJpaController;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CiudadanoModelJpaController;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
import co.edu.ude.poo.procesospoliticos.modelo.crud.MesavotacionModelJpaController;

import java.awt.Toolkit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.JOptionPane;

/**
 * @author camilo castellar
 */
public class VentanaVoto extends javax.swing.JDialog {
    
    EntityManagerFactory con = Persistence.createEntityManagerFactory("ProcesosPoliticosPU");
    VotoModelJpaController votoCrud = new VotoModelJpaController(con);
    
    public VentanaVoto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarMesas();
        cargarCandidatos();
        cargarCiudadanos();
    }
    
    // Metodo para habilitar botones
    public void habilitarBotones(boolean agregar, boolean buscar, boolean modificar, boolean eliminar) {
        btnAgregarVoto.setEnabled(agregar);
        btnBuscarVoto.setEnabled(buscar);
        btnModificarVoto.setEnabled(modificar);
        btnEliminarVoto.setEnabled(eliminar);
    }

    public void cargarMesas() {
        
        MesavotacionModelJpaController mesavotacionCrud = new MesavotacionModelJpaController(con);
        MesavotacionModel mesavotacionModel = new MesavotacionModel();

        cmbMesa.removeAllItems();
        cmbMesa.addItem("Seleccione una mesa");
        for (MesavotacionModel m : mesavotacionCrud.findMesavotacionModelEntities()) {
            cmbMesa.addItem(m.getNumero().toString());
        }

        cmbMesa.setSelectedIndex(0);
    }

    public void cargarCandidatos() {
        
        CandidatoModelJpaController candidatoCrud = new CandidatoModelJpaController(con);
        CandidatoModel candidatoModel = new CandidatoModel();

        cmbCandidato.removeAllItems();
        cmbCandidato.addItem("Seleccione un candidato");
        for (CandidatoModel c : candidatoCrud.findCandidatoModelEntities()) {
            cmbCandidato.addItem(c.getCiudadanoModel().getNombre());
        }

        cmbCandidato.setSelectedIndex(0);
    }

    public void cargarCiudadanos() {
        
        CiudadanoModelJpaController ciudadanoCrud = new CiudadanoModelJpaController(con);
        CiudadanoModel ciudadanoModel = new CiudadanoModel();

        cmbCiudadano.removeAllItems();
        cmbCiudadano.addItem("Seleccione un ciudadano");
        for (CiudadanoModel c : ciudadanoCrud.findCiudadanoModelEntities()) {
            cmbCiudadano.addItem(c.getNombre());
        }

        cmbCiudadano.setSelectedIndex(0);
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
        txtIDVoto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbMesa = new javax.swing.JComboBox<>();
        cmbCandidato = new javax.swing.JComboBox<>();
        cmbCiudadano = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarVoto = new javax.swing.JButton();
        btnBuscarVoto = new javax.swing.JButton();
        btnModificarVoto = new javax.swing.JButton();
        btnEliminarVoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procesos Politícos - Gestión de Comunas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de voto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID:");

        txtIDVoto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtIDVoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDVotoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Número de mesa");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Candidato:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ciudadano:");

        cmbMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCandidato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCiudadano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCiudadano, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDVoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCiudadano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3});

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO PARA GESTIONAR VOTOS");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/Election-Box.png"))); // NOI18N

        btnAgregarVoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/add-icon.png"))); // NOI18N
        btnAgregarVoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnAgregarVoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVotoActionPerformed(evt);
            }
        });

        btnBuscarVoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/search-icon.png"))); // NOI18N
        btnBuscarVoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscarVoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVotoActionPerformed(evt);
            }
        });

        btnModificarVoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/edit-icon.png"))); // NOI18N
        btnModificarVoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnModificarVoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVotoActionPerformed(evt);
            }
        });

        btnEliminarVoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/ude/poo/procesospoliticos/vistas/iconos/delete-icon.png"))); // NOI18N
        btnEliminarVoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminarVoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVotoActionPerformed(evt);
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
                        .addComponent(btnEliminarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
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
                    .addComponent(btnAgregarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarVotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVotoActionPerformed
        // Datos de formulario
        String id = txtIDVoto.getText();

        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del voto", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDVoto.setText("");
            txtIDVoto.requestFocus();
            return;
        }

        // validar que el combobox de mesas no este vacio
        if (cmbMesa.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una mesa de votación", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String numeroMesa = cmbMesa.getSelectedItem().toString();

        // validar que el combobox de candidatos no este vacio
        if (cmbCandidato.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un candidato", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCandidato = cmbCandidato.getSelectedItem().toString();

        // validar que el combobox de ciudadanos no este vacio
        if (cmbCiudadano.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un ciudadano", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCiudadano = cmbCiudadano.getSelectedItem().toString();

        MesavotacionModelJpaController mesaCrud = new MesavotacionModelJpaController(con);
        Integer idMesa = null;
        MesavotacionModel m = new MesavotacionModel();
        for (MesavotacionModel mesa : mesaCrud.findMesavotacionModelEntities()) {
            if (mesa.getNumero().toString().equals(numeroMesa)) {
                idMesa = mesa.getNumero();
                m = mesa;
            }
        }
        if (m == null) {
            JOptionPane.showMessageDialog(this, "La mesa de votación seleccionada no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MesavotacionModel mesa = mesaCrud.findMesavotacionModel(idMesa);

        CandidatoModelJpaController candidatoCrud = new CandidatoModelJpaController(con);
        Integer idCandidato = null;
        CandidatoModel c = new CandidatoModel();
        for (CandidatoModel candidato : candidatoCrud.findCandidatoModelEntities()) {
            if (candidato.getCiudadanoModel().getNombre().equals(nombreCandidato)) {
                idCandidato = candidato.getDni();
                c = candidato;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(this, "El candidato seleccionado no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CandidatoModel candidato = candidatoCrud.findCandidatoModel(idCandidato);

        CiudadanoModelJpaController ciudadanoCrud = new CiudadanoModelJpaController(con);
        Integer idCiudadano = null;
        CiudadanoModel ci = new CiudadanoModel();
        for (CiudadanoModel ciudadano : ciudadanoCrud.findCiudadanoModelEntities()) {
            if (ciudadano.getNombre().equals(nombreCiudadano)) {
                idCiudadano = ciudadano.getDni();
                ci = ciudadano;
            }
        }
        if (ci == null) {
            JOptionPane.showMessageDialog(this, "El ciudadano seleccionado no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CiudadanoModel ciudadano = ciudadanoCrud.findCiudadanoModel(idCiudadano);

        VotoModel voto = new VotoModel();
        voto.setId(Integer.parseInt(id));
        voto.setMesa(mesa);
        voto.setCandidato(candidato);
        voto.setCiudadano(ciudadano);
        
        try {
            votoCrud.create(voto);
            JOptionPane.showMessageDialog(this, "El voto con ID: " + id + " se agrego con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
            txtIDVoto.setText("");
            cmbMesa.setSelectedIndex(0);
            cmbCandidato.setSelectedIndex(0);
            cmbCiudadano.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarVotoActionPerformed

    private void txtIDVotoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDVotoKeyTyped
        // validar que el ID sea Integer
        char tecla = evt.getKeyChar();
        if(!Character.isDigit(tecla)) { 
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIDVotoKeyTyped

    private void btnBuscarVotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVotoActionPerformed
        String id = txtIDVoto.getText();

        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id de la comuna", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDVoto.setText("");
            txtIDVoto.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (votoCrud.findVotoModel(Integer.parseInt(id)) == null) {
            JOptionPane.showMessageDialog(this, "El voto con ID: " + id + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //recupera el objeto para mostrarlo en los campos del formulario
        VotoModel voto = votoCrud.findVotoModel(Integer.parseInt(id));
        txtIDVoto.setText(voto.getId().toString());
        cmbMesa.setSelectedItem(voto.getMesa().getNumero().toString());
        cmbCandidato.setSelectedItem(voto.getCandidato().getCiudadanoModel().getNombre());
        cmbCiudadano.setSelectedItem(voto.getCiudadano().getNombre());

        // habilitar botones, y deshabilitar el boton agregar
        habilitarBotones(false, true, true, true);
    }//GEN-LAST:event_btnBuscarVotoActionPerformed

    private void btnModificarVotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVotoActionPerformed
        String id = txtIDVoto.getText();

        // Validar que no este vacio
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del voto", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDVoto.setText("");
            txtIDVoto.requestFocus();
            return;
        }

        // validar que el combobox de mesas no este vacio
        if (cmbMesa.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una mesa de votación", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String numeroMesa = cmbMesa.getSelectedItem().toString();

        // validar que el combobox de candidatos no este vacio
        if (cmbCandidato.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un candidato", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCandidato = cmbCandidato.getSelectedItem().toString();

        // validar que el combobox de ciudadanos no este vacio
        if (cmbCiudadano.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un ciudadano", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCiudadano = cmbCiudadano.getSelectedItem().toString();

        MesavotacionModelJpaController mesaCrud = new MesavotacionModelJpaController(con);
        Integer idMesa = null;
        MesavotacionModel m = new MesavotacionModel();
        for (MesavotacionModel mesa : mesaCrud.findMesavotacionModelEntities()) {
            if (mesa.getNumero().toString().equals(numeroMesa)) {
                idMesa = mesa.getNumero();
                m = mesa;
            }
        }
        if (m == null) {
            JOptionPane.showMessageDialog(this, "La mesa de votación seleccionada no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MesavotacionModel mesa = mesaCrud.findMesavotacionModel(idMesa);

        CandidatoModelJpaController candidatoCrud = new CandidatoModelJpaController(con);
        Integer idCandidato = null;
        CandidatoModel c = new CandidatoModel();
        for (CandidatoModel candidato : candidatoCrud.findCandidatoModelEntities()) {
            if (candidato.getCiudadanoModel().getNombre().equals(nombreCandidato)) {
                idCandidato = candidato.getDni();
                c = candidato;
            }
        }
        if (c == null) {
            JOptionPane.showMessageDialog(this, "El candidato seleccionado no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CandidatoModel candidato = candidatoCrud.findCandidatoModel(idCandidato);

        CiudadanoModelJpaController ciudadanoCrud = new CiudadanoModelJpaController(con);
        Integer idCiudadano = null;
        CiudadanoModel ci = new CiudadanoModel();
        for (CiudadanoModel ciudadano : ciudadanoCrud.findCiudadanoModelEntities()) {
            if (ciudadano.getNombre().equals(nombreCiudadano)) {
                idCiudadano = ciudadano.getDni();
                ci = ciudadano;
            }
        }
        if (ci == null) {
            JOptionPane.showMessageDialog(this, "El ciudadano seleccionado no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CiudadanoModel ciudadano = ciudadanoCrud.findCiudadanoModel(idCiudadano);

        VotoModel voto = votoCrud.findVotoModel(Integer.parseInt(id));
        voto.setMesa(mesa);
        voto.setCandidato(candidato);
        voto.setCiudadano(ciudadano);

        try {
            votoCrud.edit(voto);
            JOptionPane.showMessageDialog(this, "El voto con ID: " + id + " se modifico con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
            txtIDVoto.setText("");
            cmbMesa.setSelectedIndex(0);
            cmbCandidato.setSelectedIndex(0);
            cmbCiudadano.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnModificarVotoActionPerformed

    private void btnEliminarVotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVotoActionPerformed
        String id = txtIDVoto.getText();

        // Validar que no este vacio
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite el id del voto", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtIDVoto.setText("");
            txtIDVoto.requestFocus();
            return;
        }

        // validar que el contenga la llave a buscar
        if (votoCrud.findVotoModel(Integer.parseInt(id)) == null) {
            JOptionPane.showMessageDialog(this, "El voto con ID: " + id + " no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Mensaje de confirmacion
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el voto con ID: " + id + "?", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            try {
                votoCrud.destroy(Integer.parseInt(id));
                JOptionPane.showMessageDialog(this, "El voto con ID: " + id + " se elimino con éxito", "RESULTADO", JOptionPane.WARNING_MESSAGE);
                txtIDVoto.setText("");
                cmbMesa.setSelectedIndex(0);
                cmbCandidato.setSelectedIndex(0);
                cmbCiudadano.setSelectedIndex(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarVotoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaVoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaVoto dialog = new VentanaVoto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarVoto;
    private javax.swing.JButton btnBuscarVoto;
    private javax.swing.JButton btnEliminarVoto;
    private javax.swing.JButton btnModificarVoto;
    private javax.swing.JComboBox<String> cmbCandidato;
    private javax.swing.JComboBox<String> cmbCiudadano;
    private javax.swing.JComboBox<String> cmbMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIDVoto;
    // End of variables declaration//GEN-END:variables
}
