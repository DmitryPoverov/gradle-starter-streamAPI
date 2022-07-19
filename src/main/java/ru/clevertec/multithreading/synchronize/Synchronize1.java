package ru.clevertec.multithreading.synchronize;

public class Synchronize1 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized(lock) {
                for (int i = 0; i < 8; i++) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("  " + i);
                }
                System.out.println(" ...");
            }
        };

        Thread th1 = new Thread(task);
        th1.start();
//        th1.join();
//        Thread.sleep(10);
        synchronized(lock) {
            System.out.println("thread");
        }
        System.out.println("end main");
    }
}
