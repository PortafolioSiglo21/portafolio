/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Conexion;
import Modelo.Ganancia;
import Modelo.GananciasDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;


public class GananciasDO {
     String mensaje ="";
     GananciasDAO gdao = new GananciasDAO(); //Instacia a DAO PROVEEDOR
     
     
        
    public void listarGanancias(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        gdao.listarGanancias(con, tabla);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    


    public String agregarGanancias(Ganancia g){
        Connection con = Conexion.getConnection();
        try{
            mensaje = gdao.agregarGanancias(con, g);
            //con.rollback();
        }catch(Exception e){
            mensaje = mensaje + " "+e.getMessage();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(Exception e){
                mensaje = mensaje + " "+e.getMessage();
            }
        }
        return mensaje;
    }
    
    
    
        public String modificarGanancias(Ganancia g){
        Connection con = Conexion.getConnection();
        try{
            mensaje = gdao.modificarGanancias(con, g);
            //con.rollback();
        }catch(Exception e){
            mensaje = mensaje + " "+e.getMessage();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(Exception e){
                mensaje = mensaje + " "+e.getMessage();
            }
        }
        return mensaje;
        }
        
        public int getMaxID(){
        Connection con = Conexion.getConnection();
        int id = gdao.getMaxIDGanancias(con);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
        return id;
    }
}
