package ru.clevertec.multithreading.reetrantLock;

public class MyThread extends Thread {
    Resource resource;

    @Override
    public void run() {
        resource.change();
    }
}