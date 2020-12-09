/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuel
 */
public class ProductosDAO {
    private String mensaje;
    
    
    
    
    
    public String agregarProducto(Connection con, Productos produc){
        PreparedStatement pst = null;
        String sql = "INSERT INTO PRODUCTOS (ID_PRODUCTO, NOMBRE, PRECIO_UNITARIO, DESCRIPCION, "
                + "ID_CATEGORIA, CANTIDAD, STOCK_MINIMO) VALUES"
                + "(?,?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, produc.getID_PRODUCTO());
            pst.setString(2, produc.getNOMBRE());
            pst.setInt(3, produc.getPRECIO_UNITARIO());
            pst.setString(4, produc.getDESCRIPCION());
            pst.setInt(5, produc.getID_CATEGORIA());
            pst.setInt(6, produc.getCANTIDAD());
            pst.setInt(7, produc.getSTOCK_MINIMO());
            mensaje = "Guardado Existoso";
            //JOptionPane.showMessageDialog(null, "Guardado Existoso");
            pst.execute();
            pst.close();
            
        }catch(SQLException | HeadlessException e){
            mensaje = "Error de guardado" + e.getMessage();
        }
        
        return mensaje;
    }
    
    public int getMaxIDProductos(Connection con){
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareStatement("SELECT MAX(ID_PRODUCTO)+1 as id FROM PRODUCTOS");
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Error al mostrar id" + e.getMessage());
        }
        return id;
    }
    
    public void listarProductos(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas ={"ID_PRODUCTO","NOMBRE","PRECIO_UNITARIO","DESCRIPCION","ID_CATEGORIA","CANTIDAD"};
        model= new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PRODUCTOS ORDER BY ID_PRODUCTO";
        
        String [] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 6; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los productos"+ e.getMessage());
        }
    }   
    
}

