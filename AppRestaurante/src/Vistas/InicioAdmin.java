/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author samuel
 */
public class InicioAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public InicioAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnFinanzas = new javax.swing.JButton();
        BtnProveedor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnFinanzas.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        BtnFinanzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fina.png"))); // NOI18N
        BtnFinanzas.setText("Finazas");
        BtnFinanzas.setContentAreaFilled(false);
        BtnFinanzas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnFinanzas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnFinanzas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnFinanzas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnFinanzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinanzasActionPerformed(evt);
            }
        });
        getContentPane().add(BtnFinanzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 130, 120));

        BtnProveedor.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        BtnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/prove.png"))); // NOI18N
        BtnProveedor.setText("Proveedores y Productos");
        BtnProveedor.setContentAreaFilled(false);
        BtnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnProveedor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnProveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BtnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 170, 120));

        jPanel1.setBackground(new java.awt.Color(255, 110, 21));

        jButton4.setBackground(new java.awt.Color(255, 51, 0));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 487, Short.MAX_VALUE)
                .addComponent(jButton4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jButton4))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema Administrador ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 410, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/orange-gradient-wallpaper-4422.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 353));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BtnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProveedorActionPerformed
        InicioMenuPrincipalAdmin prove = null;
        try {
            prove = new InicioMenuPrincipalAdmin();
            dispose();
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(InicioAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        prove.setVisible(true);
    }//GEN-LAST:event_BtnProveedorActionPerformed

    private void BtnFinanzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinanzasActionPerformed
        InicioFinanzasAdmin d = null;
            d = new InicioFinanzasAdmin();
            d.setVisible(true);
            super.dispose();
    }//GEN-LAST:event_BtnFinanzasActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFinanzas;
    private javax.swing.JButton BtnProveedor;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
