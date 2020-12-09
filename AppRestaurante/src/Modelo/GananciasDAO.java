package Modelo;

import java.awt.HeadlessException;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static oracle.sql.NUMBER.e;
import javax.swing.DefaultComboBoxModel;
import java.sql.DriverManager;


public class GananciasDAO {
    private String mensaje;

    
        public void listarGanancias(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas ={"ID_BOLETA","FECHA","IVA","TOTAL_PAGAR","EFECTIVO","CAMBIO","RUT_CLIENTE",
                            "ID_EMPLEADO","ID_FORMA_PAGO"};
        model= new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM BOLETA ORDER BY ID_BOLETA";
        
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
        
        
     public String agregarGanancias(Connection con, Ganancia g){
        PreparedStatement pst = null;
        String sql = "INSERT INTO BOLETA (ID_BOLETA, FECHA, IVA, TOTAL_PAGAR, EFECTIVO, CAMBIO, RUT_CLIENTE, ID_EMPLEADO,ID_FORMA_PAGO) VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, g.getID_BOLETA());
            pst.setString(2, g.getFECHA());
            pst.setInt(3, g.getIVA());
            pst.setInt(4, g.getTOTAL_PAGAR());
            pst.setInt(5, g.getEFECTIVO());
            pst.setInt(6, g.getCAMBIO());
            pst.setString(7, g.getRUT_CLIENTE());
            pst.setInt(8, g.getID_EMPLEADO());
            pst.setInt(9, g.getID_FORMA_PAGO());
            mensaje = "Guardado Existoso";
            //JOptionPane.showMessageDialog(null, "Guardado Existoso");
            pst.execute();
            pst.close();
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Revisa si los datos Corresponden");
            mensaje = "Error de guardado" + e.getMessage();
        }
        return mensaje;
    }   
       
     
     
     public int getMaxIDGanancias(Connection con){
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareStatement("SELECT MAX(ID_BOLETA)+1 as id FROM BOLETA");
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Error al mostrar id" + e.getMessage());
        }
        return id;}
        
             
        public String modificarGanancias(Connection con, Ganancia g){
        PreparedStatement pst = null;
        String sql = "UPDATE BOLETA SET TOTAL_PAGAR=?, EFECTIVO=?, CAMBIO=?, ID_FORMA_PAGO=?"
                + "WHERE ID_BOLETA=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, g.getTOTAL_PAGAR());
            pst.setInt(2, g.getEFECTIVO());
            pst.setInt(3, g.getCAMBIO());
            pst.setInt(4, g.getID_FORMA_PAGO());
            pst.setInt(5, g.getID_BOLETA()); 

           
            mensaje = "Modificacion Existoso";
            //JOptionPane.showMessageDialog(null, "modificacion Existoso");
            pst.execute();
            pst.close();
            
        }catch(SQLException | HeadlessException e){
            mensaje = "Error de modificacion"+e.getMessage();
        }
        return mensaje;
    }
        
//------------------------------fin-------------------------------------        

        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   }