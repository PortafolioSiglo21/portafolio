/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Modelo.Categorias;

/**
 *
 * @author samuel
 */
public class CategoriaDAO {
    private String mensaje;
    
    //LLENADO CB DESDE BD, PERO NO FUNCIUONAL
    public void consultaCate(JComboBox<Object> cbCategoria) {
        Connection con = Conexion.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT ID_CATEGORIA, CATEGORIA FROM CATEGORIAS ORDER BY ID_CATEGORIA";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                   //cbCategoria.addItem(rs.getString("CATEGORIA"));
                   cbCategoria.addItem(rs.getString("ID_CATEGORIA"));
                }        
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, " Errorrrr "+ e.getMessage());
        }
    }
    
}
