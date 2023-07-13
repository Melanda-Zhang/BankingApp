package com.example.bankingapp;

public class BankingApp {


    private String username;
    private String password;
    private double bankAmount = 0;
    private boolean isLogin = false;
    private boolean isSignUp = false;

    public boolean isSignUp() {
        return isSignUp;
    }

    public BankingApp(String username, String password) {
        this.username = username;
        this.password = password;
        isSignUp = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(double bankAmount) {
        this.bankAmount = bankAmount;
    }

    public boolean Login(String username, String password){
        if(username.equals(getUsername()) && password.equals(getPassword()) && isSignUp){
            return true;
        }
        else{
            return false;
        }
    }

    public double Deposit(double money){
        bankAmount += money;
        return getBankAmount();
    }

    public double Withdraw(double money){
        bankAmount -= money;
        return getBankAmount();
    }

}
