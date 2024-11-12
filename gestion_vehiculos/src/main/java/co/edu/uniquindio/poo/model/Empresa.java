package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Cliente> listaClientes;
    private Collection<Reserva> listaReservas;

    public Empresa(String nombre) {
        this.nombre = nombre;
        vehiculos = new LinkedList<>();
        listaClientes = new LinkedList<>();
    }

    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setvehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo) {
        boolean centinela = false;
        if (!verificarVehiculo(vehiculo.getMatricula())) {
            vehiculos.add(vehiculo);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarVehiculo(String matricula) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculos.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarVehiculo(String matricula, Vehiculo actualizado) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculo.setMatricula(actualizado.getMatricula());
                vehiculo.setMarca(actualizado.getMarca());
                vehiculo.setModelo(actualizado.getModelo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarVehiculo(String matricula) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                centinela = true;
            }
        }
        return centinela;
    }







    /**
     * metodo para agregar un cliente
     */
    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) { // Cambiar a !verificarCliente para añadir nuevos clientes
            listaClientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }
    
    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
                break; // Añadir break para salir del bucle una vez encontrado
            }
        }
        return centinela;
    }
    

   

    /**
     * metodo set
     */
    public void setListaClientes(LinkedList<Cliente> listaClientes){
        this.listaClientes=listaClientes;
    }


    

    /**
     * metodo para actualizar a un cliente
     */



     public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                cliente.setCedula(actualizado.getCedula());
                cliente.setTelefono(actualizado.getTelefono());
                cliente.setCorreo(actualizado.getCorreo());
                cliente.setDireccion(actualizado.getDireccion());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    




    /**
     * metodo para eliminar un cliente
     */
    

    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                listaClientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }


    




    /**
     * metodo para agregar un Reserva
     */
    public boolean agregarReserva(Reserva reserva) {
        boolean centinela = false;
        if (!verificarReserva(reserva.getCodigo())) { // Cambiar a !verificarCliente para añadir nuevos clientes
            listaReservas.add(reserva);
            centinela = true;
        }
        return centinela;
    }
    
    public boolean verificarReserva(String codigo) {
        boolean centinela = false;
        for (Reserva reserva : listaReservas) {
            if (reserva.getCodigo().equals(codigo)) {
                centinela = true;
                break; // Añadir break para salir del bucle una vez encontrado
            }
        }
        return centinela;
    }
    

   


    

    /**
     * metodo para actualizar a un cliente
     */



     public boolean actualizarReserva(String codigo, Reserva actualizado) {
        boolean centinela = false;
        for (Reserva reserva : listaReservas) {
            if (reserva.getCodigo().equals(codigo)) {
                reserva.setCliente(actualizado.getCliente());
                reserva.setVehiculo(actualizado.getVehiculo());
                reserva.setDias(actualizado.getDias());
                
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    




    /**
     * metodo para eliminar un cliente
     */
    

    
    public boolean eliminarReserva(String codigo) {
        boolean centinela = false;
        for (Reserva reserva : listaReservas) {
            if (reserva.getCodigo().equals(codigo)) {
                listaReservas.remove(reserva);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    
    
}
