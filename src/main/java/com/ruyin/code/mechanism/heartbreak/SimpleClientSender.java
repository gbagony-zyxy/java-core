package com.ruyin.code.mechanism.heartbreak;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ruyin on 2017/2/28.
 */
public class SimpleClientSender {

    private SimpleClientSender() {
    }

    private AtomicInteger count = new AtomicInteger(0);

    private Socket sender = null;
    private static SimpleClientSender instance = new SimpleClientSender();

    public static SimpleClientSender getInstance() {
        return instance;
    }

    public void send(){
        try {
            sender = new Socket(InetAddress.getLocalHost(),9090);
            while(true){
                count.incrementAndGet();
                ObjectOutput out = new ObjectOutputStream(sender.getOutputStream());
                User user = new User("Joe","ruyin"+count);
                out.writeObject(user);
                out.flush();

                System.out.println("客户端已发送请求");
                Thread.sleep(5000L);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
