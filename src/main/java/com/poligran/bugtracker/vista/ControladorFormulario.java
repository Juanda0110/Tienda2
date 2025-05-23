package com.poligran.bugtracker.vista;

import com.poligran.bugtracker.controlador.BugController;
import com.poligran.bugtracker.modelo.Bug;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Optional;

public class ControladorFormulario {

    @FXML private TextField txtId;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrioridad;
    @FXML private TextField txtEstado;
    @FXML private ListView<String> listaBugs;
    @FXML private TextArea txtDetalles;
    @FXML private TextField txtBuscar;

    private final BugController controlador = new BugController();

    @FXML
    public void agregarBug() {
        try {
            if (txtId.getText().isEmpty() || txtTitulo.getText().isEmpty() ||
                txtDescripcion.getText().isEmpty() || txtPrioridad.getText().isEmpty() ||
                txtEstado.getText().isEmpty()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }
            int id = Integer.parseInt(txtId.getText());
            String titulo = txtTitulo.getText();
            String descripcion = txtDescripcion.getText();
            String prioridad = txtPrioridad.getText();
            String estado = txtEstado.getText();

            for (Bug b : controlador.listBugs()) {
                if (b.getId() == id) {
                    throw new IllegalArgumentException("El ID ya existe.");
                }
            }

            Bug bug = new Bug(id, titulo, descripcion, prioridad, estado);
            controlador.createBug(bug);
            actualizarLista();

            txtId.clear();
            txtTitulo.clear();
            txtDescripcion.clear();
            txtPrioridad.clear();
            txtEstado.clear();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al agregar bug: " + e.getMessage());
            alert.show();
        }
    }

    @FXML
    public void eliminarBug() {
        String seleccionado = listaBugs.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "¿Seguro que deseas eliminar este bug?");
            Optional<ButtonType> result = confirm.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                int id = Integer.parseInt(seleccionado.split(" - ")[0]);
                controlador.removeBug(id);
                actualizarLista();
                txtDetalles.clear();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selecciona un bug para eliminar.");
            alert.show();
        }
    }

    @FXML
    public void initialize() {
        actualizarLista();
        listaBugs.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> mostrarDetallesBug(newVal));
        txtBuscar.textProperty().addListener((obs, oldVal, newVal) -> actualizarLista());
    }

    private void mostrarDetallesBug(String seleccionado) {
        if (seleccionado != null) {
            int id = Integer.parseInt(seleccionado.split(" - ")[0]);
            for (Bug bug : controlador.listBugs()) {
                if (bug.getId() == id) {
                    txtDetalles.setText(
                        "ID: " + bug.getId() + "\n" +
                        "Título: " + bug.getTitle() + "\n" +
                        "Descripción: " + bug.getDescription() + "\n" +
                        "Prioridad: " + bug.getPriority() + "\n" +
                        "Estado: " + bug.getStatus() + "\n" +
                        "Fecha: " + bug.getCreationDate()
                    );
                    return;
                }
            }
        } else {
            txtDetalles.clear();
        }
    }

    private void actualizarLista() {
        listaBugs.getItems().clear();
        String filtro = txtBuscar.getText() != null ? txtBuscar.getText().toLowerCase() : "";
        for (Bug bug : controlador.listBugs()) {
            String texto = bug.getId() + " - " + bug.getTitle() + " - " + bug.getPriority() + " - " + bug.getStatus();
            if (filtro.isEmpty() || texto.toLowerCase().contains(filtro)) {
                listaBugs.getItems().add(texto);
            }
        }
    }

    @FXML
    public void actualizarEstadoBug() {
        String seleccionado = listaBugs.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            int id = Integer.parseInt(seleccionado.split(" - ")[0]);
            String nuevoEstado = txtEstado.getText();
            if (nuevoEstado.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Ingresa el nuevo estado.");
                alert.show();
                return;
            }
            controlador.changeBugStatus(id, nuevoEstado);
            actualizarLista();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selecciona un bug para actualizar.");
            alert.show();
        }
    }
}
