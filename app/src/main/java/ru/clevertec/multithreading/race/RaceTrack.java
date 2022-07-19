package ru.clevertec.multithreading.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//With console inputting and logging
public class RaceTrack {

    protected static int quantityOfThreads;
    protected static int trackLength;
    protected static boolean isWinner;
    protected static boolean isActive = true;
    protected static Lock lock = new ReentrantLock();
    protected static CountDownLatch latch;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        List<CarRun> carRuns = new ArrayList<>();
        List<Thread> carThreads = new ArrayList<>();

        System.out.println("Enter quantity of cars (from 2 to 10)");
        quantityOfThreads = sc.nextInt();
        System.out.println("Enter length of the track (from 1 to 100)");
        trackLength = sc.nextInt();

        latch = new CountDownLatch(quantityOfThreads);

// Here I named my runnable(s)
        for (int i=0; i<quantityOfThreads; i++) {
            carRuns.add(new CarRun("car" + (i+1), latch));
        }

        for (CarRun carRun : carRuns) {
            carThreads.add(new Thread(carRun));
        }

        System.out.println("Ready! Steady! Go!" + "; counter" + latch.getCount());
        Thread logger = new Thread(new RaceLogger(carRuns));
        logger.setName("Logger");
        logger.start();

        carThreads.forEach((Thread::start));
        carThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        isActive = false;
    }
}
