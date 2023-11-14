/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.casopractico1;

import Controller.DatosController;
import domain.Familiares;
import domain.Funcionarios;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JHON BENITEZ
 */
public class FormMain extends javax.swing.JFrame {

    private final DatosController datosController;
            
    private final static String[]COLUMNS = {"tipo_Id"," numero_Id", "nombre",
        " apellido"," estado_Civil", "sexo"," direccion",
        " telefono"," fecha_Nacimiento", "nvel_Estudio", "universidad"," titulo"};
    
    private final static String[]FILE ={"tipo_Id"," numero_Id"," nombre", "apellido",
        "estado_Civil"," sexo"," direccion",
        "telefono"," fecha_Nacimiento"," funcionario_id"};
    private final static String SELECCIONE = "--SELECCIONE--";
    
    
    
    public FormMain() {
        initComponents();
        
        datosController = new DatosController() ;
        listDatosFuncionarios();
         listDatosFamiliares();
         addListener();
    }
    private void listDatosFuncionarios() {
        
        
        cbxFuncionarios.removeAllItems();
        Funcionarios funcionario1 = new Funcionarios();
        funcionario1.setNombre(SELECCIONE);
        funcionario1.setApellido(" ");
        cbxFuncionarios.addItem(funcionario1);

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        tblFuncionarios.setModel(defaultTableModel);

        try {
            List<Funcionarios> funcionarios = datosController.odtenerFuncionarios();
            if(funcionarios.isEmpty()){
            return;
            }
              defaultTableModel.setRowCount(funcionarios.size());
              int row =0;
             for (Funcionarios funcionario : funcionarios) {
                
                defaultTableModel.setValueAt(funcionario.getTipoIdentificacion(), row, 0);
                defaultTableModel.setValueAt(funcionario.getNumeroIdentificacion(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNombre(), row, 2);
                defaultTableModel.setValueAt(funcionario.getApellido(), row, 3);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil(), row, 4);
                defaultTableModel.setValueAt(funcionario.getSexo(), row, 5);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 8);
                defaultTableModel.setValueAt(funcionario.getNivelEstudio(), row, 9);
                defaultTableModel.setValueAt(funcionario.getUniversidad(), row, 10);
                defaultTableModel.setValueAt(funcionario.getTitulo(), row, 11);
                row++;
                
             cbxFuncionarios.addItem(funcionario);
              
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
private void listDatosFamiliares() {
    cbxFamiliares.removeAllItems();
    cbxFamiliares.addItem(SELECCIONE);

    DefaultTableModel defaultTableModel = new DefaultTableModel();
    for (String FILES : FILE) {
        defaultTableModel.addColumn(FILES);
    }

    try {
        List<Familiares> familiares = datosController.odtenerFamiliares();
        if (familiares.isEmpty()) {
            return;
        }
        defaultTableModel.setRowCount(familiares.size());
        int row = 0;
        for (Familiares familiar : familiares) {
            defaultTableModel.setValueAt(familiar.getTipoIdentificacion(), row, 0);
            defaultTableModel.setValueAt(familiar.getNumeroIdentificacion(), row, 1);
            defaultTableModel.setValueAt(familiar.getNombre(), row, 2);
            defaultTableModel.setValueAt(familiar.getApellido(), row, 3);
            defaultTableModel.setValueAt(familiar.getEstadoCivil(), row, 4);
            defaultTableModel.setValueAt(familiar.getSexo(), row, 5);
            defaultTableModel.setValueAt(familiar.getTelefono(), row, 6);
            defaultTableModel.setValueAt(familiar.getDireccion(), row, 7);
            defaultTableModel.setValueAt(familiar.getFechaNacimiento(), row, 8);
            defaultTableModel.setValueAt(familiar.getFuncionario_id(), row, 9);
            row++;

            cbxFamiliares.addItem(familiar.toString()); // Add the string representation of the Familiar object
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
 private void addListener(){
     cbxFuncionarios.addItemListener(event -> {
     Funcionarios seledteFuncionarios = (Funcionarios)event.getItem();
     if(seledteFuncionarios.getNombre().equals(SELECCIONE)){
         txtIdFuncionario.setText("");
         txtFuncionarioId.setText("");
         txtTipoIdEdid.setText("");
         txtNombreEdid.setText("");
         txtApellidoEdid.setText("");
         txtEstadoCivilEdid.setText("");
         txtSexoEdid.setText("");
         txtTelefonoEdid.setText("");
         txtDireccionEdid.setText("");
         txtFechaNacimientoEdid.setText("");
         txtNivelDeEstudiosEdid.setText("");
         txtUniversidadEdid.setText("");
         txtTituloEdid.setText("");

     }else{
         txtIdFuncionario.setText(String.valueOf(seledteFuncionarios.getId()));
         txtFuncionarioId.setText(String.valueOf(seledteFuncionarios.getNumeroIdentificacion()));
         txtTipoIdEdid.setText(String.valueOf(seledteFuncionarios.getTipoIdentificacion()));
         txtNombreEdid.setText(String.valueOf(seledteFuncionarios.getNombre()));
         txtApellidoEdid.setText(String.valueOf(seledteFuncionarios.getApellido()));
         txtEstadoCivilEdid.setText(String.valueOf(seledteFuncionarios.getEstadoCivil()));
         txtSexoEdid.setText(String.valueOf(seledteFuncionarios.getSexo()));
         txtTelefonoEdid.setText(String.valueOf(seledteFuncionarios.getSexo()));
         txtDireccionEdid.setText(String.valueOf(seledteFuncionarios.getDireccion()));
         txtFechaNacimientoEdid.setText(String.valueOf(seledteFuncionarios.getFechaNacimiento()));
         txtNivelDeEstudiosEdid.setText(String.valueOf(seledteFuncionarios.getNivelEstudio()));
         txtUniversidadEdid.setText(String.valueOf(seledteFuncionarios.getUniversidad()));
         txtTituloEdid.setText(String.valueOf(seledteFuncionarios.getTitulo()));
     
     }
     
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTPActualizar = new javax.swing.JTabbedPane();
        jPFuncionarios = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTipoId = new javax.swing.JLabel();
        lblNumeroId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblUniversidad = new javax.swing.JLabel();
        lblNivelEstudio = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        txtTipoId = new javax.swing.JTextField();
        txtNumeroIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtEstadoCivil = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtUniversidad = new javax.swing.JTextField();
        txtNivelDeEstudio = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPActualizarFuncionarios = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblFuncionarioId = new javax.swing.JLabel();
        txtFuncionarioId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTipoIdEdid = new javax.swing.JTextField();
        txtNombreEdid = new javax.swing.JTextField();
        txtApellidoEdid = new javax.swing.JTextField();
        txtSexoEdid = new javax.swing.JTextField();
        txtEstadoCivilEdid = new javax.swing.JTextField();
        txtFechaNacimientoEdid = new javax.swing.JTextField();
        txtNivelDeEstudiosEdid = new javax.swing.JTextField();
        txtUniversidadEdid = new javax.swing.JTextField();
        txtTituloEdid = new javax.swing.JTextField();
        txtTelefonoEdid = new javax.swing.JTextField();
        txtDireccionEdid = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblFamiliares = new javax.swing.JLabel();
        cbxFamiliares = new javax.swing.JComboBox<>();
        txtIdFuncionario = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jPFamiliares = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTipoIdFamiliares = new javax.swing.JLabel();
        lblNumeroIdFamiliares = new javax.swing.JLabel();
        lblNombreFamiliares = new javax.swing.JLabel();
        lblDireccionFamiliares = new javax.swing.JLabel();
        lblApellidoFamiliares = new javax.swing.JLabel();
        lblSexoFamiliares = new javax.swing.JLabel();
        lblEstadoCivilFamiliares = new javax.swing.JLabel();
        lblFechaNaciminetFamiliares = new javax.swing.JLabel();
        lbTelefonoFamiliares = new javax.swing.JLabel();
        txtTipoIdFamiliares = new javax.swing.JTextField();
        txtNumeroIdFamiliares = new javax.swing.JTextField();
        txtNombreFamilares = new javax.swing.JTextField();
        txtApellidoFamiliares = new javax.swing.JTextField();
        txtSexoFamiliares = new javax.swing.JTextField();
        txtEstadoCivilFamiliares = new javax.swing.JTextField();
        txtFechaNaciminetoFamiliares = new javax.swing.JTextField();
        txtTelefonoFamiliares = new javax.swing.JTextField();
        txtDireccionFamiliares = new javax.swing.JTextField();
        btnCrearFamiliares = new javax.swing.JButton();
        lbldFuncionarioFamiliares = new javax.swing.JLabel();
        txtIdFuncionarioFamiliares = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ADMINISTRACION DE FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 260, -1));

        jPFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite Los Siguientes Campos"));

        lblTipoId.setText("T.IDENTIFICACION");

        lblNumeroId.setText("N.IDENTIFICACION");

        lblNombre.setText("NOMBRE");

        lblApellido.setText("APELLIDO");

        lblSexo.setText("SEXO");

        lblTelefono.setText("TELEFONO");

        lblDireccion.setText("DIRECCION");

        lblFechaNacimiento.setText("F.NACIMIENTO");

        lblTitulo.setText("TITULO");

        lblUniversidad.setText("UNIVERSIDAD");

        lblNivelEstudio.setText("NIVEL ESTUDIO");

        lblEstadoCivil.setText("E.CIVIL");

        btnCrear.setBackground(new java.awt.Color(204, 204, 255));
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoId)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTipoId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNumeroId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumeroIdentificacion)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(lblUniversidad)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(lblNombre))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(lblNivelEstudio))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCrear)
                                .addComponent(txtNivelDeEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellido)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtTitulo)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                            .addComponent(txtSexo)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSexo)
                                        .addGap(27, 27, 27)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(txtTelefono))
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblEstadoCivil)
                                        .addGap(36, 36, 36))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addGap(19, 19, 19))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblTitulo)
                        .addGap(62, 62, 62)
                        .addComponent(lblDireccion)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoId)
                            .addComponent(lblNumeroId)
                            .addComponent(lblNombre)
                            .addComponent(lblApellido)
                            .addComponent(lblSexo)
                            .addComponent(lblEstadoCivil))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUniversidad)
                                .addComponent(lblNivelEstudio))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDireccion)
                                .addComponent(lblTelefono))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNivelDeEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(btnCrear)
                .addGap(34, 34, 34))
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFuncionariosLayout = new javax.swing.GroupLayout(jPFuncionarios);
        jPFuncionarios.setLayout(jPFuncionariosLayout);
        jPFuncionariosLayout.setHorizontalGroup(
            jPFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionariosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPFuncionariosLayout.setVerticalGroup(
            jPFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPActualizar.addTab("CREAR FUNCIONARIOS", jPFuncionarios);

        jPActualizarFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique Los Siguientes Campos"));

        lblFuncionarios.setText("FUNCIONARIOS");

        cbxFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionariosActionPerformed(evt);
            }
        });

        lblFuncionarioId.setText("T.IDENTIFICACION");

        txtFuncionarioId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionarioIdActionPerformed(evt);
            }
        });

        jLabel2.setText("N.IDENTIFICACION");

        jLabel3.setText("NOMBRE");

        jLabel4.setText("APELLIDO");

        jLabel5.setText("SEXO");

        jLabel6.setText("E.CIVIL");

        jLabel7.setText("F.NACIMINETO");

        jLabel8.setText("N.ESTUDIOS");

        jLabel9.setText("UNIVERSIDAD");

        jLabel10.setText("TITULO");

        jLabel11.setText("TELEFONO");

        jLabel12.setText("DIRECCION");

        txtTipoIdEdid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoIdEdidActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblFamiliares.setText("FAMILIARES");

        txtIdFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdFuncionarioActionPerformed(evt);
            }
        });

        lblId.setText("ID");

        javax.swing.GroupLayout jPActualizarFuncionariosLayout = new javax.swing.GroupLayout(jPActualizarFuncionarios);
        jPActualizarFuncionarios.setLayout(jPActualizarFuncionariosLayout);
        jPActualizarFuncionariosLayout.setHorizontalGroup(
            jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtFechaNacimientoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFuncionarioId)
                                    .addComponent(lblId)))
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7)))
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtNivelDeEstudiosEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtUniversidadEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTituloEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(txtDireccionEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(145, 145, 145))))
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFuncionarios)
                                        .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel3)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtNombreEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(162, 162, 162)
                                .addComponent(jLabel12))
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel4)))
                                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSexoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEstadoCivilEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(28, 28, 28))))))
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(521, 521, 521)
                                .addComponent(lblFamiliares))
                            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtTipoIdEdid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(btnActualizar)
                .addGap(111, 111, 111)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPActualizarFuncionariosLayout.setVerticalGroup(
            jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFuncionarios)
                            .addComponent(lblFamiliares))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioId)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadoCivilEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)))
                    .addGroup(jPActualizarFuncionariosLayout.createSequentialGroup()
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoIdEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaNacimientoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNivelDeEstudiosEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUniversidadEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTituloEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefonoEdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(jPActualizarFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTPActualizar.addTab("ACTUALIZAR FUNCIONARIOS", jPActualizarFuncionarios);

        lblTipoIdFamiliares.setText("T.IDENTIFICACION");

        lblNumeroIdFamiliares.setText("N.IDENTIFICACION");

        lblNombreFamiliares.setText("NOMBRE");

        lblDireccionFamiliares.setText("DIRECCION");

        lblApellidoFamiliares.setText("APELLIDO");

        lblSexoFamiliares.setText("SEXO");

        lblEstadoCivilFamiliares.setText("E.CIVIL");

        lblFechaNaciminetFamiliares.setText("F.NACIMINETO");

        lbTelefonoFamiliares.setText("TELEFONO");

        txtFechaNaciminetoFamiliares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNaciminetoFamiliaresActionPerformed(evt);
            }
        });

        btnCrearFamiliares.setBackground(new java.awt.Color(204, 204, 255));
        btnCrearFamiliares.setText("CREAR");
        btnCrearFamiliares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFamiliaresActionPerformed(evt);
            }
        });

        lbldFuncionarioFamiliares.setBackground(new java.awt.Color(204, 204, 255));
        lbldFuncionarioFamiliares.setText("ID.FUNCIONARIO");

        txtIdFuncionarioFamiliares.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblSexoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(txtSexoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblEstadoCivilFamiliares)
                                .addGap(83, 83, 83)
                                .addComponent(lblFechaNaciminetFamiliares)
                                .addGap(63, 63, 63))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblTipoIdFamiliares)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNumeroIdFamiliares))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtTipoIdFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNumeroIdFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtEstadoCivilFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(txtFechaNaciminetoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTelefonoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTelefonoFamiliares)
                                .addGap(70, 70, 70)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombreFamiliares)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreFamilares, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblDireccionFamiliares)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDireccionFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtApellidoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblApellidoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(btnCrearFamiliares))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldFuncionarioFamiliares)
                            .addComponent(txtIdFuncionarioFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblApellidoFamiliares))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbldFuncionarioFamiliares)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreFamiliares, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumeroIdFamiliares, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTipoIdFamiliares, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtIdFuncionarioFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtApellidoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNumeroIdFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoIdFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTelefonoFamiliares)
                            .addComponent(lblFechaNaciminetFamiliares)
                            .addComponent(lblEstadoCivilFamiliares)
                            .addComponent(lblDireccionFamiliares)
                            .addComponent(lblSexoFamiliares))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaNaciminetoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadoCivilFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexoFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreFamilares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnCrearFamiliares)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPFamiliaresLayout = new javax.swing.GroupLayout(jPFamiliares);
        jPFamiliares.setLayout(jPFamiliaresLayout);
        jPFamiliaresLayout.setHorizontalGroup(
            jPFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFamiliaresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPFamiliaresLayout.setVerticalGroup(
            jPFamiliaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFamiliaresLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTPActualizar.addTab("CREAR FAMILIARES", jPFamiliares);

        getContentPane().add(jTPActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoIdEdidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoIdEdidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoIdEdidActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        try {
            if (txtTipoId.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el tipo de documento");
                txtTipoId.requestFocus();
                return;
            }
            if (txtNumeroIdentificacion.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el numero de documento");
                txtNumeroIdentificacion.requestFocus();
                return;
            }
            int numeroIdentificacion;
            try {
                numeroIdentificacion = Integer.parseInt(txtNumeroIdentificacion.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El numero de documento debe ser un entero");
                txtNumeroIdentificacion.requestFocus();
                return;
            }

            if (txtNombre.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el nombre");
                txtNombre.requestFocus();
                return;
            }
            if (txtApellido.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el apellido");
                txtApellido.requestFocus();
                return;
            }
            if (txtSexo.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el sexo");
                txtSexo.requestFocus();
                return;
            }
            if (txtEstadoCivil.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el estado civil");
                txtEstadoCivil.requestFocus();
                return;
            }
            if (txtFechaNacimiento.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la Fecha de nacimiento");
                txtFechaNacimiento.requestFocus();
                return;
            }
            if (txtUniversidad.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la universidad");
                txtUniversidad.requestFocus();
                return;
            }
            if (txtNivelDeEstudio.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el nivel de estudio");
                txtNivelDeEstudio.requestFocus();
                return;
            }
            if (txtTitulo.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el titulo");
                txtTitulo.requestFocus();
                return;
            }
            if (txtDireccion.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la direccion");
                txtDireccion.requestFocus();
                return;
            }
            if (txtTelefono.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el nombre");
                txtTelefono.requestFocus();
                return;
            }

            Funcionarios funcionari = new Funcionarios();
            funcionari.setTipoIdentificacion(txtTipoId.getText().trim());
            funcionari.setNumeroIdentificacion(numeroIdentificacion);
            funcionari.setNombre(txtNombre.getText().trim());
            funcionari.setApellido(txtApellido.getText().trim());
            funcionari.setEstadoCivil(txtEstadoCivil.getText().trim());
            funcionari.setSexo(txtSexo.getText().trim());
            funcionari.setFechaNacimiento(txtFechaNacimiento.getText().trim());
            funcionari.setNivelEstudio(txtNivelDeEstudio.getText().trim());
            funcionari.setTitulo(txtTitulo.getText().trim());
            funcionari.setUniversidad(txtUniversidad.getText().trim());
            funcionari.setDireccion(txtDireccion.getText().trim());
            funcionari.setTelefono(txtTelefono.getText().trim());

            datosController.crear(funcionari);
            txtTipoId.setText("");
            txtNumeroIdentificacion.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            txtEstadoCivil.setText("");
            txtSexo.setText("");
            txtTelefono.setText("");
            txtDireccion.setText("");
            txtFechaNacimiento.setText("");
            txtNivelDeEstudio.setText("");
            txtUniversidad.setText("");
            txtTitulo.setText("");
            listDatosFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con exito");

        } catch (SQLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "el funcionario no ha sido creado");

        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

      

            if (txtIdFuncionario.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el  ID del funcionario");
                txtIdFuncionario.requestFocus();
                return;
            }
              int IdFuncionario;
            try {
                IdFuncionario = Integer.parseInt(txtIdFuncionario.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El numero de documento debe ser un entero");
                txtIdFuncionario.requestFocus();
                return;
            }

            if (txtTipoIdEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el tipo de documento");
                txtTipoIdEdid.requestFocus();
                return;
            }
            if (txtFuncionarioId.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el numero de documento");
                txtFuncionarioId.requestFocus();
                return;
            }
            int numeroIdentificacion;
            try {
                numeroIdentificacion = Integer.parseInt(txtFuncionarioId.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El numero de documento debe ser un entero");
                txtFuncionarioId.requestFocus();
                return;
            }

            if (txtNombreEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el nombre");
                txtNombreEdid.requestFocus();
                return;
            }
            if (txtApellidoEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el apellido");
                txtApellidoEdid.requestFocus();
                return;
            }
            if (txtSexoEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el sexo");
                txtSexoEdid.requestFocus();
                return;
            }
            if (txtEstadoCivilEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el estado civil");
                txtEstadoCivilEdid.requestFocus();
                return;
            }
            if (txtFechaNacimientoEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la Fecha de nacimiento");
                txtFechaNacimientoEdid.requestFocus();
                return;
            }
            if (txtUniversidadEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la universidad");
                txtUniversidadEdid.requestFocus();
                return;
            }
            if (txtNivelDeEstudiosEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el nivel de estudio");
                txtNivelDeEstudiosEdid.requestFocus();
                return;
            }
            if (txtTituloEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el titulo");
                txtTituloEdid.requestFocus();
                return;
            }
            if (txtDireccionEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la direccion");
                txtDireccionEdid.requestFocus();
                return;
            }
            if (txtTelefonoEdid.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el nombre");
                txtTelefonoEdid.requestFocus();
                return;
            }
            
        
            Funcionarios funcionario = new Funcionarios();
            funcionario.setTipoIdentificacion(txtTipoIdEdid.getText().trim());
            funcionario.setNumeroIdentificacion(numeroIdentificacion);
            funcionario.setNombre(txtNombreEdid.getText().trim());
            funcionario.setApellido(txtApellidoEdid.getText().trim());
            funcionario.setEstadoCivil(txtEstadoCivilEdid.getText().trim());
            funcionario.setSexo(txtSexo.getText().trim());
            funcionario.setFechaNacimiento(txtFechaNacimientoEdid.getText().trim());
            funcionario.setNivelEstudio(txtNivelDeEstudiosEdid.getText().trim());
            funcionario.setTitulo(txtTituloEdid.getText().trim());
            funcionario.setUniversidad(txtUniversidadEdid.getText().trim());
        funcionario.setDireccion(txtDireccionEdid.getText().trim());
        funcionario.setTelefono(txtTelefonoEdid.getText().trim());

        int opt = JOptionPane.showConfirmDialog(null, "Desea ACtualizar el funcionario",
                "confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {

            try {
                datosController.actualizar( Integer.parseInt(txtIdFuncionario.getText()),funcionario);
                txtTipoIdEdid.setText("");
                txtIdFuncionario.setText("");
                txtNombreEdid.setText("");
                txtApellidoEdid.setText("");
                txtEstadoCivilEdid.setText("");
                txtSexoEdid.setText("");
                txtTelefonoEdid.setText("");
                txtDireccionEdid.setText("");
                txtFechaNacimientoEdid.setText("");
                txtNivelDeEstudiosEdid.setText("");
                txtUniversidadEdid.setText("");
                txtTituloEdid.setText("");
                listDatosFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario Actualizado con exito");

            } catch (SQLException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "el funcionario no ha sido Actualizado");

            }

        }


       


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCrearFamiliaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFamiliaresActionPerformed
        // TODO add your handling code here:
        
          try {
              
                 if(txtIdFuncionarioFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el numero de Id");
          txtIdFuncionarioFamiliares.requestFocus();
            return;
        }
        int funcionarioId;
        try {
            funcionarioId = Integer.parseInt(txtIdFuncionarioFamiliares.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"El numero del Id  debe ser un entero");
           txtIdFuncionarioFamiliares.requestFocus();
            return;
        }
        
        if(txtTipoIdFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el tipo de documento");
           txtTipoIdFamiliares.requestFocus();
            return;
        }
        if(txtNumeroIdFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el numero de documento");
           txtNumeroIdFamiliares.requestFocus();
            return;
        }
        int numeroIdentificacion;
        try {
            numeroIdentificacion = Integer.parseInt(txtNumeroIdFamiliares.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"El numero de documento debe ser un entero");
            txtNumeroIdFamiliares.requestFocus();
            return;
        }
        
        if(txtNombreFamilares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el nombre");
            txtNombreFamilares.requestFocus();
            return;
        }
        if(txtApellidoFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el apellido");
            txtApellidoFamiliares.requestFocus();
            return;
        }
        if(txtSexoFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el sexo");
            txtSexoFamiliares.requestFocus();
            return;
        }
        if(txtEstadoCivilFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el estado civil");
           txtEstadoCivilFamiliares.requestFocus();
            return;
        }
        if(txtFechaNaciminetoFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite la Fecha de nacimiento");
           txtFechaNaciminetoFamiliares.requestFocus();
            return;
        }
   
        if(txtDireccionFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite la direccion");
            txtDireccionFamiliares.requestFocus();
            return;
        }
        if(txtTelefonoFamiliares.getText().trim().length()==0){
            JOptionPane.showMessageDialog(null,"Digite el nombre");
            txtTelefonoFamiliares.requestFocus();
            return;
        }

        Familiares familiar = new Familiares();
        familiar.setFuncionario_id(funcionarioId);
        familiar.setTipoIdentificacion(txtTipoIdFamiliares.getText().trim());
        familiar.setNumeroIdentificacion(numeroIdentificacion);
        familiar.setNombre(txtNombreFamilares.getText().trim());
        familiar.setApellido(txtApellidoFamiliares.getText().trim());
        familiar.setEstadoCivil(txtEstadoCivilFamiliares.getText().trim());
        familiar.setSexo(txtSexo.getText().trim());
        familiar.setFechaNacimiento(txtFechaNaciminetoFamiliares.getText().trim());
        familiar.setDireccion(txtDireccionFamiliares.getText().trim());
        familiar.setTelefono(txtTelefonoFamiliares.getText().trim());

              datosController.crearFamiliar(familiar);
              txtIdFuncionarioFamiliares.setText("");
              txtTipoIdFamiliares.setText("");
              txtNumeroIdFamiliares.setText("");
              txtNombreFamilares.setText("");
              txtApellidoFamiliares.setText("");
              txtSexoFamiliares.setText("");
              txtEstadoCivilFamiliares.setText("");
              txtFechaNaciminetoFamiliares.setText("");
              txtDireccionFamiliares.setText("");
              txtTelefonoFamiliares.setText("");

              listDatosFamiliares();
              JOptionPane.showMessageDialog(null, "Familiar creado con exito");


         
    } catch (SQLException ex) {
        Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null,"el familiar no ha sido creado");

    }
        
    
    }//GEN-LAST:event_btnCrearFamiliaresActionPerformed

    private void txtFechaNaciminetoFamiliaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNaciminetoFamiliaresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNaciminetoFamiliaresActionPerformed

    private void txtIdFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdFuncionarioActionPerformed

    private void cbxFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFuncionariosActionPerformed

    private void txtFuncionarioIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncionarioIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncionarioIdActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

     if (txtIdFuncionario.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el  ID del funcionario");
                txtIdFuncionario.requestFocus();
                return;
            }   
        
        int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el funcionario?",
                "confirmar salida",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {

            try {
                datosController.eliminar(Integer.parseInt(txtIdFuncionario.getText()));
                txtTipoIdEdid.setText("");
                txtIdFuncionario.setText("");
                txtNombreEdid.setText("");
                txtApellidoEdid.setText("");
                txtEstadoCivilEdid.setText("");
                txtSexoEdid.setText("");
                txtTelefonoEdid.setText("");
                txtDireccionEdid.setText("");
                txtFechaNacimientoEdid.setText("");
                txtNivelDeEstudiosEdid.setText("");
                txtUniversidadEdid.setText("");
                txtTituloEdid.setText("");
                listDatosFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario Eliminado con exito");

            } catch (SQLException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "el funcionario no ha sido Eliminado");

            }

        }

 
        
        
        
        
        
     

    }//GEN-LAST:event_btnEliminarActionPerformed

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
                if ("window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearFamiliares;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxFamiliares;
    private javax.swing.JComboBox<Funcionarios> cbxFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPActualizarFuncionarios;
    private javax.swing.JPanel jPFamiliares;
    private javax.swing.JPanel jPFuncionarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTPActualizar;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbTelefonoFamiliares;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoFamiliares;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionFamiliares;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivilFamiliares;
    private javax.swing.JLabel lblFamiliares;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaNaciminetFamiliares;
    private javax.swing.JLabel lblFuncionarioId;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNivelEstudio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreFamiliares;
    private javax.swing.JLabel lblNumeroId;
    private javax.swing.JLabel lblNumeroIdFamiliares;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoFamiliares;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoId;
    private javax.swing.JLabel lblTipoIdFamiliares;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUniversidad;
    private javax.swing.JLabel lbldFuncionarioFamiliares;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEdid;
    private javax.swing.JTextField txtApellidoFamiliares;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdid;
    private javax.swing.JTextField txtDireccionFamiliares;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtEstadoCivilEdid;
    private javax.swing.JTextField txtEstadoCivilFamiliares;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoEdid;
    private javax.swing.JTextField txtFechaNaciminetoFamiliares;
    private javax.swing.JTextField txtFuncionarioId;
    private javax.swing.JTextField txtIdFuncionario;
    private javax.swing.JTextField txtIdFuncionarioFamiliares;
    private javax.swing.JTextField txtNivelDeEstudio;
    private javax.swing.JTextField txtNivelDeEstudiosEdid;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEdid;
    private javax.swing.JTextField txtNombreFamilares;
    private javax.swing.JTextField txtNumeroIdFamiliares;
    private javax.swing.JTextField txtNumeroIdentificacion;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdid;
    private javax.swing.JTextField txtSexoFamiliares;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdid;
    private javax.swing.JTextField txtTelefonoFamiliares;
    private javax.swing.JTextField txtTipoId;
    private javax.swing.JTextField txtTipoIdEdid;
    private javax.swing.JTextField txtTipoIdFamiliares;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTituloEdid;
    private javax.swing.JTextField txtUniversidad;
    private javax.swing.JTextField txtUniversidadEdid;
    // End of variables declaration//GEN-END:variables
}
