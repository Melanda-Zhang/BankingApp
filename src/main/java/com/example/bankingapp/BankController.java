package com.example.bankingapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class BankController{

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    private Button loginButton;


    public BankingApp userbank;

    private boolean loginSuccessful = false;

    private boolean signedUp = false;

    @FXML
    private void onClickedSignUp(){
        if(!username.getText().isEmpty() && !password.getText().isEmpty()){
            userbank = new BankingApp(username.getText(), password.getText());
            username.clear();
            password.clear();
            signedUp = true;
        }

    }

    @FXML
    private void Login() throws Exception{

        if(!signedUp){
            Alert alert = new Alert(Alert.AlertType.WARNING, "PLEASE SIGN UP TO USE OUR PORTAL");
            Optional<ButtonType> result = alert.showAndWait();
            username.clear();
            password.clear();
        }
        else{
            if(!username.getText().isEmpty() &&
                    !password.getText().isEmpty() &&
                    userbank.isSignUp() &&
                    userbank.Login(username.getText(),password.getText())){

                Parent root = FXMLLoader.load(getClass().getResource("BankingApp.fxml"));
                Stage window = (Stage) loginButton.getScene().getWindow();
                window.setScene(new Scene(root));
                loginSuccessful = true;

            }
            else
            {
                System.out.println("Unsuccessful");
                Alert alert = new Alert(Alert.AlertType.WARNING, "User and password not avaliable");
                Optional<ButtonType> result = alert.showAndWait();
                username.clear();
                password.clear();
            }
        }

    }


    public String transderInfo(){
        return userbank.getUsername();
    }



//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        if(loginSuccessful) {
//            SetWelcomeMessage();
//        }
//    }







}
