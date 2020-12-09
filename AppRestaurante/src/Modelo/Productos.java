/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author samuel
 */
public class Productos {
    int ID_PRODUCTO;
    String NOMBRE;
    int PRECIO_UNITARIO;
    String DESCRIPCION;
    int ID_CATEGORIA;
    int ID_INGREDIENTE;
    int CANTIDAD;
    int STOCK_MINIMO;

    public Productos(int ID_PRODUCTO, String NOMBRE, int PRECIO_UNITARIO, String DESCRIPCION, int ID_CATEGORIA, int ID_INGREDIENTE, int CANTIDAD, int STOCK_MINIMO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.NOMBRE = NOMBRE;
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
        this.DESCRIPCION = DESCRIPCION;
        this.ID_CATEGORIA = ID_CATEGORIA;
        this.ID_INGREDIENTE = ID_INGREDIENTE;
        this.CANTIDAD = CANTIDAD;  
        this.STOCK_MINIMO = STOCK_MINIMO;
    }
    public Productos() {
        
    }

    

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getPRECIO_UNITARIO() {
        return PRECIO_UNITARIO;
    }

    public void setPRECIO_UNITARIO(int PRECIO_UNITARIO) {
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(int ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }

    public int getID_INGREDIENTE() {
        return ID_INGREDIENTE;
    }

    public void setID_INGREDIENTE(int ID_INGREDIENTE) {
        this.ID_INGREDIENTE = ID_INGREDIENTE;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }
    
    public int getSTOCK_MINIMO() {
        return STOCK_MINIMO;
    }

    public void setSTOCK_MINIMO(int STOCK_MINIMO) {
        this.STOCK_MINIMO = STOCK_MINIMO;
    }
    
}
