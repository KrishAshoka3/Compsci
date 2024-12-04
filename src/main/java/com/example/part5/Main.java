package com.example.part5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/part5/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fitness Tracker");
        stage.setScene(scene);
        stage.show();

        // Prompt the user to add a client
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Client");
        dialog.setHeaderText("Please enter the client's name:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            MainController controller = fxmlLoader.getController();
            controller.addClient(name);
            System.out.println("Client added: " + name);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}