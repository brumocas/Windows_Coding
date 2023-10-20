package com.example.csssetyling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    try{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        //String css = this.getClass().getResource("def.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.show();
    }catch (Exception e){
        e.printStackTrace();
    }

    }

    public static void main(String[] args) {
        launch(args);
    }
}