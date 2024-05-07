package Cliente;

import Paquete.Paquete;
import java.util.ArrayList;
import java.util.List;

public class Cliente01 {
    private int idClie;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private List<DireccionEntrega> direcciones = new ArrayList<>();
    private Paquete paquetes;

    public Paquete getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(Paquete paquetes) {
        this.paquetes = paquetes;
    }

    public Cliente01(int idClie, String cedula, String nombres, String apellidos, String email) {
        this.idClie = idClie;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Cliente01() {
    }

    public void agregarDireccion(DireccionEntrega direccion) {
        for (DireccionEntrega dir : direcciones) {
            if (dir.equals(direccion)) {
                System.out.println("Error: La dirección ya existe.");
                return;
            }
        }
        direcciones.forEach(dir -> dir.setActual(false));
        direccion.setActual(true);
        direcciones.add(direccion);
    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DireccionEntrega> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<DireccionEntrega> direcciones) {
        this.direcciones = direcciones;
    }


    @Override
    public String toString() {
        return "Cliente01{" + "idClie=" + idClie + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", direcciones=" + direcciones + '}';
    }
}
