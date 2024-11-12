package co.edu.uniquindio.poo.model;

public class Cliente extends Persona{
    private String direccion;

    public Cliente(String nombre, String apellido, String cedula, String telefono, String correo, String direccion){
        super(nombre, apellido, cedula, telefono, correo);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
