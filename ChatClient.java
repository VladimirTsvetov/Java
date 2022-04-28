package ru.gb.gbchat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private ClientController controller;

    public ChatClient(ClientController controller) {

        this.controller = controller;
    }
    public void openConnection() throws IOException {
        socket = new Socket("localhost", 8189);
        in = new DataInputStream(socket.getInputStream());
        out  = new DataOutputStream(socket.getOutputStream());
        //********************************************************************
        //вот здесь запускаем поток с отслеживанием времени
        //проверено на 5000 ms - окно закрывается, гипс снимают, клиент уезжает
        Thread trTime = new Thread(()->{
            long time = System.currentTimeMillis(); //запускаем таймер
            while((System.currentTimeMillis() - time) < 120000);
            //тут хочется добавить всплывающее сообщение, но я пока не умею
            sendMessage("/end");
            closeConnection();
            //System.exit(0);
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
}
