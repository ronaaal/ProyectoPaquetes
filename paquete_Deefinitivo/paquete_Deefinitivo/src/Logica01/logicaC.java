package Logica01;

import Cliente.Cliente01;
import Cliente.DireccionEntrega;
import java.util.regex.Pattern;


public class logicaC {
    public static boolean ValidaCedula(Cliente01 objCliente) {
        String regex = "\\d{10}"; // \d representa cualquier dígito, y {10} indica que debe repetirse 10 veces
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(objCliente.getCedula()).matches();
    }
    
    public static boolean validaCliente(Cliente01 objCliente) {
        return objCliente.getCedula() != null;
    }
    
    public static boolean validaDireccion(Cliente01 objCliente) {
        return objCliente.getDirecciones().isEmpty();
    }
    
    public static boolean validaDirecciones(DireccionEntrega objDirecciones) {
        return !objDirecciones.getCalle1().equals(objDirecciones.getCalle2());
    }
    
    public static boolean validaMail(Cliente01 objCliente) {
        String regex = ".*@.*\\.com$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(objCliente.getEmail()).matches();
    }
}
