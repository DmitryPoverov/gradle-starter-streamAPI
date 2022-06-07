package ru.clevertec.multithreading.synchronize;

public class SynchronizeLock {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("Thread.");
            }
        };

        Thread th1 = new Thread(task);
        th1.start();
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.print(i + "  ");
            }
            System.out.println("The end of the main().");
        }
    }
}
