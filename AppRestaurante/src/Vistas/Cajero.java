/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;
import Controlador.GananciasDO;
import Modelo.Ganancia;
import Modelo.GananciasDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Modelo.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Elitebook
 */
public class Cajero extends javax.swing.JFrame {

    String user,nombre_usuario;
    public static int sesion_usuario;
    
    public Cajero() {
        initComponents();
        setSize(604, 539);
        setResizable(false);
        setTitle("Cajero");
        setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/Img/orange-gradient-wallpaper-4422.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel13.getWidth(), 
        jLabel13.getHeight(), Image.SCALE_DEFAULT));
        jLabel13.setIcon(icono);
        this.repaint();
        

        
        user = Login.user;
        sesion_usuario=1;
        idMax();
        txtFecha.setText(FechaActual());
        LLenadoMesas();
        LLenadodePedidos();
        LLenadodePagos();
        LLenadodeFormaPagos();
        LLenadoIdEmpleado();

 
        //LLenadoStatus();
    }

   private GananciasDAO gdao = new GananciasDAO();
   private GananciasDO gdo = new GananciasDO();
   
   
   
   
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdBoleta = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtRutCliente = new javax.swing.JTextField();
        txtIDEmpleado = new javax.swing.JTextField();
        txtFormaPago = new javax.swing.JTextField();
        Crear = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Buscar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbMesas = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbPagar = new javax.swing.JComboBox();
        cbFormaP = new javax.swing.JComboBox();
        cbId_Pedidos = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/volver.png"))); // NOI18N
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 36, -1, -1));

        jLabel1.setText("ID_BOLETA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 171, -1, -1));

        jLabel2.setText("FECHA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 209, -1, -1));

        jLabel3.setText("PROPINA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 282, -1, -1));

        jLabel4.setText("PAGAR");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 247, -1, -1));

        txtIdBoleta.setEditable(false);
        getContentPane().add(txtIdBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 168, 113, -1));

        txtFecha.setEditable(false);
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 206, 113, -1));

        txtIVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIVAKeyReleased(evt);
            }
        });
        getContentPane().add(txtIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 282, 113, -1));

        txtTotalPagar.setEditable(false);
        getContentPane().add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 320, 113, -1));

        jLabel5.setText("CAMBIO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 209, -1, -1));

        jLabel6.setText("RUT_CLIENTE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 247, -1, -1));

        jLabel7.setText("ID_EMPLEADO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 285, -1, -1));

        jLabel8.setText("ID_FORMA_PAGO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 323, -1, -1));

        jLabel9.setText("EFECTIVO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 171, -1, -1));

        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });
        getContentPane().add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 168, 106, -1));

        txtCambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCambioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCambioKeyTyped(evt);
            }
        });
        getContentPane().add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 206, 106, -1));

        txtRutCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRutClienteKeyReleased(evt);
            }
        });
        getContentPane().add(txtRutCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 244, 106, -1));

        txtIDEmpleado.setEditable(false);
        getContentPane().add(txtIDEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 282, 106, -1));

        txtFormaPago.setEditable(false);
        txtFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFormaPagoActionPerformed(evt);
            }
        });
        txtFormaPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFormaPagoKeyReleased(evt);
            }
        });
        getContentPane().add(txtFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 320, 25, -1));

        Crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        Crear.setText("Guardar");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        getContentPane().add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 374, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logochico.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 36, -1, -1));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Editar.png"))); // NOI18N
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 374, -1, -1));

        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 374, -1, -1));

        jLabel11.setText("TOTAL PAGAR");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 323, -1, -1));

        cbMesas.setSelectedItem("mesas");
        cbMesas.setToolTipText("");
        cbMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesasActionPerformed(evt);
            }
        });
        getContentPane().add(cbMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 130, 57, -1));

        jLabel12.setText("ID_MESA/PEDIDO");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 133, -1, -1));

        cbPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagarActionPerformed(evt);
            }
        });
        getContentPane().add(cbPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 244, 113, -1));

        cbFormaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormaPActionPerformed(evt);
            }
        });
        getContentPane().add(cbFormaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 320, 76, -1));

        cbId_Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbId_PedidosActionPerformed(evt);
            }
        });
        getContentPane().add(cbId_Pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 130, 52, -1));

        jLabel13.setText("jLabel13");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed

        if(txtIdBoleta.getText().isEmpty()|| txtFecha.getText().isEmpty() || txtIVA.getText().isEmpty()||
            txtTotalPagar.getText().isEmpty() || txtEfectivo.getText().isEmpty() ||
            txtCambio.getText().isEmpty() || txtRutCliente.getText().isEmpty() || 
            txtIDEmpleado.getText().isEmpty()|| txtFormaPago.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debes llenar los Campos Solicitados");
            String Rut;
            Rut="76191789-7";
            txtRutCliente.setText(Rut);
        }else{
            Ganancia g = new Ganancia();
            g.setID_BOLETA(Integer.parseInt(txtIdBoleta.getText()));
            g.setFECHA(txtFecha.getText());
            g.setIVA(Integer.parseInt(txtIVA.getText()));
            g.setTOTAL_PAGAR(Integer.parseInt(txtTotalPagar.getText()));
            g.setEFECTIVO(Integer.parseInt(txtEfectivo.getText()));
            g.setCAMBIO(Integer.parseInt(txtCambio.getText()));
            g.setRUT_CLIENTE(txtRutCliente.getText()); 
            g.setID_EMPLEADO(Integer.parseInt(txtIDEmpleado.getText()));
            g.setID_FORMA_PAGO(Integer.parseInt(txtFormaPago.getText()));     
            JOptionPane.showMessageDialog(null, "Grabado Existoso");
            String mensaje = gdo.agregarGanancias(g);
            System.out.println("guardado");
            
            //----------------INICIO MODIFICAR PEDIDO-------------------------------------------
            
            ActualizarEstado();
            ActualizarMesa();
            LLenadodePedidos();
            
           //-----------------INICIO IMPRIMIR BOLETA-------------------------------------------- 
            
            Document documento = new Document(PageSize.A4);
        Date Fecha = new Date();
        long numero = Fecha.getTime();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+ "/Desktop/"+ "Boleta"+numero+".pdf"));
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/Img/Logochico.png");
            
            header.scaleToFit(207,88);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Font fuente = new Font(Font.getFamily("ARIAL"),10,Font.BOLD);
            Paragraph nreporte = new Paragraph("NºBOLETA: "+ numero,fuente);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Información De Boleta. \n \n");
            parrafo.setFont(FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            documento.add(nreporte);

            
            PdfPTable tablaBoleta = new PdfPTable(9);
            tablaBoleta.setWidthPercentage(100);

            
            PdfPCell celda1 = new PdfPCell(new Paragraph("id_boleta", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("fecha", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("iva", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("total_pagar", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("efectivo", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("cambio", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda7 = new PdfPCell(new Paragraph("rut_cliente", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda8 = new PdfPCell(new Paragraph("id_empleado", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            PdfPCell celda9 = new PdfPCell(new Paragraph("id_forma_pago", FontFactory.getFont("Calibri", 10, Font.BOLD, BaseColor.RED)));
            
            tablaBoleta.addCell(celda1);
            tablaBoleta.addCell(celda2);
            tablaBoleta.addCell(celda3);
            tablaBoleta.addCell(celda4);
            tablaBoleta.addCell(celda5);
            tablaBoleta.addCell(celda6);
            tablaBoleta.addCell(celda7);
            tablaBoleta.addCell(celda8);
            tablaBoleta.addCell(celda9);
            
            
            try {
                Connection con  = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM BOLETA WHERE ID_BOLETA='"+this.txtIdBoleta.getText()+"'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    do {                        
                        tablaBoleta.addCell(rs.getString(1));
                        tablaBoleta.addCell(rs.getString(2));
                        tablaBoleta.addCell(rs.getString(3));
                        tablaBoleta.addCell(rs.getString(4));
                        tablaBoleta.addCell(rs.getString(5));
                        tablaBoleta.addCell(rs.getString(6));
                        tablaBoleta.addCell(rs.getString(7));
                        tablaBoleta.addCell(rs.getString(8));
                        tablaBoleta.addCell(rs.getString(9));
                    } while (rs.next());
                    documento.add(tablaBoleta);
                }
                
                //Paragraph parrafo2 = new Paragraph();
                //parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                //parrafo2.add("\n \n ");
                //parrafo2.setFont(FontFactory.getFont("Calibri", 14, Font.BOLD, BaseColor.DARK_GRAY));
                
            } catch (SQLException | DocumentException e) {
                System.err.println("Error de obtencion desde BD impresion" + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Boleta Creada Correctamente");
        }catch (FileNotFoundException | DocumentException e) {
                System.err.println("Error de impresion" + e);
        } 
        catch (IOException ex) {
            Logger.getLogger(ImpresionListaProveedores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error" +ex);
        }
        Limpiar();
        //-----------------------------fin del guardar--------------------------
            
        }
        
    }//GEN-LAST:event_CrearActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Connection con = Conexion.getConnection();
                 PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(
                    "SELECT ID_CARGO, STATUS_EMPLEADO FROM EMPLEADOS WHERE USUARIO = ?");
        } catch (SQLException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.setString(1, user);
        } catch (SQLException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
                 ResultSet rs = null;
        try {
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }//GEN-LAST:event_VolverActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
       
        try {
            EditarFinanzas f = null;
            f = new EditarFinanzas();
            f.setVisible(true);
            super.dispose();
        } catch (Exception e) {
            
        }
                   
    }//GEN-LAST:event_BuscarActionPerformed

        public void Limpiar(){
        //productos
        txtIVA.setText("");
        txtTotalPagar.setText("");
        txtEfectivo.setText("");
        txtCambio.setText("");
        txtRutCliente.setText("");
        txtFormaPago.setText("");
        txtIdBoleta.setText("");
        if(txtIdBoleta.getText().isEmpty()){
            txtIdBoleta.setText(gdo.getMaxID()+"");
        }
    }
        
    public static String FechaActual()  {
     Date fecha=new Date();   
     SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
     return formatoFecha.format(fecha);
   }
    
    
    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Limpiar?",
            " Borrado de solicitudes ",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
               if (pregunta == 0){
               Limpiar();
        } 
        
    
    }//GEN-LAST:event_LimpiarActionPerformed
    
    private void txtCambioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCambioKeyReleased
        try {
            int num1,num2,total;  
             num1=Integer.parseInt(txtTotalPagar.getText());
             num2=Integer.parseInt(txtEfectivo.getText());
             total=num2-num1;
          if (total<0){ 
              JOptionPane.showMessageDialog(null, "Cuidado!!! Efectivo insuficiente para el pago");
         }
          else {
             txtCambio.setText(total+"");
        } 
            
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ingresar valor total_pagar y efectivo");
        }

    }//GEN-LAST:event_txtCambioKeyReleased

   
    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0'|| c >'9')evt.consume();
    }//GEN-LAST:event_txtEfectivoKeyTyped

    public void idMax(){
      txtIdBoleta.setText(gdo.getMaxID()+"");
    }  
     
    
    private void cbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesasActionPerformed
        LLenadodePedidos();
    }//GEN-LAST:event_cbMesasActionPerformed

    private void txtFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFormaPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFormaPagoActionPerformed

    private void txtFormaPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFormaPagoKeyReleased
    try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FORMAS_PAGO WHERE FORMA_PAGO='" + this.cbFormaP.getSelectedItem()+ "'");
        rs.next();
        this.txtFormaPago.setText(String.valueOf(rs.getInt("ID_FORMA_PAGO")));        //cbPagar.addItem(rs.getString("TOTAL_PEDIDO"));
        
    } catch(Exception e){
        System.err.println("error de llenado combobox desde bd" + e);
    }
        
    }//GEN-LAST:event_txtFormaPagoKeyReleased

    private void txtRutClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutClienteKeyReleased

    }//GEN-LAST:event_txtRutClienteKeyReleased

    private void cbId_PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbId_PedidosActionPerformed
       LLenadodePagos();   
           try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pedidos WHERE ID_PEDIDO='" + this.cbId_Pedidos.getSelectedItem()+ "'");
        rs.next();
        this.txtRutCliente.setText(String.valueOf(rs.getString("rut_cliente")));        //cbPagar.addItem(rs.getString("TOTAL_PEDIDO"));
        
    } catch(Exception e){
        System.err.println("error de llenado combobox ID_PEDIDOS" + e);
    }
        
    }//GEN-LAST:event_cbId_PedidosActionPerformed

    private void txtCambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCambioKeyTyped
        char c = evt.getKeyChar();
        if(c<'0'|| c >'9')evt.consume();
    }//GEN-LAST:event_txtCambioKeyTyped

    private void cbFormaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormaPActionPerformed
    try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FORMAS_PAGO WHERE FORMA_PAGO='" + this.cbFormaP.getSelectedItem()+ "'");
        rs.next();
        this.txtFormaPago.setText(String.valueOf(rs.getInt("ID_FORMA_PAGO")));        //cbPagar.addItem(rs.getString("TOTAL_PEDIDO"));
        
    } catch(Exception e){
        System.err.println("error de llenado combobox desde bd" + e);
    }
    }//GEN-LAST:event_cbFormaPActionPerformed

    private void cbPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagarActionPerformed
    try {
      int iva;
      String pago;
      pago=(String) cbPagar.getSelectedItem();
      iva=(Integer.parseInt(pago)*10)/100;
      txtIVA.setText(iva+"");


       int ivas,totalpago;
       String pagos;
       pagos=(String) cbPagar.getSelectedItem();
       ivas=Integer.parseInt(txtIVA.getText());
       totalpago=(Integer.parseInt(pagos)+iva);
       txtTotalPagar.setText(totalpago+"");
    } catch(Exception e){
        System.err.println("ingresar mesa que tenga pedido" + e);
      }
    }//GEN-LAST:event_cbPagarActionPerformed

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
        try {
            int num1,num2,total;  
             num1=Integer.parseInt(txtTotalPagar.getText());
             num2=Integer.parseInt(txtEfectivo.getText());
             total=num2-num1;
          if (total<0){ 
              JOptionPane.showMessageDialog(null, "Cuidado!!! Efectivo insuficiente para el pago");
         }
          else {
             txtCambio.setText(total+"");
        } 
            
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ingresar valor total_pagar y efectivo");
        }

    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void txtIVAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIVAKeyReleased
       int ivas,totalpago;
       String pagos;
       pagos=(String) cbPagar.getSelectedItem();
       ivas=Integer.parseInt(txtIVA.getText());
       totalpago=(Integer.parseInt(pagos)+ivas);
       txtTotalPagar.setText(totalpago+"");
    }//GEN-LAST:event_txtIVAKeyReleased

 
public void LLenadoMesas(){
    //llenado categoria cb
    this.cbMesas.removeAllItems();
    try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM MESAS WHERE STATUS_MESAS='OCUPADA'");
        while (rs.next()){
            this.cbMesas.addItem(rs.getString("id_Mesas"));
        }
    } catch(Exception e){
        System.err.println("error de llenado combobox desde bd" + e);
    }
}

public void LLenadodePedidos(){
    this.cbId_Pedidos.removeAllItems();
    try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pedidos where id_mesas='" + this.cbMesas.getSelectedItem() + "' and STATUS_PEDIDO='PAGAR'");
        while (rs.next()){
        this.cbId_Pedidos.addItem(rs.getInt("ID_PEDIDO"));
        //cbPagar.addItem(rs.getString("TOTAL_PEDIDO"));
        }
    } catch(Exception e){
        System.err.println("error de llenado combobox desde bd" + e);
    }
    
    }

public void LLenadodePagos(){
    this.cbPagar.removeAllItems();
    try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PEDIDOS WHERE ID_PEDIDO ='" + this.cbId_Pedidos.getSelectedItem() + "'");
        while (rs.next()){
        this.cbPagar.addItem(rs.getString("total_pedido"));
        }
    } catch(Exception e){
        System.err.println("error de llenado combobox desde bd" + e);
    }
    
    }

public void LLenadodeFormaPagos(){
    this.cbFormaP.removeAllItems();
    try {
        Connection con = Conexion.getConnection();
        //preparedStatement pst = null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FORMAS_PAGO");
        while (rs.next()){
        this.cbFormaP.addItem(rs.getString("FORMA_PAGO"));
        //cbPagar.addItem(rs.getString("TOTAL_PEDIDO"));
        }
    } catch(Exception e){
        System.err.println("error de llenado combobox desde bd" + e);
    }
    
}

public void ActualizarMesa(){
        try {
            Connection con = Conexion.getConnection();
            String query = "UPDATE MESAS SET STATUS_MESAS='LIBRE' WHERE ID_MESAS='"+this.cbMesas.getSelectedItem() + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println("Error de llenado " +  e);
        }
}
// -------------------------------------------------------------------  


    /*public void Mail(){
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
                      
              "text/html");
           message.setContent("<body><h1 style=\"background-color:Tomato;\">Solicitud de Insumos </h1><table BORDER=\"1\"><tr>"
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
           //JOptionPane.showMessageDialog(rootPane, "Correo enviado a Cliente:" + jLabel14_mail + "Revisa tu mail");

      } catch (MessagingException e) {
	   e.printStackTrace();
	   throw new RuntimeException(e);
      }
}*/


   public void ActualizarEstado(){
        //////llenado cb provedores activos
        //this.cbProveActivos.removeAllItems();
        try {
            Connection con = Conexion.getConnection();
            String query = "UPDATE PEDIDOS SET STATUS_PEDIDO='PAGADO' WHERE ID_PEDIDO='"+this.cbId_Pedidos.getSelectedItem() + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println("Error de llenado " +  e);
        }
    }


public void LLenadoIdEmpleado(){
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select ID_EMPLEADO from EMPLEADOS WHERE USUARIO ='"+ user +"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id_empleado = rs.getInt("id_empleado");
                txtIDEmpleado.setText(Integer.toString(id_empleado));
                txtIDEmpleado.setBackground(Color.ORANGE);
            }
            else {
                System.err.println("Error de llenado ID_EMPLEADO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error id_empleado" +e);
        }
    
    
    
}



    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Crear;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Volver;
    private javax.swing.JComboBox cbFormaP;
    private javax.swing.JComboBox cbId_Pedidos;
    private javax.swing.JComboBox cbMesas;
    private javax.swing.JComboBox cbPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFormaPago;
    private javax.swing.JTextField txtIDEmpleado;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIdBoleta;
    private javax.swing.JTextField txtRutCliente;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
