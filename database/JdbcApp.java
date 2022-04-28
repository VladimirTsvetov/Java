package ru.gb.gbchat1.database;

import java.sql.*;

public class JdbcApp {
    private  Connection connection;
    private  Statement statement;

    public  void connect() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:client.db");
        this.statement = connection.createStatement();
    }

    public  void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS clients (\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "login TEXT,\n" +
                "pass TEXT,\n" +
                "nick TEXT\n" +
                ");");
    }

    public void insertUserNickAndPass(String user_login, String user_pass, String user_nick) throws SQLException {
        statement.executeUpdate("INSERT INTO clients (login, pass, nick) VALUES ('" + user_login + "','"
            + user_pass + "','" + user_nick + "');");
    }

    public ResultSet readUserNickAndPass() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM clients ;");
            return rs;
    }

    public   void dropTableEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS clients;");
    }


}



