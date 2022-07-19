package ru.clevertec.multithreading.executors;

import java.util.concurrent.*;

public class ExecutorRunner {

    public static void main(String[] args) throws Exception {
        Callable<String> task = () -> {
            Thread.sleep(2000);
            return Thread.currentThread().getName();
        };
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i=0; i<10; i++) {
            Future<String> stringFuture = service.submit(task);
            System.out.print(stringFuture.get() + "; ");
            System.out.println(Thread.currentThread().getName());
        }

        service.shutdown();
    }
}
