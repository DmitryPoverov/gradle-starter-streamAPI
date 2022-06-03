package ru.clevertec.multithreading.reetrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    int number;
    Lock lock = new ReentrantLock();

    void change() {
        lock.lock();
        int i = number;
        number = ++i;
        lock.unlock();
    }
}
