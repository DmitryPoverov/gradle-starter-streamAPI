package ru.clevertec.multithreading.reetrantLock;

public class ReentrantLockRunner {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.number = 5;

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.resource = resource;
        myThread2.resource = resource;

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println("i=" + resource.number);
    }
}

