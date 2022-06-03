package ru.clevertec.multithreading.race;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class CarRunnable implements Runnable {

    private final String name;
    private int path;
    private final Lock lock = RaceTrack.lock;

    public CarRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPath() {
        return path;
    }

    @Override
    public void run() {
        try {
            while (path < RaceTrack.trackLength) {
                TimeUnit.MILLISECONDS.sleep(100);
                path++;
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException!");
        }

        lock.lock();
        System.out.print("Finished " + name);
        if (!RaceTrack.isWinner) {
            System.out.print(" <- *** WINNER ***");
            RaceTrack.isWinner = true;
        }
        System.out.println();
        lock.unlock();
    }
}
