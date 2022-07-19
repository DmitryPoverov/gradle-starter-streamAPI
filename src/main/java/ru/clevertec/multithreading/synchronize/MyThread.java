package ru.clevertec.multithreading.synchronize;

public class MyThread extends Thread {

    @Override
    public void run() {

        synchronized (Synchronize2.lock) {
            for (int i = 0; i < 5; i++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("  " + i);
            }
            System.out.println(" end." +
                    "..." + Thread.currentThread().getName());
        }
    }
}
