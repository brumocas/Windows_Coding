package com.example.comscontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1 {

    @FXML
    TextField nameTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void login(ActionEvent event) throws IOException{

        String username = nameTextField.getText();
        System.out.println(username);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = loader.load();

        Scene2 scene2 = loader.getController();
        scene2.displayName(username);

        //root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}