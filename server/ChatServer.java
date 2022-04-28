package ru.gb.gbchat1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChatServer {
    private final Map<String, ClientHandler> clients;
    private  AuthService authService;
    public ChatServer(){
        clients = new HashMap<>();
        authService = new InMemoryAuthService();
        try {
            authService.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void run() {
       try(ServerSocket serverSocket = new ServerSocket(8189))
            {
           while(true){
               System.out.println("Ожидаем подключения клиента");
               final Socket socket = serverSocket.accept();
               ClientHandler clientHandler = new ClientHandler(socket,this,authService);
               System.out.println("Клиент подключился");
           }
       }catch(IOException e){
           throw  new RuntimeException("Ошибка сервера", e);
       }
    }

    public boolean isNickBusy(String nick) {
        return clients.containsKey(nick);
    }


    public void broadcast(String msg) {
        clients.values().forEach(client -> client.sendMessage(msg));
    }


    public void subscribe(ClientHandler client) {
        clients.put(client.getNick(), client);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client.getNick());
        broadcastClientList();
    }

    public void sendMessageToClient(ClientHandler sender, String to, String message) {
        final ClientHandler receiver = clients.get(to);
        if (receiver != null) {
            receiver.sendMessage("от " + sender.getNick() + ": " + message);
            sender.sendMessage("участнику " + to + ": " + message);
        } else {
            sender.sendMessage("/error"+ " Участника с ником " + to + " нет в чате!");
        }
    }

    private void broadcastClientList() {
        StringBuilder nicks = new StringBuilder();
        for (ClientHandler value : clients.values()) {
            nicks.append(value.getNick()).append(" ");
        }
//        final String nicks = clients.values().stream()
//                .map(ClientHandler::getNick)
//                .collect(Collectors.joining(" "));
        broadcast("Message"+ nicks.toString().trim());
    }
}
