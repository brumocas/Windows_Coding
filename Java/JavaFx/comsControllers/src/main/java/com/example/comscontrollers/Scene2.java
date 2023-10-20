package com.example.comscontrollers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2 {
    @FXML
    Label nameLabel;

    public void displayName(String username){
        nameLabel.setText("Hello: " + username);
    }
}
