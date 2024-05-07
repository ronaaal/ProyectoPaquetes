package Paquete;

import java.util.Date;

public class Estado {

    private int idEst;
    private String estados;
    private Date fecha;

    public Estado(int idEst, String estados, Date fecha) {
        this.idEst = idEst;
        this.estados = estados;
        this.fecha = fecha;
    }

    public String getEstados() {
        return estados;
    }

    public Estado() {
    }

    public void setEstados(String estados) {
        this.estados = estados;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {

        String aux;
        aux = "Estado: " + estados
                + "\n Fecha: " + fecha;
        return aux;
    }
}
