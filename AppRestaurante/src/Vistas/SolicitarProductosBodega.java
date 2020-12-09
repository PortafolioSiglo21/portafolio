/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Pedido_ProvedorDO;
import Modelo.Conexion;
import Modelo.Pedido_Provedor;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuel
 */
public class SolicitarProductosBodega extends javax.swing.JFrame {
    String user, nombre_usuario, hola;
    public static int sesion_usuario;
    DefaultTableModel tabla = new DefaultTableModel();
    DefaultTableModel model;

    /**
     * Creates new form SolicitarProductosBodega
     */
    private final Pedido_ProvedorDO ppdo = new Pedido_ProvedorDO();
    
    public SolicitarProductosBodega() throws SQLException {
        initComponents();
        
        setSize(794, 632);
        setResizable(false);
        setTitle("Solicitud Insumos");
        setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/Img/orange-gradient-wallpaper-4422.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel1.getWidth(), 
        jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icono);
        this.repaint();
        
        //*Usuario
        user =Login.user;
        sesion_usuario = 1;
        setTitle("Bodega- sesion actual : "+ user);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //*Iva-Impuesto al Valor Agregado en chile
        double g = 0.19;
        txtIva.setText(Double.toString(g));
        txtIva.setBackground(Color.green);
        
        //*Llenado +1 de idpedido
        getMaxIDPedido();
        LlenadoIdEmpleado();
        LLenadoCategoria();
        LlenadoProveActivos();
        desabilitarfechas();
        //listarProdu();
    }
    ///***
    //Fin Constructor
    //***
    
    public void desabilitarfechas(){
        //dcfecha.setMaxSelectableDate(new Date());
        dcfecha.setMinSelectableDate(new Date());
        dcFechaRecepcion.setMinSelectableDate(new Date()); 
    }
    
    public void LlenadoProveActivos(){
        //////llenado cb provedores activos
        this.cbProveActivos.removeAllItems();
        try {
            Connection con = Conexion.getConnection();
            //PreparedStatement pst = null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PROVEEDORES WHERE ESTADO_PROVEDOR = 'ACTIVO'");
            while (rs.next()) {
                this.cbProveActivos.addItem(rs.getString("PROVEEDOR"));
            }
        } catch (Exception e) {
            System.err.println("Error de llenado ComboBox Desde BD " +  e);
        }
    }
    
    public void LLenadoCategoria(){
        ////LLENADO CATEGORIA CB
        this.cbCategoriasP.removeAllItems();
        try {
            Connection con = Conexion.getConnection();
            //PreparedStatement pst = null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CATEGORIAS");
            while (rs.next()) {
                this.cbCategoriasP.addItem(rs.getString("CATEGORIA"));
            }
        } catch (Exception e) {
            System.err.println("Error de llenado ComboBox Desde BD " +  e);
        }
    }
    
    /////Llenado Id_empleado
    public void LlenadoIdEmpleado(){
        try {
            Connection con = Conexion.getConnection();
                 PreparedStatement pst = con.prepareStatement(
                 "SELECT ID_EMPLEADO FROM EMPLEADOS WHERE USUARIO = '" + user + "'");
                 ResultSet rs = pst.executeQuery();
                 if(rs.next()){
                    int ID_EMPLEADO = rs.getInt("ID_EMPLEADO");
                    txtIDEmpleado.setText(Integer.toString(ID_EMPLEADO));
                    txtIDEmpleado.setBackground(Color.YELLOW);
                }else{
                     System.err.println("Error de captura del ID EMPLEADO");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo capturar el ID DEL eMPLEADO " + e);
        }
    }
    
    ///Impuesto al Valor Agregado en chile
    public void ivaPro(){
        try {
            String iva = txtIva.getText();
            String precio = txtPrecio.getText();
            int x3 = Integer.parseInt(txtCantidadProd.getText());
            double x1 = Double.parseDouble(iva);
            double x2 = Double.parseDouble(precio);
            double total = (x2*x1) + x2 * x3;
            txtTotal.setText(Double.toString(Math.round(total)));   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conversion del IVA " + e);
        }  
    }
    
    public void getMaxIDPedido(){
       txtIdProdu.setText(ppdo.getMaxIDPedido()+"");
    }
    public void limpiar(){
        txtCantidadProd.setText("");
        txtDescrProd.setText("");
        //txtIdProdu.setText("");
        //txtIva.setText("");
        txtNombreProd.setText("");
        txtPrecio.setText("");
        txtTotal.setText(""); 
    }
    
    public void listarProdu() throws SQLException{
      ppdo.listarProductos(jTable1);
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
        txtNombreProd = new javax.swing.JTextField();
        txtCantidadProd = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDescrProd = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtIDEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbCategoriasP = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        dcfecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIdProdu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        cbProveActivos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnSolicitar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtIdProvedorAct = new javax.swing.JTextField();
        dcFechaRecepcion = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1_salir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingreso Insumos"));

        txtCantidadProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProdKeyTyped(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtDescrProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescrProdKeyTyped(evt);
            }
        });

        txtIva.setEditable(false);

        jLabel3.setText("prod :");

        jLabel4.setText("Descr :");

        jLabel5.setText("Precio");

        jLabel6.setText("IVA");

        jLabel7.setText("ID/EMP");

        jLabel9.setText("Categoria :");

        jLabel10.setText("Fecha Solic :");

        jLabel8.setText("Canti.");

        jLabel11.setText("Total");

        jLabel12.setText("ID/PED");

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        cbProveActivos.setBackground(new java.awt.Color(255, 102, 0));
        cbProveActivos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbProveActivos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbProveActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveActivosActionPerformed(evt);
            }
        });

        jLabel2.setText("Provedor Activos en Sistema :");

        btnSolicitar.setBackground(new java.awt.Color(255, 102, 0));
        btnSolicitar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        btnSolicitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/product.png"))); // NOI18N
        btnSolicitar.setText("Solicitar");
        btnSolicitar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporte.png"))); // NOI18N
        jButton1.setText("Factura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProd, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtDescrProd)
                            .addComponent(txtPrecio)
                            .addComponent(txtIdProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadProd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dcFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbProveActivos, 0, 162, Short.MAX_VALUE)
                            .addComponent(txtIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoriasP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 110, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSolicitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdProvedorAct, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbCategoriasP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDescrProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(txtCantidadProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbProveActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProvedorAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdProdu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dcFechaRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(81, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 760, 290));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 760, 130));

        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 610));

        jMenu1_salir.setText("Opciones");

        jMenuItem1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem1.setText("Cerrar Ventana");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1_salir.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jMenuItem2.setText("Salir Sistema");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1_salir.add(jMenuItem2);

        jMenuBar1.add(jMenu1_salir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas Volver al menu De bodega?, "
                + "Recuerda Guardar tus Cambios", 
                  " Salir ",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0){                       
                IncioBodeguero ib = new IncioBodeguero();
                ib.setVisible(true);
                dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas Salir del Sistema?, "
                + "Recuerda Guardar tus Cambios", 
                  " Salir ",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0){                       
              System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        if(txtPrecio.getText().equals("")){
            txtTotal.setText("");
        }else{
            ivaPro();
        }
        
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed

        if(txtNombreProd.getText().isEmpty() || txtDescrProd.getText().isEmpty()
            || txtCantidadProd.getText().isEmpty()
            || txtTotal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos Vacios");
        }else{
            Pedido_Provedor p = new Pedido_Provedor();
            p.setID_PEDIDO(Integer.parseInt(txtIdProdu.getText()));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY HH:mm"); //DD-MON-YYYY HH:MI
            String fecha = sdf.format(dcfecha.getDate());
            String fecha1 = sdf.format(dcFechaRecepcion.getDate());
            
            p.setFECH_SOLICITUD(fecha);
            p.setIVA(Double.parseDouble(txtIva.getText()));
            p.setTOTAL_PAGAR(Double.parseDouble(txtTotal.getText()));
            p.setID_PROVEEDOR(Integer.parseInt(txtIdProvedorAct.getText()));
            p.setID_EMPLEADO(Integer.parseInt(txtIDEmpleado.getText()));
            p.setPRODUCTO(txtNombreProd.getText());
            p.setCATEGORIA(cbCategoriasP.getSelectedItem().toString());
            p.setDESCRIPCION(txtDescrProd.getText());
            p.setCANTIDAD(Integer.parseInt(txtCantidadProd.getText()));
            p.setFECH_RECEPCION(fecha1);
            p.setFECH_PAGO(fecha1);
            p.setFECH_PEDIDO(fecha1);
            
            String estado= "SOLICITADO";
            p.setESTADO_PEDIDO(estado);
            
            p.setPRECIO(Double.parseDouble(txtPrecio.getText()));
            
            JOptionPane.showMessageDialog(null, "Guardado de pedido exitoso");
            String mensaje = ppdo.AgregarPedido(p);
            limpiar();
            try {
                listarProdu();
            } catch (Exception e) {
                
            }
        }
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas Borrar tus Pedidos?, "
            + "Recuerda que esto es definitivo",
            " Borrado de solicitudes ",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
        if (pregunta == 0){
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            limpiar();
        }
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void cbProveActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveActivosActionPerformed
        ///***LLENADO ID DE PROVEDOR DESDE COMBOBOX
        try {
            Connection con = Conexion.getConnection();
            //PreparedStatement pst = null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PROVEEDORES WHERE PROVEEDOR ='"+ this.cbProveActivos.getSelectedItem()+"'");
            //tring sql = ("SELECT * FROM CATEGORIAS WHERE CATEGORIA ='"+ this.cbCategoria.getSelectedItem()+"'");
            rs.next();
            this.txtIdProvedorAct.setText(String.valueOf(rs.getInt("ID_PROVEEDOR")));
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_cbProveActivosActionPerformed

    //**Eventos de Restriccion en campos de texto (Solo letrtas)
    private void txtDescrProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescrProdKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            txtDescrProd.setText("");
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo Letras");
        }
    }//GEN-LAST:event_txtDescrProdKeyTyped

    //**Eventos de Restriccion en campos de texto (Solo numeros)
    private void txtCantidadProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProdKeyTyped
        char validar= evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            txtCantidadProd.setText("");
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtCantidadProdKeyTyped

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cbCategoriasP;
    private javax.swing.JComboBox<String> cbProveActivos;
    private com.toedter.calendar.JDateChooser dcFechaRecepcion;
    private com.toedter.calendar.JDateChooser dcfecha;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JMenu jMenu1_salir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCantidadProd;
    private javax.swing.JTextField txtDescrProd;
    private javax.swing.JTextField txtIDEmpleado;
    private javax.swing.JTextField txtIdProdu;
    private javax.swing.JTextField txtIdProvedorAct;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombreProd;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
