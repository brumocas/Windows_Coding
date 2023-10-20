package com.example.scenebuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;
    private int moveValue = 10;


    public void up(ActionEvent e){
        System.out.println("Up");
        myCircle.setCenterY(y-=moveValue);
    }
    public void down(ActionEvent e){
        System.out.println("Down");
        myCircle.setCenterY(y+=moveValue);
    }
    public void left(ActionEvent e){
        System.out.println("Left");
        myCircle.setCenterX(x-=moveValue);
    }
    public void right(ActionEvent e){
        System.out.println("Right");
        myCircle.setCenterX(x+=moveValue);
    }

}