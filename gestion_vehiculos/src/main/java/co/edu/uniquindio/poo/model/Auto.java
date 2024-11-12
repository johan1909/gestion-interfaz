package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String matricula, String marca, String modelo, String tipo, double tarifa, int horas,
            int numeroPuertas) {
        super(matricula, marca, modelo, tipo, tarifa, horas);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

}
