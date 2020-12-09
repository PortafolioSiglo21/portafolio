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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuel
 */
public class Pedido_ProvedorDAO {
     private String mensaje;
    
    public int getMaxIDPedido(Connection con){
        int id = 0;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            if(id==0){
              pst = con.prepareStatement("SELECT MAX(ID_PEDIDO)+1 as id FROM PEDIDOPROVEDOR");
              rs = pst.executeQuery();
            if(rs.next()){
               id = rs.getInt(1)+1;
            }
            rs.close();
            pst.close();
            }else{
              pst = con.prepareStatement("SELECT MAX(ID_PEDIDO)+1 as id FROM PEDIDOPROVEDOR");
              rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
              }
            }catch(SQLException e){
            System.out.println("Error al mostrar id" + e.getMessage());
        }
        return id;
    }
    
    public String AgregarPedido(Connection con, Pedido_Provedor pp){
        PreparedStatement pst = null;
        //String sql = "INSERT INTO PEDIDOPROVEDOR (ID_PEDIDO, FECH_SOLICITUD, IVA, TOTAL_PAGAR, ID_PROVEEDOR, ID_EMPLEADO, PRODUCTO, CATEGORIA, DESCRIPCION, CANTIDAD, FECH_RECEPCION, FECH_PAGO, FECH_PEDIDO, ESTADO_PEDIDO, PRECIO) "
        String sql = "INSERT INTO PEDIDOPROVEDOR (ID_PEDIDO, FECH_SOLICITUD, IVA, TOTAL_PAGAR, ID_PROVEEDOR, ID_EMPLEADO, PRODUCTO, CATEGORIA, DESCRIPCION, CANTIDAD, FECH_RECEPCION, FECH_PAGO, FECH_PEDIDO, ESTADO_PEDIDO, PRECIO) "
                + "VALUES"
                + "(?,to_date(? ,'DD-MON-YYYY HH24:MI'),?,?,?,?,?,?,?,?,to_date(? ,'DD-MON-YYYY HH24:MI'),to_date(? ,'DD-MON-YYYY HH24:MI'),to_date(? ,'DD-MON-YYYY HH24:MI'),?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pp.getID_PEDIDO());
            pst.setString(2, pp.getFECH_SOLICITUD());
            pst.setDouble(3, pp.getIVA());
            pst.setDouble(4, pp.getTOTAL_PAGAR());
            pst.setInt(5, pp.getID_PROVEEDOR());
            pst.setInt(6, pp.getID_EMPLEADO());
            pst.setString(7, pp.getPRODUCTO());
            pst.setString(8, pp.getCATEGORIA());
            pst.setString(9, pp.getDESCRIPCION());
            pst.setInt(10, pp.getCANTIDAD());
            pst.setString(11, pp.getFECH_RECEPCION());
            pst.setString(12, pp.getFECH_PAGO());
            pst.setString(13, pp.getFECH_PEDIDO());
            pst.setString(14, pp.getESTADO_PEDIDO());
            pst.setDouble(15, pp.getPRECIO());
            mensaje = "Guardado Existoso del pedido";
            //JOptionPane.showMessageDialog(null, "Guardado Existoso");
            pst.execute();
            pst.close();
           
        } catch (SQLException | HeadlessException e) {
            mensaje = "Error de guardado del Pedido" + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarProductos(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas ={"ID_PEDIDO","FECH_SOLICITUD","IVA","TOTAL_PAGAR","ID_PROVEEDOR","ID_EMPLEADO","PRODUCTO","CATEGORIA","DESCRIPCION","CANTIDAD","FECH_RECEPCION","FECH_PAGO","FECH_PEDIDO","ESTADO_PEDIDO","PRECIO"};
        model= new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM PEDIDOPROVEDOR ORDER BY ID_PEDIDO";
        
        String [] filas = new String[15];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 15; i++) {
                    filas[i]=rs.getString(i+1);
                } 
                //filas[0]=rs.getString("ID_PEDIDO");
               model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los datos"+ e.getMessage());
        }
    }
    //Lista los pedidos desde bodega al admin
    public void listar(Connection con, JTable tabla, String texto){
        DefaultTableModel model;
        //String filtro=""+texto+"_%";
        String [] columnas ={"id_pedido","proveedor","producto","categoria","descripcion","cantidad","solicitud","estado","precio","total","CorreoProv"};
        model= new DefaultTableModel(null,columnas);
        
        String sql = "SELECT pedidoprovedor.id_pedido, proveedor, producto,categoria, pedidoprovedor.descripcion,"
                + "pedidoprovedor.cantidad,"
                + "pedidoprovedor.fech_solicitud, "
                + "pedidoprovedor.estado_pedido, pedidoprovedor.precio, "
                + "pedidoprovedor.total_pagar, proveedores.mail_proveedor "
                + "FROM proveedores , pedidoprovedor "
                + "WHERE pedidoprovedor.id_proveedor=proveedores.id_proveedor "
                + "ORDER BY proveedor";
        
        String [] filas = new String[11];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 11; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los datos"+ e.getMessage());
        }
    }
    
    public String ActualizarEstado(Connection con , Pedido_Provedor pp){
        String estado = "PEDIDO";
        PreparedStatement pst = null;
        String sql = "UPDATE PEDIDOPROVEDOR SET ESTADO_PEDIDO=?"
                + "WHERE ID_PEDIDO=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, estado);
            pst.setInt(2, pp.getID_PEDIDO());
            
            mensaje = "Modificacion Existoso del Estado";
            JOptionPane.showMessageDialog(null, "modificacion Existoso del Pedido");
            pst.executeUpdate();
            pst.close();
            
        }catch(SQLException | HeadlessException e){
            mensaje = "Error de modificacion del estado del Pedido"+e.getMessage();
        }
        return mensaje;
    }
    
    public void listarPedido(Connection con, JTable tabla, String texto){
        DefaultTableModel model;
        //String filtro=""+texto+"_%";
        String [] columnas ={"id_pedido","proveedor","producto","categoria","descripcion","cantidad","solicitud","estado","precio","total","CorreoProv"};
        model= new DefaultTableModel(null,columnas);
        
        String sql = "SELECT pedidoprovedor.id_pedido, proveedor, producto,categoria, pedidoprovedor.descripcion,"
                + "pedidoprovedor.cantidad,"
                + "pedidoprovedor.fech_solicitud, "
                + "pedidoprovedor.estado_pedido, pedidoprovedor.precio, "
                + "pedidoprovedor.total_pagar, proveedores.mail_proveedor "
                + "FROM proveedores , pedidoprovedor "
                + "WHERE pedidoprovedor.id_proveedor=proveedores.id_proveedor and estado_pedido='PEDIDO'"
                + "ORDER BY proveedor";
        
        String [] filas = new String[11];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 11; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los datos"+ e.getMessage());
        }
    }
    
    public void listarPagado(Connection con, JTable tabla, String texto){
        DefaultTableModel model;
        //String filtro=""+texto+"_%";
        String [] columnas ={"id_pedido","proveedor","producto","categoria","descripcion","cantidad","fecha_pago","estado","precio","total","CorreoProv"};
        model= new DefaultTableModel(null,columnas);
        
        String sql = "SELECT pedidoprovedor.id_pedido, proveedor, producto,categoria, pedidoprovedor.descripcion,"
                + "pedidoprovedor.cantidad,"
                + "pedidoprovedor.fech_pago, "
                + "pedidoprovedor.estado_pedido, pedidoprovedor.precio, "
                + "pedidoprovedor.total_pagar, proveedores.mail_proveedor "
                + "FROM proveedores , pedidoprovedor "
                + "WHERE pedidoprovedor.id_proveedor=proveedores.id_proveedor and estado_pedido='PAGADO'"
                + "ORDER BY proveedor";
        
        String [] filas = new String[11];
        Statement st = null;
        ResultSet rs = null;
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 11; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, " no se puede listar los datos"+ e.getMessage());
        }
    }
}


