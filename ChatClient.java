package ru.gb.gbchat1;

import java.io.*;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;

public class ChatClient {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private ClientController controller;
    private volatile boolean clientConnectSuccess;
    private Deque <String> chatHistory;
    public ChatClient(ClientController controller) {
        this.clientConnectSuccess = false;
        this.controller = controller;
        chatHistory = new ArrayDeque<>();
    }

    public void openConnection() throws IOException {
        socket = new Socket("localhost", 8189);
        in = new DataInputStream(socket.getInputStream());
        out  = new DataOutputStream(socket.getOutputStream());

        Thread trTime = new Thread(()->{
            long time = System.currentTimeMillis(); //запускаем таймер
            while((System.currentTimeMillis() - time) < 120000);
            //тут была ошибка. через 2 минуты клиенты вылетали по таймеру. теперь нет :)
            if(!clientConnectSuccess){
                sendMessage("/end");
                closeConnection();
            }
        });
        trTime.setDaemon(true);
        trTime.start();
        //*****************************************************************
        Thread trWaitAuth = new Thread(()->{
            try {
                waitAuth();
                readMessage();
            }catch(Exception e){
                e.getStackTrace();
            }
            finally {
                writeChatHistory(); //файл будет записан полюбому
                closeConnection();
            }
        });
        trWaitAuth.setDaemon(true);
        trWaitAuth.start();

    }

    private void closeConnection(){
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.exit(0);
    }

    private void readMessage() {
        while(true){
            try{
                final String msg = in.readUTF();
                if("/end".equals(msg)){
                    //writeChatHistory();
                    controller.toggleBoxesVisibility(false);
                    break;
                }
                controller.addMessage(msg);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void waitAuth() throws Exception {
        while (true)
        {
            try {
                final String msg = in.readUTF();
                if(msg.startsWith("/authok")){
                    final String[] split = msg.split(" ");
                    this.nick = split[1];
                    controller.toggleBoxesVisibility(true);
                    controller.addMessage("Успешная авторизация под ником " + nick);
                    clientConnectSuccess = true;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String s) {
        try {
            out.writeUTF(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * добаление строки из окна клиента
     * @param msg
     */
    public void saveChatHistory(String msg){

        chatHistory.addLast(msg);
    }

    /**
     * Запись сеанса клиента в файл
     */
    public void writeChatHistory(){
        if(!chatHistory.isEmpty()){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("history_" + nick + ".txt",true))) {
                while(chatHistory.peek()!=null){
                    writer.write(chatHistory.pop());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
