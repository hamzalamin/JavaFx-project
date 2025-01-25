module com.wora.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.wora.javafxproject to javafx.fxml;
    exports com.wora.javafxproject;
}