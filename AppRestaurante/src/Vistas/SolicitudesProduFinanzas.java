/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Pedido_ProvedorDO;
import Controlador.ProductosDO;
import Modelo.Conexion;
import Modelo.Productos;
import Modelo.ProductosDAO;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuel
 */
public class SolicitudesProduFinanzas extends javax.swing.JFrame {
    String user, nombre_usuario, hola ;
    public static int sesion_usuario;
    DefaultTableModel tabla = new DefaultTableModel();
    DefaultTableModel model;
    
    ProductosDAO proddao = new ProductosDAO();
    private ProductosDO prodo = new ProductosDO();

    /**
     * Creates new form SolicitudesProduAdmin
     */
    private Pedido_ProvedorDO ppdo = new Pedido_ProvedorDO();
    
    public SolicitudesProduFinanzas() throws SQLException {
        initComponents();
        setSize(888, 500);
        setResizable(false);
        setTitle("Ganancias");
        setLocationRelativeTo(null);
        //***
        ImageIcon wallpaper = new ImageIcon("src/Img/orange-gradient-wallpaper-4422.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel14.getWidth(), 
        jLabel14.getHeight(), Image.SCALE_DEFAULT));
        jLabel14.setIcon(icono);
        this.repaint();
        
        user =Login.user;
        sesion_usuario = 1;
        setTitle("Ganancias - sesion actual : "+ user);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        listarPedido();
        idMax();
        contador();
       
    }
     //**Lista los pedidos desde bodega hacia el perfil admin
    public void listarPedido() throws SQLException{
      //ppdo.listarProductos(jTable1);
      ppdo.listarPedido(jTable1);
    }
    public void idMax(){
      jLabel_idpro.setText(prodo.getMaxIDProductos()+"");
    }

    public void contador(){
        int filas = jTable1.getRowCount();
        jLabel_cuenta.setText(filas + "");
    }
    
    public void ActualizarEstado(){
        //////llenado cb provedores activos
        //this.cbProveActivos.removeAllItems();
        try {
            Connection con = Conexion.getConnection();
            int id= Integer.parseInt(jlabel_idpedido.getText());
            
            Date ahora = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY HH:mm"); //DD-MON-YYYY HH:MI
            String fecha = sdf.format(ahora);
            
            String query = "UPDATE PEDIDOPROVEDOR SET ESTADO_PEDIDO='PAGADO', FECH_PAGO=to_date(? ,'DD-MON-YYYY HH24:MI') WHERE ID_PEDIDO=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fecha);
            ps.setInt(2, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println("Error de llenado " +  e);
        }
    }
    
    public void Mail(){
      // Recipient's email ID needs to be mentioned.
      String to = jLabel14_mail.getText();
      // Sender's email ID needs to be mentioned
      String from = "siglo21.portafolio@gmail.com";
      final String username = "siglo21.portafolio";//change accordingly
      final String password = "tblukazkhciauiox";//change accordingly
      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");
      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
	});
      try {
            // Create a default MimeMessage object.
           Message message = new MimeMessage(session);
   	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(to));
	   // Set Subject: header field
	   message.setSubject("Solicitud de Envio de : " + user + " Desde Siglo XX1 Restaurante ");
	   // Send the actual HTML message, as big as you like
	   /*message.setContent(
              "<h2 style=\"background-color:Tomato;\">Solicitud de Envio</h2>"
                      + "<br><p style=\"color:black;\">El producto Solicitado es : " + txtDescripcion.getText().toUpperCase() + "</p>"
                      + " <p style=\"color:black;\">Por la cantidad de : " + txtCantidad.getText() + "</p>"
                      + " <p style=\"color:black;\">Total : " + txtTotalPagar.getText().toUpperCase() + "</p><br>"
                      + " <p>Por favor Responder antes a la brevedad a nuestro canal de Comunicacion : "+ from + "</p>"
                      + "<p style=\"background-color:Tomato;\"><td>www.sigloXXI.com | siglo21.portafolio@gmail.com | +569 9999555</p>",
                      
              "text/html");*/
           message.setContent("<body><h1 style=\"background-color:Tomato;\">Pago de Insumos </h1><table BORDER=\"1\"><tr>"
                   + "<th>Producto</th><th>Precio unitario</th>"
                   + "<th >Descripcion</th><th>total</th></tr>"
                   + "<tr>"  
                   + "<td>"+ txtNombre.getText().toUpperCase()+ "</td>"
                   + "<td>"+ txtPrecioUnitario.getText().toUpperCase() +"</td>"
                   + "<td>"+ txtDescripcion.getText().toUpperCase() +"</td>"
                   + "<td>"+ txtTotalPagar.getText().toUpperCase() + "</td></tr>"
                   + "<tr><th>TOTAL</th><td></td><td></td><td><strong>" +txtTotalPagar.getText().toUpperCase()+ txtCantidad.getText() + "</strong></td></tr></table><br>"
                   + "<p>Por favor Responder a la brevedad a nuestro canal de Comunicacion : " + from + "</p>"
                   + "<p style=\"background-color:Tomato;\"><td>www.sigloXXI.com | siglo21.portafolio@gmail.com | +569 9999555</p>"
                   + "</body>",      
           "text/html");
            
	   // Send message
	   Transport.send(message);
           
	   System.out.println("Mensaje enviado satisfactoriamente....");
           //JOptionPane.showMessageDialog(rootPane, "Correo enviado a Provedor:" + jLabel14_mail + "Revisa tu mail");

      } catch (MessagingException e) {
	   e.printStackTrace();
	   throw new RuntimeException(e);
      }
}
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtBusquedaProv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtIdCate = new javax.swing.JTextField();
        jLabel_idpro = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel_cuenta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14_mail = new javax.swing.JLabel();
        jlabel_idpedido = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Busqueda"));

        jLabel2.setText("Por Provedor :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusquedaProv, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 290, 60));

        jLabel1.setText("Pago de Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jTable1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 800, 140));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        jLabel3.setText("Nombre");

        jLabel4.setText("Total");

        jLabel5.setText("Descripcion");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio Unitario");

        jLabel7.setText("Cantidad");

        jLabel8.setText("Stock Minimo");

        jLabel9.setText("Categoria");

        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtIdCate.setEditable(false);

        jLabel_idpro.setText("jLabel10");

        jLabel10.setText("ID-Prod :");

        jLabel11.setText("ID-Cat :");

        jLabel12.setText("Cantidad de Pedidos : ");

        jLabel_cuenta.setText("jLabel13");

        jLabel13.setText("Mail Provedor : ");

        jlabel_idpedido.setText("jLabel14");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_idpro))
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCate))
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_cuenta)))))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(24, 24, 24)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14_mail)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTotalPagar)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addComponent(jlabel_idpedido))
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_idpro)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel_cuenta)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14_mail)
                    .addComponent(jlabel_idpedido)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 170));

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizar.png"))); // NOI18N
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 30, 20));

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 480));

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Salir del Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cerrar Ventana");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int seleccion = jTable1.rowAtPoint(evt.getPoint());
        txtNombre.setText(jTable1.getValueAt(seleccion, 2)+"");
        jlabel_idpedido.setText(jTable1.getValueAt(seleccion, 0)+"");
        txtPrecioUnitario.setText(jTable1.getValueAt(seleccion, 8)+"");
        txtDescripcion.setText(jTable1.getValueAt(seleccion, 4)+"");
        txtCantidad.setText(jTable1.getValueAt(seleccion, 5)+"");
        txtCategoria.setText(jTable1.getValueAt(seleccion, 3)+"");
        //txtStockMinimo.setText(jTable1.getValueAt(seleccion, 3)+"");
        txtTotalPagar.setText(jTable1.getValueAt(seleccion, 9)+"");
        jLabel14_mail.setText(jTable1.getValueAt(seleccion, 10)+"");
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        try {
            Connection con = Conexion.getConnection();
            //PreparedStatement pst = null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CATEGORIAS WHERE CATEGORIA ='"+ this.txtCategoria.getText()+"'");
            //tring sql = ("SELECT * FROM CATEGORIAS WHERE CATEGORIA ='"+ this.cbCategoria.getSelectedItem()+"'");
            rs.next();
            this.txtIdCate.setText(String.valueOf(rs.getInt("ID_CATEGORIA")));
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Productos prod = new Productos();
            prod.setID_PRODUCTO(Integer.parseInt(jLabel_idpro.getText()));
            prod.setNOMBRE(txtNombre.getText());
            prod.setPRECIO_UNITARIO(Integer.parseInt(txtPrecioUnitario.getText()));
            prod.setDESCRIPCION(txtDescripcion.getText());
            prod.setID_CATEGORIA(Integer.parseInt(txtIdCate.getText()));
            prod.setCANTIDAD(Integer.parseInt(txtCantidad.getText()));
            prod.setSTOCK_MINIMO(Integer.parseInt(txtStockMinimo.getText()));
            String mensaje = prodo.agregarProductos(prod);
            
            ActualizarEstado();
            //Mail();
            listarPedido();
            JOptionPane.showMessageDialog(rootPane, "Solicitud Pagada Revisar en Ganancias");
            
        }catch(NumberFormatException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(rootPane, " Error de Solictud " + e);
       }  
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas Salir del Sistema?, "
                + "Recuerda Guardar tus Cambios", 
                 " Salir ",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0){                       
              System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //Boton para refrescar los pedidos en tabla 
    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        try {
            listarPedido();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudesProduAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Connection con = Conexion.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(
                    "SELECT ID_CARGO, STATUS_EMPLEADO FROM EMPLEADOS WHERE USUARIO = ?");
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudesProduFinanzas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.setString(1, user);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudesProduFinanzas.class.getName()).log(Level.SEVERE, null, ex);
        }
                 ResultSet rs = null;
        try {
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudesProduFinanzas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(rs.next()){
                int ID_CARGO = rs.getInt("ID_CARGO");
                String STATUS_EMPLEADO = rs.getString("STATUS_EMPLEADO");
                
                if(ID_CARGO== 1  && STATUS_EMPLEADO.equalsIgnoreCase("ACTIVO")){
                    dispose();
                    new InicioFinanzasAdmin().setVisible(true);
                    
                } else if(ID_CARGO== 2  && STATUS_EMPLEADO.equalsIgnoreCase("ACTIVO")){
                    dispose();
                    new InicioFinanzas().setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Datos de Acceso Incorrectos");
                System.err.println("Datos de Acceso Incorrectos");
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudesProduFinanzas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_VolverActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel14_mail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_cuenta;
    private javax.swing.JLabel jLabel_idpro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel_idpedido;
    private javax.swing.JTextField txtBusquedaProv;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdCate;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtStockMinimo;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
