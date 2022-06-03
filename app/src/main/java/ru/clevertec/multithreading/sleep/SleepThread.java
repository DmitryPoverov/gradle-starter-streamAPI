package ru.clevertec.multithreading.sleep;

public class SleepThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException in SleepThread.");
        }
        System.out.println("Hello from SleepThread.");
    }
}
