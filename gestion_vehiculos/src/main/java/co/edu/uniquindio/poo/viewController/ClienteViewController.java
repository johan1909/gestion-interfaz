package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteViewController {

    private ClienteController clienteController;
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private Cliente selectedCliente;
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtApellidos, txtDireccion, txtCliente, txtCedula, txtTelefono, txtCorreo;

    @FXML
    private TableColumn<Cliente, String> tbcDireccion, tbcCedula, tbcNombre, tbcApellidos, tbcTelefono, tbcCorreo;

    @FXML
    private Button btnActualizarCliente, btbAgregarCliente, btnEliminarCliente, btnLimpiarCliente, btnSiguiente;

    @FXML
    private TableView<Cliente> tblListClientes;

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {
        actualizarCliente();
    }

    @FXML
    void onLimpiarCliente(ActionEvent event) {
        limpiarCamposCliente();
    }

    @FXML
    void onEliminarCliente(ActionEvent event) {
        eliminarCliente();
    }

    @FXML
    void onSiguiente(ActionEvent event) {
        
        app.openCrudVehiculo();
    }

    @FXML
    void initialize() {
        // Aquí inicializamos el clienteController para evitar el NullPointerException
        this.clienteController = new ClienteController(App.empresa);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tblListClientes.setItems(listaClientes);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tbcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
    }

    private void obtenerClientes() {
        listaClientes.addAll(clienteController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tblListClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getCedula());
            txtCliente.setText(cliente.getNombre());
            txtApellidos.setText(cliente.getApellido());
            txtDireccion.setText(cliente.getDireccion());
            txtTelefono.setText(cliente.getTelefono());
            txtCedula.setText(cliente.getCedula());
        }
    }

    private String agregarCliente() {
        Cliente cliente = buildCliente();
        if (cliente != null && clienteController.crearCliente(cliente)) {
            listaClientes.add(cliente);
            tblListClientes.refresh();
            limpiarCamposCliente();
            return "Cliente agregado exitosamente.";
        } else {
            mostrarAlerta("Error", "No se pudo agregar el cliente.");
            return "Error: No se pudo agregar el cliente.";
        }
    }

    private void actualizarCliente() {
        if (selectedCliente != null &&
            clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

            int index = listaClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listaClientes.set(index, buildCliente());
            }

            tblListClientes.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }

    private void eliminarCliente() {
        if (clienteController.eliminarCliente(txtCedula.getText())) {
            listaClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }

    private Cliente buildCliente() {
        return new Cliente(
            txtCedula.getText(),
            txtCliente.getText(),
            txtApellidos.getText(),
            txtDireccion.getText(),
            txtTelefono.getText(),
            txtCorreo.getText());
        
    }

    private void limpiarSeleccion() {
        tblListClientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtCliente.clear();
        txtApellidos.clear();
        txtDireccion.clear();
        txtTelefono.clear();
        txtCorreo.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
        this.clienteController = new ClienteController(app.getEmpresa());
        initView();
    }
}
