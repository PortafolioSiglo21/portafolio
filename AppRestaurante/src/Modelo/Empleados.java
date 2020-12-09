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
public class Empleados {
    int ID_EMPLEADO;
    String NOMBRES;
    String APELLIDOS;
    int ID_TIPO_EMPLEO;
    int ID_CARGO;
    int SALARIO;
    String NACIMIENTO;
    String DIRECCION;
    String TELEFONO;
    String CORREO;
    int ANIOS_EXPERIENCIA;
    String USUARIO;
    String PASS;
    String STATUS_EMPLEADO;
    String RUT_EMPLEADO;
    
    public Empleados(){
        
    }

    public int getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(int ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public int getID_TIPO_EMPLEO() {
        return ID_TIPO_EMPLEO;
    }

    public void setID_TIPO_EMPLEO(int ID_TIPO_EMPLEO) {
        this.ID_TIPO_EMPLEO = ID_TIPO_EMPLEO;
    }

    public int getID_CARGO() {
        return ID_CARGO;
    }

    public void setID_CARGO(int ID_CARGO) {
        this.ID_CARGO = ID_CARGO;
    }

    public int getSALARIO() {
        return SALARIO;
    }

    public void setSALARIO(int SALARIO) {
        this.SALARIO = SALARIO;
    }

    public String getNACIMIENTO() {
        return NACIMIENTO;
    }

    public void setNACIMIENTO(String NACIMIENTO) {
        this.NACIMIENTO = NACIMIENTO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public int getANIOS_EXPERIENCIA() {
        return ANIOS_EXPERIENCIA;
    }

    public void setANIOS_EXPERIENCIA(int ANIOS_EXPERIENCIA) {
        this.ANIOS_EXPERIENCIA = ANIOS_EXPERIENCIA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public String getSTATUS_EMPLEADO() {
        return STATUS_EMPLEADO;
    }

    public void setSTATUS_EMPLEADO(String STATUS_EMPLEADO) {
        this.STATUS_EMPLEADO = STATUS_EMPLEADO;
    }

    public String getRUT_EMPLEADO() {
        return RUT_EMPLEADO;
    }

    public void setRUT_EMPLEADO(String RUT_EMPLEADO) {
        this.RUT_EMPLEADO = RUT_EMPLEADO;
    }

    public Empleados(int ID_EMPLEADO, String NOMBRES, String APELLIDOS, int ID_TIPO_EMPLEO, int ID_CARGO, int SALARIO, String NACIMIENTO, String DIRECCION, String TELEFONO, String CORREO, int ANIOS_EXPERIENCIA, String USUARIO, String PASS, String STATUS_EMPLEADO, String RUT_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.ID_TIPO_EMPLEO = ID_TIPO_EMPLEO;
        this.ID_CARGO = ID_CARGO;
        this.SALARIO = SALARIO;
        this.NACIMIENTO = NACIMIENTO;
        this.DIRECCION = DIRECCION;
        this.TELEFONO = TELEFONO;
        this.CORREO = CORREO;
        this.ANIOS_EXPERIENCIA = ANIOS_EXPERIENCIA;
        this.USUARIO = USUARIO;
        this.PASS = PASS;
        this.STATUS_EMPLEADO = STATUS_EMPLEADO;
        this.RUT_EMPLEADO = RUT_EMPLEADO;
    }
    
    
}
