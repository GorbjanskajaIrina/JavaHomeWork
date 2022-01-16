package com.pb.gorbjanskaja.hw14;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatWindowController {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    static String forConnect;


    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        textArea.setText(textArea.getText() + "\n" + textField.getText());
        textField.clear();
    }
}
