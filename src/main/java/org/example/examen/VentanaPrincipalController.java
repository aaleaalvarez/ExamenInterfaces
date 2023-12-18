package org.example.examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.example.examen.models.Cliente;
import org.example.examen.models.Entrada;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaPrincipalController implements Initializable {

    @FXML
    private TextField matriculaField;
    @FXML
    private ComboBox<String> modeloCombo;
    @FXML
    private ChoiceBox<Cliente> clienteField;
    @FXML
    private DatePicker entradaDate;
    @FXML
    private DatePicker salidaDate;
    @FXML
    private Label infoCoste;
    @FXML
    private Button añadir;
    @FXML
    private Button salir;
    @FXML
    private TableColumn<Entrada, String> cMatricula;
    @FXML
    private TableColumn<Entrada, String> cModelo;
    @FXML
    private TableColumn<Entrada, String> cEntrada;
    @FXML
    private TableColumn<Entrada, String> cSalida;
    @FXML
    private TableColumn<Entrada, String> cCliente;
    @FXML
    private TableColumn<Entrada, String> cTarifa;
    @FXML
    private TableColumn<Entrada, String> cCoste;
    @FXML
    private Label info;
    @FXML
    private TableView<Entrada> tabla;
    @FXML
    private RadioButton standard;
    @FXML
    private RadioButton oferta;
    @FXML
    private RadioButton largaDuracion;
    @FXML
    private ToggleGroup eleccion;

    @FXML
    public void añadirEntrada(ActionEvent actionEvent) {
        if (!matriculaField.getText().isEmpty()
                && modeloCombo.getValue() != null
                && clienteField.getValue() != null
                && entradaDate.getValue() != null
                && salidaDate.getValue() != null) {
            Entrada entrada = new Entrada();
            entrada.setMatricula(matriculaField.getText());
            entrada.setModelo(modeloCombo.getSelectionModel().getSelectedItem());
            entrada.setCliente(clienteField.getSelectionModel().getSelectedItem().toString());
            entrada.setEntrada(entradaDate.getValue());
            entrada.setSalida(salidaDate.getValue());

            tabla.getItems().add(entrada);
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Todos los campos deben ser completados.");

        }
    }

    private void limpiarCampos() {
        matriculaField.clear();
        modeloCombo.getSelectionModel().clearSelection();
        clienteField.getSelectionModel().clearSelection();
        standard.setSelected(false);
        oferta.setSelected(false);
        largaDuracion.setSelected(false);
        entradaDate.setValue(null);
        salidaDate.setValue(null);
        infoCoste.setText("");

    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> modelos = FXCollections.observableArrayList();
        modelos.addAll("Peugeot", "Mazda", "Tesla", "Volkswagen");
        modeloCombo.setItems(modelos);
        modeloCombo.getSelectionModel().selectFirst();
        modeloCombo.setEditable(true);

        ObservableList<Cliente> clientes = FXCollections.observableArrayList(
                new Cliente(1, "Ale", "correoale@correo.com"),
                new Cliente(2, "Xemi", "correoxemi@correo.com"),
                new Cliente(3, "Rafa", "correorafa@correo.com")
        );
        clienteField.setItems(clientes);
        clienteField.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                return cliente == null ? null : cliente.getNombre();
            }

            @Override
            public Cliente fromString(String s) {
                return null;
            }
        });

        cMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        cModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        cCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        cTarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa"));
        cEntrada.setCellValueFactory(new PropertyValueFactory<>("entrada"));
        cSalida.setCellValueFactory(new PropertyValueFactory<>("salida"));
        cCoste.setCellValueFactory(new PropertyValueFactory<>("coste"));


    }


    @FXML
    public void informacionAlumno(Event event) {
        String nombreAlumno = "Alejandro Álvarez Mérida";
        String ciclo = "Desarrollo de Aplicaciones Multiplataforma";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Información del alumno:");

        alert.setContentText("Nombre del Alumno: " + nombreAlumno + "\nCiclo: " + ciclo);

        // Muestra el Alert
        alert.showAndWait();
    }
}