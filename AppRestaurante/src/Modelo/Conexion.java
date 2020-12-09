/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import Vistas.InicioMenuPrincipalAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author samuel
 */
public class Conexion {
    //"jdbc:oracle:thin:@localhost:1521:ORCL";
    private static Connection conn = null;
    private static final String url = "jdbc:oracle:thin:@awsportafolio.cvt6px1zwifi.us-east-1.rds.amazonaws.com:1521:ORCL";
    private static String user = "admin";
    private static String pass = "portafolio";
    
    public static Connection getConnection(){
      try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          conn = DriverManager.getConnection(url, user, pass);
          conn.setAutoCommit(false);
          if(conn!=null){
              System.out.println("Conexion Existosa");
          }else{
              System.out.println("Error, Error");
          }
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "!!!!!!Conexion Erronea !!!!!"+ e.getMessage());
    }
      return conn;
    }
    
}