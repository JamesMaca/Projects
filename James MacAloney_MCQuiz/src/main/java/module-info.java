module com.example.groupprojectme {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.groupprojectme to javafx.fxml;
    exports com.example.groupprojectme;
}