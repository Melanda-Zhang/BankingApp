module com.example.bankingapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankingapp to javafx.fxml;
    exports com.example.bankingapp;
}