package com.poligran.bugtracker.vista;

import com.poligran.bugtracker.controlador.BugController;
import com.poligran.bugtracker.modelo.Bug;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorFormulario {

    @FXML private TextField txtId;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtPrioridad;
    @FXML private TextField txtEstado;
    @FXML private ListView<String> listaBugs;

    private final BugController controlador = new BugController();

    @FXML
    public void agregarBug() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String titulo = txtTitulo.getText();
            String descripcion = txtDescripcion.getText();
            String prioridad = txtPrioridad.getText();
            String estado = txtEstado.getText();

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

    private void actualizarLista() {
        listaBugs.getItems().clear();
        for (Bug bug : controlador.listBugs()) {
            listaBugs.getItems().add(
                bug.getId() + " - " + bug.getTitle() + " - " + bug.getStatus()
            );
        }
    }
}
