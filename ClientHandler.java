package ru.gb.gbchat1.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {
    private final Socket socket;
    private ChatServer server;
    private AuthService authService;
    private String nick;
    private final DataInputStream in;
    private final DataOutputStream out;

    public ClientHandler(Socket socket, ChatServer server,AuthService authService) {
        try {
            this.socket = socket;
            this.server = server;
            this.authService = authService;
            this.in = new DataInputStream(socket.getInputStream());
            this.out  = new DataOutputStream(socket.getOutputStream());
            //вариант запуска потока через ExecutorService
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(()->{
                try {
                    autenticate();
                    readMessage();
                }finally {
                    closeConnection();
                }
            });
            executorService.shutdown();
            /* вариант запуска потока через Thread
            new Thread(()->{
                try {
                    autenticate();
                    readMessage();
                }finally {
                    closeConnection();
                }
            }).start();

             */

        } catch (IOException e) {
            throw new RuntimeException(" Ошибка создания подключения к клиенту", e);
        }
    }

    private void readMessage() {
        try {
            while (true) {
                final String msg = in.readUTF();
                if(msg.startsWith("/w")){
                    final String[] s = msg.split(" ");
                    final String nick = s[1];
                    final String message = s[2];
                    if (server.isNickBusy(nick)) {
                        server.sendMessageToClient(this, nick, message);
                        continue;
                    }
                }
                server.broadcast(nick + ": " + msg);
                if("/end".equalsIgnoreCase(msg)){
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void autenticate() {
        while(true){
            try {
                final String msg = in.readUTF();
                if(msg.startsWith("/auth")){
                    final String[] s = msg.split(" ");
                    final String login = s[1];
                    final String password = s[2];
                    String nick = authService.getNickByLoginAndPassword(login, password);
                    if(nick != null){
                        if(server.isNickBusy(nick)){
                            sendMessage("Пользователь уже авторизован");
                            continue;
                        }
                        sendMessage("/authok " + nick);
                        this.nick = nick;
                        server.broadcast("Пользователь " + nick + " вошел в чат");
                        server.subscribe(this);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection() {
        sendMessage("/end");
        try{
            if(in != null)in.close();
        }catch (IOException e) {
            throw new RuntimeException(" Ошибка отключения", e);
        }
        try{
            if(out != null)out.close();
        }catch (IOException e) {
            throw new RuntimeException(" Ошибка отключения", e);
        }
        try{
            if(socket != null){
                server.unsubscribe(this);
                socket.close();
            }
        }catch (IOException e) {
            throw new RuntimeException(" Ошибка отключения", e);
        }
    }

    public void sendMessage(String message) {
        try {
            System.out.println("Отправляем сообщение");
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return this.nick;
    }
}