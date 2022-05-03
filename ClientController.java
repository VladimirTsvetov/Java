package ru.gb.gbchat1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ClientController {

    private  ChatClient client;

    @FXML 
    private HBox loginBox;
    @FXML 
    private TextField loginField;
    @FXML 
    private PasswordField passwordField;
    @FXML 
    private Button authButton;
    @FXML 
    private VBox messageBox;
    @FXML 
    private TextArea messageArea;
    @FXML 
    private TextField textField;
    @FXML 
    private Button sendButton;

    public ClientController() {
        this.client = new ChatClient(this);
        try{
            client.openConnection();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public void authButtonClick(ActionEvent actionEvent) {
        client.sendMessage("/auth " + loginField.getText() + " " + passwordField.getText());
    }

    public void sendButtonClick(ActionEvent actionEvent) {
        final String text = textField.getText();
        if(text.trim().isEmpty())return;
        client.sendMessage(text);
        textField.clear();
        textField.requestFocus();
    }

    public void toggleBoxesVisibility(boolean isSuccess) {
        loginBox.setVisible(!isSuccess);
        messageBox.setVisible(isSuccess);
    }
     /**
     * передаем в клиент текст и добавляем дату и время
     * @param s
     */
    public void addMessage(String s) {
        Date date = new Date();
        messageArea.appendText(s + "\n");
        client.saveChatHistory(date.toString()+ ": " + s + "\n");            //записываем текст из окна отображения чата
    }

}
