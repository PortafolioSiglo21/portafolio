/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Pedido_Provedor;
import Modelo.Pedido_ProvedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author samuel
 */
public class Pedido_ProvedorDO {
    String mensaje;
    Pedido_ProvedorDAO peprodao= new Pedido_ProvedorDAO();
    
    public int getMaxIDPedido(){
        Connection con = Conexion.getConnection();
        int id = peprodao.getMaxIDPedido(con);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
        return id;
    }
    
    ///****/
    public String AgregarPedido(Pedido_Provedor pp){
        Connection con = Conexion.getConnection();
            try{
                mensaje = peprodao.AgregarPedido(con, pp);
                //con.rollback();
                //con.commit();
                con.setAutoCommit(true);
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
    
    public void listarProductos(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        peprodao.listarProductos(con, tabla);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    
    public void listar(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        peprodao.listar(con, tabla, mensaje);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    
    public String ActualizarEstado(Pedido_Provedor pp){
        Connection con = Conexion.getConnection();
        try{
            mensaje = peprodao.ActualizarEstado(con, pp);
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
    
    public void listarPedido(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        peprodao.listarPedido(con, tabla, mensaje);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
    
    
    
        public void listarPagado(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        peprodao.listarPagado(con, tabla, mensaje);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
}
