/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;


/**
 *
 * @author samuel
 */
public class ProveedorDO {
    String mensaje ="";
    ProveedorDAO prodao = new ProveedorDAO(); //Instacia a DAO PROVEEDOR
   
    public String agregarProveedor(Proveedor prov){
        Connection con = Conexion.getConnection();
        try{
            mensaje = prodao.agregarProveedor(con, prov);
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
    
    
    public String modificarProveedor(Proveedor prov){
        Connection con = Conexion.getConnection();
        try{
            mensaje = prodao.modificarProveedor(con, prov);
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
    
    
    public String eliminarProveedor(int id){
        Connection con = Conexion.getConnection();
        try{
            mensaje = prodao.eliminarProveedor(con, id);
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
    
    
    public void listarProveedor(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        prodao.listarProveedor(con, tabla);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    
    //lista los provedores activos
    public void ListarProvAct(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        prodao.ListarProvAct(con, tabla);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    
    
    public int getMaxID(){
        Connection con = Conexion.getConnection();
        int id = prodao.getMaxID(con);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
        return id;
    }
}

