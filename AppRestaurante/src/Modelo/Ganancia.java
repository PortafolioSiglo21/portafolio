package Modelo;

import javax.swing.JTextField;


public class Ganancia {
     int   ID_BOLETA;
     String  FECHA;
     int   IVA;
     int   TOTAL_PAGAR;
     int   EFECTIVO;
     int   CAMBIO;
    String RUT_CLIENTE;
     int   ID_EMPLEADO;
     int   ID_FORMA_PAGO;
    
public Ganancia(){
  }

    public Ganancia(int ID_BOLETA, String FECHA, int IVA, int TOTAL_PAGAR, int EFECTIVO, int CAMBIO, 
                    String RUT_CLIENTE, int ID_EMPLEADO, int ID_FORMA_PAGO) 
    {
        this.ID_BOLETA     = ID_BOLETA;
        this.FECHA         = FECHA;
        this.IVA           = IVA;
        this.TOTAL_PAGAR   = TOTAL_PAGAR;
        this.EFECTIVO      = EFECTIVO;
        this.CAMBIO        = CAMBIO;
        this.RUT_CLIENTE   = RUT_CLIENTE;
        this.ID_EMPLEADO   = ID_EMPLEADO;
        this.ID_FORMA_PAGO = ID_FORMA_PAGO;
    }

    public int getID_BOLETA() {
        return ID_BOLETA;
    }

    public void setID_BOLETA(int ID_BOLETA) {
        this.ID_BOLETA = ID_BOLETA;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }
    

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public int getTOTAL_PAGAR() {
        return TOTAL_PAGAR;
    }

    public void setTOTAL_PAGAR(int TOTAL_PAGAR) {
        this.TOTAL_PAGAR = TOTAL_PAGAR;
    }

    public int getEFECTIVO() {
        return EFECTIVO;
    }

    public void setEFECTIVO(int EFECTIVO) {
        this.EFECTIVO = EFECTIVO;
    }

    public int getCAMBIO() {
        return CAMBIO;
    }

    public void setCAMBIO(int CAMBIO) {
        this.CAMBIO = CAMBIO;
    }

    public String getRUT_CLIENTE() {
        return RUT_CLIENTE;
    }

    public void setRUT_CLIENTE(String RUT_CLIENTE) {
        this.RUT_CLIENTE = RUT_CLIENTE;
    }

    public int getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(int ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

    public int getID_FORMA_PAGO() {
        return ID_FORMA_PAGO;
    }

    public void setID_FORMA_PAGO(int ID_FORMA_PAGO) {
        this.ID_FORMA_PAGO = ID_FORMA_PAGO;
    }

    
    
}
