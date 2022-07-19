package ru.clevertec.multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableRunner {

    public static void main(String[] args) throws Exception {

        int a = 1;
        int b = 2;

        Callable<Integer> callableTask = () -> a + b;

        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);

        new Thread(futureTask).start();

        System.out.println(futureTask.get());

    }
}
