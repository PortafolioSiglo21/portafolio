/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Productos;
import Modelo.ProductosDAO;
import Modelo.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author samuel
 */
public class ProductosDO {
    String mensaje;
    ProductosDAO produdao = new ProductosDAO();
    
    public String agregarProductos(Productos produc){
        Connection con = Conexion.getConnection();
        try{
            mensaje = produdao.agregarProducto(con, produc);
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
    
    public int getMaxIDProductos(){
        Connection con = Conexion.getConnection();
        int id = produdao.getMaxIDProductos(con);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
        return id;
    }
    
    
    public void listarProductos(JTable tabla) throws SQLException{
        Connection con = Conexion.getConnection();
        produdao.listarProductos(con, tabla);
        try{
            con.close();
        }catch(Exception ex){
            System.out.println(""+ ex.getMessage());
        }
    }
}
