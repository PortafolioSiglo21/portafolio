/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.EmpleadosDAO;
import java.sql.Connection;

/**
 *
 * @author samuel
 */
public class EmpleadosDO {
    String mensaje ="";
    
    EmpleadosDAO empdao = new EmpleadosDAO();
    
    public int getMaxIDEmpleados(){
        Connection con = Conexion.getConnection();
        int id = empdao.getMaxIDEmpleados(con);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
        return id;
    }
    
}
