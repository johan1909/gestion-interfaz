package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Administrador extends Persona{

    private LinkedList<Cliente> listaClientes;

    /**
     * constructor de la clase
     */
    public Administrador(String nombre, String apellido, String cedula, String telefono, String correo,
            LinkedList<Cliente> listaClientes) {
        super(nombre, apellido, cedula, telefono, correo);
        this.listaClientes = listaClientes;
    }

    /**
     * metodo para agregar un cliente
     */
    public String agregarCliente(Cliente cliente){
        if (buscarCliente(cliente.getNombre(), cliente.getCedula()) != null){
            return "El cliente ya existe";
        }
        listaClientes.add(cliente);
        return "El cliente ha sido agregado";
    }


    /**
     * metodo para obtener la lista de clientes
     */
    public LinkedList<Cliente> obtenerClientes(){
        return listaClientes;
    }

    /**
     * metodo set
     */
    public void setListaClientes(LinkedList<Cliente> listaClientes){
        this.listaClientes=listaClientes;
    }

    /**
     * metodo para buscar a un cliente
     */
    public Cliente buscarCliente(String nombre, String cedula){
        for (Cliente cliente : listaClientes){
            if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getCedula().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }

    /**
     * metodo para actualizar a un cliente
     */
    public String actualizarCliente(String nombre, String apellido, String cedula, String telefono, String correo, String direccion){
        Cliente cliente = buscarCliente(nombre, cedula);
        if (cliente != null){
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCedula(cedula);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);
            cliente.setDireccion(direccion);
            return "EL cliente ha sido actualizado";
        }
        return "El cliente no fue encontrado";
    }

    /**
     * metodo para eliminar un cliente
     */






    
    public String eliminarCliente(String nombre, String cedula){
        String mensaje = "\nEl cliente no existe.";

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente clienteAux = listaClientes.get(i);
            if (listaClientes != null) {
                if (clienteAux.getNombre().equals(nombre) && clienteAux.getCedula().equals(cedula)) {
                    listaClientes.remove(i);
                    mensaje = "\nEl cliente ha sido eliminado correctamente.";
                    return mensaje;
                }
            }
        }
        return mensaje;
    }
}