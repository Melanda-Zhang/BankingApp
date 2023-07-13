package com.example.bankingapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppController extends BankController implements Initializable {

    @FXML
    private Label welcomeMessage;
    @FXML
    private Label bankAmount;
    @FXML
    private TextField withdraw_deposite;
    @FXML
    private Label bankMessage;

    private double bankingAmount = 0;

    @FXML
    private void SetWelcomeMessage(){
        java.util.Date date = new java.util.Date();
        welcomeMessage.setText("Hi " + "Melanda " + "today's date and time is " + date);
    }

    @FXML
    private void setBankAmount(double a) {
        String dollerSign = "$";
        String bankingAmountString = String.valueOf(bankingAmount);
        bankAmount.setText(dollerSign + bankingAmountString);
    }

    @FXML
    private double getWithdraw_deposite(){
        return Double.parseDouble(withdraw_deposite.getText());

    }

    @FXML
    private void DepositePressed(){
        if(withdraw_deposite.getText().matches("[0-9]+")) {
            bankingAmount += getWithdraw_deposite();
            setBankAmount(bankingAmount);
            withdraw_deposite.clear();
            bankMessage.setText("Deposit Successfu");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Only Numbers allowed!");
            Optional<ButtonType> result = alert.showAndWait();
            withdraw_deposite.clear();
        }
    }

    @FXML
    private void WithdrawPressed() {
        if (withdraw_deposite.getText().matches("[0-9]+")) {
            if (bankingAmount - getWithdraw_deposite() < 0) {
                bankMessage.setText("withdraw failed");
                withdraw_deposite.clear();
            } else {
                bankingAmount -= getWithdraw_deposite();
                setBankAmount(bankingAmount);
                withdraw_deposite.clear();
                bankMessage.setText("Withdraw Successful");
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Only Numbers allowed!");
            Optional<ButtonType> result = alert.showAndWait();
            withdraw_deposite.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetWelcomeMessage();
        setBankAmount(bankingAmount);
    }
}
