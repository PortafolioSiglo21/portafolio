
import Controlador.ProveedorDO;
import Modelo.Proveedor;


/**
 *
 * @author samuel
 */
public class Test {
    
    ProveedorDO dot = new ProveedorDO();
    Proveedor pro = new Proveedor();
    String mensaje = "";     
    
    
     ///***test de ingreos proveedor**////
    public void insertar(){
    pro.setRUT_PROVEEDOR("PRUEBAGGG");
    pro.setPROVEEDOR("prueba");
    pro.setNOMBRE_CONTACTO("pruebna");
    pro.setTELEFONOS("555555");
    pro.setSITIO_WEB("prueba.cl");
    pro.setMAIL_PROVEEDOR("pruyeba@hola.cl");
    pro.setID_ADMIN("1");
    mensaje= dot.agregarProveedor(pro);
    System.out.println(mensaje);
    }
    
    
    public static void main(String[] args) {
        Test test = new Test();
        test.insertar();
        
    }
}
