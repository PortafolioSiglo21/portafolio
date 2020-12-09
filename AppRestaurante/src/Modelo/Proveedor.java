/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JTextField;

/**
 *
 * @author samuel
 */
public class Proveedor {
    int ID_PROVEEDOR;
    String RUT_PROVEEDOR;
    String PROVEEDOR;
    String NOMBRE_CONTACTO;
    String TELEFONOS;
    String SITIO_WEB;
    String MAIL_PROVEEDOR;
    String ID_ADMIN;
    String ESTADO_PROVEDOR;
    
public Proveedor(){
  }

    public Proveedor(int ID_PROVEEDOR, String RUT_PROVEEDOR, String PROVEEDOR, String NOMBRE_CONTACTO, String TELEFONOS, String SITIO_WEB, String MAIL_PROVEEDOR, String ID_ADMIN, String ESTADO_PROVEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
        this.RUT_PROVEEDOR = RUT_PROVEEDOR;
        this.PROVEEDOR = PROVEEDOR;
        this.NOMBRE_CONTACTO = NOMBRE_CONTACTO;
        this.TELEFONOS = TELEFONOS;
        this.SITIO_WEB = SITIO_WEB;
        this.MAIL_PROVEEDOR = MAIL_PROVEEDOR;
        this.ID_ADMIN = ID_ADMIN;
        this.ESTADO_PROVEDOR = ESTADO_PROVEDOR;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public String getRUT_PROVEEDOR() {
        return RUT_PROVEEDOR;
    }

    public void setRUT_PROVEEDOR(String RUT_PROVEEDOR) {
        this.RUT_PROVEEDOR = RUT_PROVEEDOR;
    }

    public String getPROVEEDOR() {
        return PROVEEDOR;
    }

    public void setPROVEEDOR(String PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    public String getNOMBRE_CONTACTO() {
        return NOMBRE_CONTACTO;
    }

    public void setNOMBRE_CONTACTO(String NOMBRE_CONTACTO) {
        this.NOMBRE_CONTACTO = NOMBRE_CONTACTO;
    }

    public String getTELEFONOS() {
        return TELEFONOS;
    }

    public void setTELEFONOS(String TELEFONOS) {
        this.TELEFONOS = TELEFONOS;
    }

    public String getSITIO_WEB() {
        return SITIO_WEB;
    }

    public void setSITIO_WEB(String SITIO_WEB) {
        this.SITIO_WEB = SITIO_WEB;
    }

    public String getMAIL_PROVEEDOR() {
        return MAIL_PROVEEDOR;
    }

    public void setMAIL_PROVEEDOR(String MAIL_PROVEEDOR) {
        this.MAIL_PROVEEDOR = MAIL_PROVEEDOR;
    }

    public String getID_ADMIN() {
        return ID_ADMIN;
    }

    public void setID_ADMIN(String ID_ADMIN) {
        this.ID_ADMIN = ID_ADMIN;
    }

    public String getESTADO_PROVEDOR() {
        return ESTADO_PROVEDOR;
    }

    public void setESTADO_PROVEDOR(String ESTADO_PROVEDOR) {
        this.ESTADO_PROVEDOR = ESTADO_PROVEDOR;
    }
    
    
}
