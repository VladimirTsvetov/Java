package ru.gb.gbchat1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private  List<ClientHandler> clients;
    private  AuthService authService;
    public ChatServer(){
        clients = new ArrayList<>();
        authService = new InMemoryAuthService();
        authService.start();
    }
    public void run() {
       try(ServerSocket serverSocket = new ServerSocket(8189);
           ) {
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
        for(ClientHandler client: clients){
            if(client.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public void broadcast(String msg) {
        for(ClientHandler client: clients){
            client.sendMessage(msg);
        }

    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);

    }
}
