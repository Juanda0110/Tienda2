package co.edu.poli.TiendaJJM.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("formulario.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tienda JJM");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}