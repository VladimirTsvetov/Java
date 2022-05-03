package ru.gb.gbchat1.server;

import ru.gb.gbchat1.database.JdbcApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthService implements AuthService {
    private List<UserData> users;
    private class UserData{
        String login;
        String password;
        String nick;

        public UserData(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }
    @Override

    //здесь мы подключаемся к базе данных и читаем ники и пароли
    public void start() throws SQLException {
        JdbcApp jdbcApp = new JdbcApp();  //создали класс

        jdbcApp.connect();            //присоединяемся к базе
        jdbcApp.createTableEx();       //если базы нет, то создаем

        //пока делаем такой дурацкий манёвр: тупо забиваем в базу пять ников и паролей
        String user_login = "login";
        String user_pass = "pass";
        String user_nick = "nick";
        for(int i = 0; i < 5; i++){
                jdbcApp.insertUserNickAndPass(user_login + i, user_pass + i, user_nick + i );
        }
        //теперь, чтобы пока не ломать логику и успесть сдать ДЗ, делаем так: читаем из базы логины и пароли
        ResultSet rs = null;
        users = new ArrayList<>();
        int i = 0;
        rs = jdbcApp.readUserNickAndPass();

        while (rs.next()) {
            String login = rs.getString("login");
            String pass = rs.getString("pass");
            String nick = rs.getString("nick");
            users.add(new UserData(login,pass,nick));
        }
        rs.close();
        jdbcApp.dropTableEx();  //на этом этапе мы ее удаляем, потом будем делать красиво
        jdbcApp.disconnect();


    }

    @Override
    public void close() {
        System.out.println("сервис атентификации остановлен");

    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        for(UserData user: users){
            if(user.login.equals(login) && user.password.equals(password))
                return user.nick;
        }
        return null;
    }
}
