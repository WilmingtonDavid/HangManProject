module com.example.hangman {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;


    opens com.example.hangman to javafx.fxml;
    exports com.example.hangman;
}