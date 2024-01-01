package com.example.imageview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.Objects;

public class HelloController {

    @FXML
    private Button mybutton;

    @FXML
    private ImageView myimage;

    //Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("2.png")));

    public void changeImage(){
        //myimage.setImage(image);
        System.out.println("Change Image");
    }
}