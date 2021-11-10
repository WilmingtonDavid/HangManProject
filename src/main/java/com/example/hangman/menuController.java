/*
menu controller switches scenes based off of button control events
we keep the stage the same by getting the button control parent node and casting it
to a new stage then we attach the scene to the stage and show the stage.
 */
package com.example.hangman;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

import java.io.IOException;

public class menuController{
    //type variables to switch the scenes
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label lblRules;


    @FXML
    public void switchToGame(ActionEvent event) throws IOException {
        //goes from menu screen to the game screen
        root = FXMLLoader.load(getClass().getResource("HangMan Prototype.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 403, 382);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToHelp(ActionEvent event) throws IOException{
        //goes from menu screen to help screen
        root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Help Menu");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void helpBackToMenu(ActionEvent event) throws IOException{
        //Button goes from help screen back to the menu screen
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }



}
