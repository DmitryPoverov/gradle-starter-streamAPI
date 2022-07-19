package ru.clevertec.multithreading.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class CarRun implements Runnable {

    private final String name;
    private int path;
    private final Lock lock = RaceTrack.lock;
    private final CountDownLatch latch;

    public CarRun(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
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
            latch.countDown();
            latch.await();

            while (path < RaceTrack.trackLength) {
                TimeUnit.MILLISECONDS.sleep(100);
                path++;
            }

            lock.lock();
            System.out.print("Finished " + name);
            if (!RaceTrack.isWinner) {
                System.out.print(" <- WINNER!!!");
                RaceTrack.isWinner = true;
            }
            System.out.println();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException!");
        }
    }
}
