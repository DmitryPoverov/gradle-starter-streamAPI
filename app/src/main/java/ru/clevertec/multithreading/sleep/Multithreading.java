package ru.clevertec.multithreading.sleep;

public class Multithreading {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("Hello from Thread1."));
        thread1.start();

        Thread sleepThread = new SleepThread();
        sleepThread.start();
        sleepThread.interrupt();
    }
}
