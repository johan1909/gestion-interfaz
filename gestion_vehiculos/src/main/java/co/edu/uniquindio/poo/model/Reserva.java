package co.edu.uniquindio.poo.model;

public class Reserva {

    private String codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int dias;

    public Reserva(String codigo,Cliente cliente, Vehiculo vehiculo, int dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getDias() {
        return dias;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }


    public double calcularCosto() {
        return vehiculo.calcularTotal();
    }

}
