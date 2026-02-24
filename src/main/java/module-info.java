module com.example.csc325_feb23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc325_feb23 to javafx.fxml;
    exports com.example.csc325_feb23;
}