module com.mycompany.stargame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.stargame to javafx.fxml;
    exports com.mycompany.stargame;
}
