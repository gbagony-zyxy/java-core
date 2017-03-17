package com.ruyin.code.core.thread;

/**
 * Created by ruyin on 2017/3/16.
 */
public class Butterfly extends Thread{

    public Butterfly(){
        System.out.println("Butterfly start --- ");
        System.out.println("CurrentThread : " + Thread.currentThread().getName());
        System.out.println("CurrentThread isAlive : " + Thread.currentThread().isAlive());
        System.out.println("This Thread : " + this.getName());
        System.out.println("This Thread isAlive : " + this.isAlive());
        System.out.println("Butterfly end --- ");
        System.out.println("This Thread == CurrentThread : " + (this == Thread.currentThread()));
    }

    @Override
    public void run() {
        System.out.println("Run start --- ");
        System.out.println("CurrentThread : " + Thread.currentThread().getName());
        System.out.println("CurrentThread isAlive : " + Thread.currentThread().isAlive());
        System.out.println("This Thread : " + this.getName());
        System.out.println("This Thread isAlive : " + this.isAlive());
        System.out.println("Run end --- ");
        System.out.println("This Thread == CurrentThread : " + (this == Thread.currentThread()));
    }

    public static void main(String[] args) {
        Butterfly butterfly = new Butterfly();
        butterfly.start();
        Thread t1 = new Thread(butterfly);
        System.out.println();
        System.out.println("main begin t1 isAlive : " + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive : " + t1.isAlive());
    }
}
