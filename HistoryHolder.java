package ru.gb.gbchat1.readwritehistory;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class HistoryHolder {
    private Deque<String> chatHistory;

    public HistoryHolder() {
        chatHistory = new ArrayDeque<>();
    }
    /**
     * добаление строки из окна клиента
     * @param msg
     */

    public void saveHistory(String msg){

        chatHistory.addLast(msg);
    }
    /**
     * Запись сеанса клиента в файл
     */
    public void writeHistory(String fileName, boolean append){
        if(!chatHistory.isEmpty()){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,append))) {
                while(chatHistory.peek()!=null){
                    writer.write(chatHistory.pop());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * чтение из файла истории клиента и выдача ста последних по времени событий
     * @return String
     */

    public String readHistory(String fileName){
        File historyFile = new File(fileName);
        if(historyFile.length() == 0L)
            return "\n Напишите что-нибудь для истории чата \n)";
        else {
            try (BufferedReader reader = new BufferedReader(new FileReader(historyFile))) {
                String str;
                while ((str = reader.readLine()) != null) {
                    chatHistory.addLast(str + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder retString = new StringBuilder("\n История: \n");

            int count = 0;
            while (chatHistory.peek() != null && count < 100) {
                retString.append(chatHistory.pop());
                count++;
            }
            return retString.toString();
        }
    }

}
