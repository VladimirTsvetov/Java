package ru.gb.gbchat1.server;

import java.io.Closeable;
import java.sql.SQLException;

public interface AuthService extends Closeable {
    void start() throws SQLException;
    void close();
    String getNickByLoginAndPassword(String login,String password);
}
