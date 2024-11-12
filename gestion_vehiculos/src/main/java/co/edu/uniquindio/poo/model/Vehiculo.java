package co.edu.uniquindio.poo.model;

public class Vehiculo {
    private String matricula, marca, modelo;
    private String tipo; 
    private double tarifa;
    private int horas;

    public Vehiculo(String matricula, String marca, String modelo, String tipo, double tarifa, int horas) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.horas = horas;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public double getTarifa() {
        return tarifa;
    }


    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }


    public int getHoras() {
        return horas;
    }


    public void setHoras(int horas) {
        this.horas = horas;
    }


    public double calcularTotal() {
       return tarifa * horas;
    }

    
}
