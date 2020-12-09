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
public class Pedido_Provedor {
    int ID_PEDIDO; 
    String PRODUCTO;
    String CATEGORIA;
    String DESCRIPCION;
    int CANTIDAD;
    double IVA; 
    double TOTAL_PAGAR; 
    String FECH_SOLICITUD;
    String FECH_RECEPCION;
    String FECH_PAGO;
    String FECH_PEDIDO;
    String ESTADO_PEDIDO;
    int ID_PROVEEDOR;
    int ID_EMPLEADO;
    double PRECIO;

    
    public Pedido_Provedor() {
        
    }

    public int getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public void setID_PEDIDO(int ID_PEDIDO) {
        this.ID_PEDIDO = ID_PEDIDO;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTOTAL_PAGAR() {
        return TOTAL_PAGAR;
    }

    public void setTOTAL_PAGAR(double TOTAL_PAGAR) {
        this.TOTAL_PAGAR = TOTAL_PAGAR;
    }

    public String getFECH_SOLICITUD() {
        return FECH_SOLICITUD;
    }

    public void setFECH_SOLICITUD(String FECH_SOLICITUD) {
        this.FECH_SOLICITUD = FECH_SOLICITUD;
    }

    public String getFECH_RECEPCION() {
        return FECH_RECEPCION;
    }

    public void setFECH_RECEPCION(String FECH_RECEPCION) {
        this.FECH_RECEPCION = FECH_RECEPCION;
    }

    public String getFECH_PAGO() {
        return FECH_PAGO;
    }

    public void setFECH_PAGO(String FECH_PAGO) {
        this.FECH_PAGO = FECH_PAGO;
    }

    public String getFECH_PEDIDO() {
        return FECH_PEDIDO;
    }

    public void setFECH_PEDIDO(String FECH_PEDIDO) {
        this.FECH_PEDIDO = FECH_PEDIDO;
    }

    public String getESTADO_PEDIDO() {
        return ESTADO_PEDIDO;
    }

    public void setESTADO_PEDIDO(String ESTADO_PEDIDO) {
        this.ESTADO_PEDIDO = ESTADO_PEDIDO;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public int getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(int ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(double PRECIO) {
        this.PRECIO = PRECIO;
    }
    

    public Pedido_Provedor(int ID_PEDIDO, String PRODUCTO, String CATEGORIA, String DESCRIPCION, int CANTIDAD, double IVA, double TOTAL_PAGAR, String FECH_SOLICITUD, String FECH_RECEPCION, String FECH_PAGO, String FECH_PEDIDO, String ESTADO_PEDIDO, int ID_PROVEEDOR, int ID_EMPLEADO, double PRECIO) {
        this.ID_PEDIDO = ID_PEDIDO;
        this.PRODUCTO = PRODUCTO;
        this.CATEGORIA = CATEGORIA;
        this.DESCRIPCION = DESCRIPCION;
        this.CANTIDAD = CANTIDAD;
        this.IVA = IVA;
        this.TOTAL_PAGAR = TOTAL_PAGAR;
        this.FECH_SOLICITUD = FECH_SOLICITUD;
        this.FECH_RECEPCION = FECH_RECEPCION;
        this.FECH_PAGO = FECH_PAGO;
        this.FECH_PEDIDO = FECH_PEDIDO;
        this.ESTADO_PEDIDO = ESTADO_PEDIDO;
        this.ID_PROVEEDOR = ID_PROVEEDOR;
        this.ID_EMPLEADO = ID_EMPLEADO;
        this.PRECIO = PRECIO;
    }
    
}
