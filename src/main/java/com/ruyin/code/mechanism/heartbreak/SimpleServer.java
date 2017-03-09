package com.ruyin.code.mechanism.heartbreak;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ruyin on 2017/2/28.
 * server不去监听client端的情况,
 * client启动定时器不断发心跳,
 * server收到心跳给回应
 */
public class SimpleServer implements Runnable{
    private ServerSocket serverSocket = null;
    Object object = new Object();

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9090);
            while(true){
                Socket client = serverSocket.accept();
                synchronized (object){
                    new Thread(new Client(client)).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Client implements Runnable{

        Socket client;

        public Client(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            try {
                while(true){
                    ObjectInput in = new ObjectInputStream(client.getInputStream());
                    User user = (User) in.readObject();
                    System.out.println(user);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("心跳实验开始....");
        new Thread(new SimpleServer()).start();
    }
}
