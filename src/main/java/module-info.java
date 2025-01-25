module com.wora.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.wora.javafxproject to javafx.fxml;
    opens com.wora.javafxproject.controllers to javafx.fxml; // Add this line

    exports com.wora.javafxproject;
    exports com.wora.javafxproject.controllers to javafx.fxml;
}