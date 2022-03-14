module com.mycompany.stargame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.stargame to javafx.fxml;
    exports com.mycompany.stargame;
}
