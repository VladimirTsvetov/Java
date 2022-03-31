package ru.gb.textwindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TextWindowController {

    public TextWindowController() {
        messageArea = new TextArea();
        messageField = new TextField();
    }
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;

    @FXML
    private void onSendButtonClick() {
        messageArea.appendText(messageField.getText() + '\n');
        messageField.clear();
    }
    @FXML
    private void onClearButtonClick(ActionEvent actionEvent) {
        messageArea.clear();
    }
}