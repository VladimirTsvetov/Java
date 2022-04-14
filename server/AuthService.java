package ru.gb.gbchat1.server;

import java.io.Closeable;

public interface AuthService extends Closeable {
    void start();
    void close();
    String getNickByLoginAndPassword(String login,String password);
}
