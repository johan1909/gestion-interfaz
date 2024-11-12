package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;

    public Camioneta(String matricula, String marca, String modelo, String tipo, double tarifa, int horas,
            double capacidadCarga) {
        super(matricula, marca, modelo, tipo, tarifa, horas);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
