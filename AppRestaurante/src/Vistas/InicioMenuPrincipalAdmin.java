/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import Controlador.ProveedorDO;
import Modelo.Conexion;
import Vistas.Login;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.WindowConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class InicioMenuPrincipalAdmin extends javax.swing.JFrame {
    
    String user, nombre_usuario, hola ;
    public static int sesion_usuario;

    /**
     * Creates new form InicioMenuPrincipalAdmin
     */
    private ProveedorDO pdo = new ProveedorDO();
        public InicioMenuPrincipalAdmin() throws SQLException, InstantiationException, IllegalAccessException {
          initComponents();
          
          //********
          /*long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK 
               + AWTEvent.KEY_EVENT_MASK;
          Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener(){
          @Override
           public void eventDispatched(AWTEvent e)
           {
               long fx1 = AWTEvent.MOUSE_MOTION_EVENT_MASK;
               boolean outfx1 = fx1!=0;
               outfx1 = true;
               
               //int fx = (int)AWTEvent.MOUSE_MOTION_EVENT_MASK;
               if(outfx1){
                   System.out.println("si");
               }else{
                   System.out.println("No");
               }
           }
           }, eventMask);*/
          //*********
          this.setLocationRelativeTo(null);
          setSize(651, 341);
          setResizable(false);
          user =Login.user;
          sesion_usuario = 1;
          setTitle("Administrador- sesion actual : "+ user);
          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          
          //Fecha 
          Date fecha = new Date(); //fecha y hora actual
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); //formatear la fecha en una cadena
          String hora = sdf.format(fecha); //setear la representacion en cadena de la fecha
          
            try {
                Connection con = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(
                "SELECT USUARIO FROM EMPLEADOS WHERE USUARIO = '" + user + "'");
                
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    nombre_usuario = rs.getString("USUARIO");
                    jLabel4_user.setText("Bienvenido : " + nombre_usuario.toUpperCase() + " - "+  " La fecha Actual es  : " + hora);
                }
            } catch (Exception e) {
                System.err.println(" Error de Conexion Desde la Interfaz Admin"+ e);   
            }
            
            //Hilo de mensaaje 
            new Thread(){
            public void run(){
                int x = 300;
                int y = jLabel4_user.getLocation().y;
                
                while(true){
                    x--;
                    if(x < -100){
                        x = getWidth();
                    }
                    jLabel4_user.setLocation(x, y);
                    try{
                        Thread.sleep(10);
                    }catch(Exception e){ 
                    }
                }
            }
        }.start();
            //****Control de Cerrado de Sesion
            /*new Thread(){
            @Override
            public void run(){
                try{
                    
                    Thread mith = Thread.currentThread();
                    mith.sleep(5000);
                    JOptionPane.showMessageDialog(null, "Secion inactiva, se cerrar la sesion");
                    System.exit(0);
                }catch(InterruptedException ie){ 
                    //JOptionPane.showMessageDialog(null, "Se CERRARA LA SECION");
                    //System.exit(0);
                }
            }
        }.start();*/
    }
    
       //JOptionPane.showMessageDialog(null, "Los campos no tienen datos válidos",
       //"Activar Temporizador", JOptionPane.ERROR_MESSAGE);
          
    public void listarProveedores() throws SQLException{
       //pdo.listarProveedor(jTable1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4_user = new javax.swing.JLabel();
        jLabel4_fecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3_ImprimirProve = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logochico.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 200, 90));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel3.setText("version 1.0");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jLabel4_user.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4_user.setText("Bienvenido :");
        getContentPane().add(jLabel4_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4_fecha.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        getContentPane().add(jLabel4_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/orange-gradient-wallpaper-4422.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 310));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/consulta.png"))); // NOI18N
        jMenu1.setText("Consultas");

        jMenuItem1.setText("Proveedores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporte.png"))); // NOI18N
        jMenu3.setText("Reportes");

        jMenuItem3_ImprimirProve.setText("Imprimir Proveedores");
        jMenuItem3_ImprimirProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3_ImprimirProveActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3_ImprimirProve);

        jMenuBar1.add(jMenu3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/provedores.png"))); // NOI18N
        jMenu2.setText("Gestion Proveedores");

        jMenuItem2.setText("R/M/E Proved");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        jMenu4.setText("Gestion Productos");

        jMenuItem3.setText("R/M/E Productos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Solicitudes Productos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar.png"))); // NOI18N
        jMenu5.setText("Cerra Sistema");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ConsultaProveedores conpro = new ConsultaProveedores();
        conpro.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        RegistrarProveedores rpro = null;
        try {
            rpro = new RegistrarProveedores();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InicioMenuPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        rpro.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        GestionProductosAdmin Li = null;
        try {
            Li = new GestionProductosAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(InicioMenuPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Li.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        SolicitudesProduAdmin sp = null;
        try {
            sp = new SolicitudesProduAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(InicioMenuPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        sp.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Deseas Salir del Sistema?, "
                + "Recuerda Guardar tus Cambios", 
                  " Salir ",JOptionPane.YES_NO_OPTION ,JOptionPane.WARNING_MESSAGE);
            if (pregunta == 0){                       
              dispose();
              Login l = new Login();
              l.setVisible(true);
        }
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem3_ImprimirProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3_ImprimirProveActionPerformed
        //ImpresionListaProveedores ImpPro = new ImpresionListaProveedores();
        //ImpPro.setVisible(true);
        Document documento = new Document(PageSize.A4);
        
        Date ff = new Date(); //fecha y hora actual
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); //formatear la fecha en una cadena
        String hora = sdf.format(ff); //setear la representacion en cadena de la fecha
        //******
        Date fecha = new Date(); //fecha y hora actual
        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH) + 1;
        long numero = fecha.getTime();
        String fech = calendar.get(Calendar.DAY_OF_MONTH)+
            "-"+month+
            "-"+calendar.get(Calendar.YEAR);
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter pdf = PdfWriter.getInstance(documento, new FileOutputStream(ruta+ "/Desktop/"+ "ReporteProvedores_"+fech +"-"+numero+".pdf"));
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/Img/LogoRestaurante Siglo 21.png");
            
            header.scaleToFit(207,88);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Font fuente = new Font(Font.getFamily("ARIAL"),10,Font.BOLD);
            Paragraph nRepo = new Paragraph("N° Reporte: " + numero, fuente);
            Paragraph Creado = new Paragraph("Creado Por: " + user, fuente);
            Paragraph fec = new Paragraph("Fecha: " + hora, fuente);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion de Proveedores. \n \n \n");
            parrafo.setFont(FontFactory.getFont("Calibri", 9, Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            Barcode39 code = new Barcode39();
            code.setCode(String.valueOf(numero));
            com.itextpdf.text.Image img128 = code.createImageWithBarcode(pdf.getDirectContent(),BaseColor.BLACK, BaseColor.BLACK);
            img128.scalePercent(150);
            
            documento.open();
            documento.add(header);
            documento.add(nRepo);
            documento.add(Creado);
            documento.add(fec);
            documento.add(parrafo);
            
            
            PdfPTable tablaprove = new PdfPTable(8);
            tablaprove.setWidthPercentage(100);
            
            PdfPCell celda1 = new PdfPCell(new Paragraph("Id",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("Rut provedoor",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Proveedor",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Nombre Contacto",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Telefono",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Web",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda7 = new PdfPCell(new Paragraph("Email",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            PdfPCell celda8 = new PdfPCell(new Paragraph("IdAdmin",FontFactory.getFont("Calibri",9,Font.BOLD,BaseColor.BLUE)));
            tablaprove.addCell(celda1);
            tablaprove.addCell(celda2);
            tablaprove.addCell(celda3);
            tablaprove.addCell(celda4);
            tablaprove.addCell(celda5);
            tablaprove.addCell(celda6);
            tablaprove.addCell(celda7);
            tablaprove.addCell(celda8);
            
            tablaprove.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            
            try {
                Connection con  = Conexion.getConnection();
                PreparedStatement pst = con.prepareStatement("SELECT * FROM PROVEEDORES");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    do{  
                        String h = rs.getString(1);
                        tablaprove.addCell(new Paragraph(h,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(1));
                        String d = rs.getString(2);
                        tablaprove.addCell(new Paragraph(d,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(2));
                        String c = rs.getString(3);
                        tablaprove.addCell(new Paragraph(c,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(3));
                        String b = rs.getString(4);
                        tablaprove.addCell(new Paragraph(b,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(4));
                        String f = rs.getString(5);
                        tablaprove.addCell(new Paragraph(f,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(5));
                        String a = rs.getString(6);
                        tablaprove.addCell(new Paragraph(a,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(6));
                        String l = rs.getString(7);
                        tablaprove.addCell(new Paragraph(l,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                        //tablaprove.addCell(rs.getString(7));
                        String n = rs.getString(8);
                        tablaprove.addCell(new Paragraph(n,FontFactory.getFont("arial",9,Font.BOLD,BaseColor.BLACK)));
                       
                
                    } while (rs.next());
                    documento.add(tablaprove);
                    documento.add(img128);
                }
                
                //Paragraph parrafo2 = new Paragraph();
                //parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                //parrafo2.add("\n \n ");
                //parrafo2.setFont(FontFactory.getFont("Calibri", 14, Font.BOLD, BaseColor.DARK_GRAY));
                
            } catch (SQLException | DocumentException e) {
                System.err.println("Error de obtencion desde BD impresion" + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado Correctamente");
        }catch (FileNotFoundException | DocumentException e) {
                System.err.println("Error de impresion" + e);
        } 
        catch (IOException ex) {
            Logger.getLogger(ImpresionListaProveedores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error" +ex);
        }
    }//GEN-LAST:event_jMenuItem3_ImprimirProveActionPerformed

    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4_fecha;
    private javax.swing.JLabel jLabel4_user;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem3_ImprimirProve;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
   
}
