package ru.clevertec.multithreading.synchronize;

public class Synchronize2 {

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread th1 = new MyThread();
        th1.start();
        Thread th2 = new MyThread();
        th2.start();
        System.out.println("1");
        th1.join();
        System.out.println("2");
        Thread.sleep(10);
        synchronized(lock) {
            System.out.println("thread");
        }
        System.out.println("end main");
    }
}