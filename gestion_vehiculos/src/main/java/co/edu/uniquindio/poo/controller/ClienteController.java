package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;



public class ClienteController {

    Empresa empresa;

    public ClienteController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return empresa.getListaClientes();
    }

    public boolean eliminarCliente(String cedula) {
       return empresa.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String matricula, Cliente cliente) {
       return empresa.actualizarCliente(matricula, cliente);
    }

}
