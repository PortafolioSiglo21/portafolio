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

/**
 *
 * @author samuel
 */
public class EmpleadosDAO {
    
    //*Incremento de 
    public int getMaxIDEmpleados(Connection con){
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst = con.prepareStatement("SELECT MAX(ID_EMPLEADO)+1 as id FROM EMPLEADOS");
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
            System.out.println("Error al mostrar id empleados" + e.getMessage());
        }
        return id;
    }
    
}
