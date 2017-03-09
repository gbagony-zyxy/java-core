package com.ruyin.code.mechanism.heartbreak;

/**
 * Created by ruyin on 2017/2/28.
 * 客户端周期性发送请求,使得客户端与服务端保持连接状态
 */
public class SimpleClient implements Runnable{

    @Override
    public void run() {
        while(true){
            SimpleClientSender.getInstance().send();
            synchronized (SimpleClient.class){
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new SimpleClient()).start();
    }
}
