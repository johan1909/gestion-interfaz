package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.model.Empresa;
import java.util.Collection;

public class VehiculoController {

    Empresa empresa;

    public VehiculoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearVehiculo(Vehiculo vehiculo) {
        return empresa.agregarVehiculo(vehiculo);
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return empresa.getVehiculos();
    }

    public boolean eliminarVehiculo(String matricula) {
       return empresa.eliminarVehiculo(matricula);
    }

    public boolean actualizarVehiculo(String matricula, Vehiculo vehiculo) {
       return empresa.actualizarVehiculo(matricula, vehiculo);
    }
}
