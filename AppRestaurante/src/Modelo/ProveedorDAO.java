/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author samuel
 */
public class ProveedorDAO {
    private String mensaje;
   
    public String agregarProveedor(Connection con, Proveedor prov){
        ResultSet rs;
        try {
            //*Procedimiento Almacenado a SQL
            CallableStatement cst = con.prepareCall("{ call usp_registrar_provedor(?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, prov.getID_PROVEEDOR());
            cst.setString(2, prov.getRUT_PROVEEDOR());
            cst.setString(3, prov.getPROVEEDOR());
            cst.setString(4, prov.getNOMBRE_CONTACTO());
            cst.setString(5, prov.getTELEFONOS());
            cst.setString(6, prov.getSITIO_WEB());
            cst.setString(7, prov.getMAIL_PROVEEDOR());
            cst.setString(8, prov.getID_ADMIN());
            cst.setString(9, prov.getESTADO_PROVEDOR());
            rs = cst.executeQuery();
            mensaje = "Guardado Existoso";
       } catch (SQLException | HeadlessException e) {
           mensaje = "Error de guardado provedor" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarProveedor(Connection con, Proveedor prov){
        ResultSet rs;
        try {
            //*Procedimiento Almacenado a SQL
            CallableStatement cst = con.prepareCall("{ call usp_actualizar_provedores(?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, prov.getID_PROVEEDOR());
            cst.setString(2, prov.getRUT_PROVEEDOR());
            cst.setString(3, prov.getPROVEEDOR());
            cst.setString(4, prov.getNOMBRE_CONTACTO());
            cst.setString(5, prov.getTELEFONOS());
            cst.setString(6, prov.getSITIO_WEB());
            cst.setString(7, prov.getMAIL_PROVEEDOR());
            cst.setString(8, prov.getID_ADMIN());
            cst.setString(9, prov.getESTADO_PROVEDOR());
            rs = cst.executeQuery();
            mensaje = "Modificado  Existoso";
       } catch (SQLException | HeadlessException e) {
           mensaje = "Error de Modificacion provedor" + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarProveedor(Connection con, int id){
        ResultSet rs;
        try {
            //*Procedimiento Almacenado a SQL
            CallableStatement cst = con.prepareCall("{ call usp_borrar_provedores(?)}");
            cst.setInt(1, id);
            rs = cst.executeQuery();
            mensaje = "EliminadoExistoso";
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa de Provedor");
       } catch (SQLException | HeadlessException e) {
           mensaje = "Error de Eliminacion provedor" + e.getMessage();
        }
        return mensaje;
    }
    
    //lista todos los provedores en tabla 
    public void listarProveedor(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas ={"ID_PROVEEDOR","RUT_PROVEEDOR","PROVEEDOR","NOMBRE_CONTACTO","TELEFONOS","SITIO_WEB","MAIL_PROVEEDOR","ID_ADMIN","ESTADO_PROVEDOR"};
        model= new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PROVEEDORES ORDER BY ID_PROVEEDOR";
        
        String [] filas = new String[9];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 9; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los datos"+ e.getMessage());
        }
    } 
    
    //Lista solo los Activos (provedores)
    public void ListarProvAct(Connection con, JTable tabla){
        DefaultTableModel model;
        String validar = "ACTIVO";
        String [] columnas ={"ID_PROVEEDOR","RUT_PROVEEDOR","PROVEEDOR","NOMBRE_CONTACTO","TELEFONOS","SITIO_WEB","MAIL_PROVEEDOR","ID_ADMIN","ESTADO_PROVEDOR"};
        model= new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM PROVEEDORES WHERE ESTADO_PROVEDOR='"+ validar +"'";
        
        String [] filas = new String[9];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 9; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los datos"+ e.getMessage());
        }
    
    }
    
    
    
    public int getMaxID(Connection con){
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareStatement("SELECT MAX(ID_PROVEEDOR)+1 as id FROM PROVEEDORES");
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
}
