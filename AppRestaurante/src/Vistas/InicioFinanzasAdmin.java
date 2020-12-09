/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import static Vistas.SolicitudesProduAdmin.sesion_usuario;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author samuel
 */
public class InicioFinanzasAdmin extends javax.swing.JFrame {
    String user, nombre_usuario, hola ;

    /**
     * Creates new form InicioFinanzas
     */
    public InicioFinanzasAdmin() {
        initComponents();
        setSize(642, 322);
        setResizable(false);
        setTitle("Menu Finanzas");
        setLocationRelativeTo(null);
        
        user =Login.user;
        sesion_usuario = 1;
        setTitle("sesion actual : "+ user);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/Img/orange-gradient-wallpaper-4422.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel2.getWidth(), 
        jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logochico.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 109, -1, -1));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/volver.png"))); // NOI18N
        cerrar.setText("Volver");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Finanzas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 74, -1, -1));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 290));

        jMenuBar1.setMaximumSize(new java.awt.Dimension(240, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(240, 34));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/calculadora.png"))); // NOI18N
        jMenu1.setText("Ganancias");

        jMenuItem1.setText("Ganancias");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cajero.png"))); // NOI18N
        jMenu2.setText("Boletas");

        jMenuItem2.setText("Boleta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Productos.png"))); // NOI18N
        jMenu3.setText("Productos");

        jMenuItem3.setText("Productos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed

          InicioAdmin a = null;
          a = new InicioAdmin();
          a.setVisible(true);
          super.dispose();
        
    }//GEN-LAST:event_cerrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Ganancias g = null;
        try {
            g = new Ganancias();
        } catch (SQLException ex) {
            Logger.getLogger(InicioMenuPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Cajero c = null;
        c = new Cajero();
        c.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        SolicitudesProduFinanzas sp = null;
        try {
            sp = new SolicitudesProduFinanzas();
        } catch (SQLException ex) {
            Logger.getLogger(InicioFinanzasAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        sp.setVisible(true); 
        super.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
