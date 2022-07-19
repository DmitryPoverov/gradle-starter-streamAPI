package ru.clevertec.multithreading.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// I don't understand what is the difference between CachedThreadPool/WorkStealingPoo?
// Why WorkStealingPool doesn't work, it doesn't show any result and threads don't wake up?
// App finishes by the submit().
public class WorkStealingRunner {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newWorkStealingPool();
        Callable<String> task = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " has just started");
            lock.wait(100);
            System.out.println("Thread " + Thread.currentThread().getName() + " has just finished");
            return "result";
        };
        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }
        Thread.sleep(20000);
        executorService.shutdown();
    }
}
