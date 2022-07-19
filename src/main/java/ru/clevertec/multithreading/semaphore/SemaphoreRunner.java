package ru.clevertec.multithreading.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreRunner {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);

        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " started.");
                TimeUnit.SECONDS.sleep(5);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
    }
}
