package com.wora.javafxproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage primaryStage; // Reference to the primary stage

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage; // Store the primary stage
        navigateTo("products-view.fxml"); // Load the initial view
        stage.setTitle("JavaFX Application"); // Set the window title
        stage.show();
    }

    // Method to navigate between views
    public static void navigateTo(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Set your preferred dimensions
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX Application - " + fxmlFile); // Optional: Update window title
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}