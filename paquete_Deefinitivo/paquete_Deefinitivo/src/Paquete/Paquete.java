package Paquete;

import Cliente.Cliente01;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paquete {
    private int idPaq;
    private String codigo;
    private String descripcion;
    private double peso;
    private double largo;
    private double ancho;
    private ArrayList<Estado> estados;

    public Paquete(int idPaq, String codigo, String descripcion, double peso, double largo, double ancho, ArrayList<Estado> estados) {
        this.idPaq = idPaq;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.estados = estados;
    }
    
    public Paquete() {
        Date fecha = new Date();
        Estado estado1 = new Estado(1,"Creado", fecha );
        Estado estado2 = new Estado(2,"Despachado", null);
        Estado estado3 = new Estado(3,"Enviado", null);
        
        this.estados = new ArrayList();
        
        this.estados.add(estado1);
        this.estados.add(estado2);
        this.estados.add(estado3);
        
    }

    public int getIdPaq() {
        return idPaq;
    }

    public void setIdPaq(int idPaq) {
        this.idPaq = idPaq;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        String aux;
        aux = "ID del Paquete: " + idPaq
                + "\n Código: " + codigo
                + "\n Peso: " + descripcion
                + "\n Largo: " + largo
                + "\n Ancho: " + ancho;
        for (Estado es : estados) {
            aux = aux + "\n " + es;
        }

        return aux;
    } 
}
