package ru.gb.gbchat1.database;

import java.sql.*;

public class JdbcApp {
    private  Connection connection = null;
    private  Statement statement = null;

    public  void connect() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
        this.statement = connection.createStatement();
        if(connection == null){
            System.out.println("Файл базы данных не создан");
        }
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
        int res = statement.executeUpdate("CREATE TABLE IF NOT EXISTS clients (\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "login TEXT,\n" +
                "pass TEXT,\n" +
                "nick TEXT\n" +
                ");");
        System.out.println(res);
    }

    public void insertUserNickAndPass(String user_login, String user_pass, String user_nick) throws SQLException {
        //готовим строку для относительно безопасного запроса
        String query = "INSERT INTO clients (login,pass,nick) VALUES(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user_login);
        ps.setString(2, user_pass);
        ps.setString(3, user_nick);
        ps.executeUpdate();
        ps.close();

    }

    public ResultSet readUserNickAndPass() throws SQLException {
        String query = "SELECT * FROM clients ;";
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }

    public   void dropTableEx() throws SQLException {
        String query = "DROP TABLE IF EXISTS clients;";
        statement.executeUpdate(query);        
    }

}




