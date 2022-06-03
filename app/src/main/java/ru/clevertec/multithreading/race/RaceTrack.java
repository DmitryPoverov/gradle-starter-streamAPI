package ru.clevertec.multithreading.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//With console inputting and logging
public class RaceTrack {

    protected static int quantityOfThreads;
    protected static int trackLength;
    protected static boolean isWinner;
    protected static boolean isActive = true;
    protected static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter quantity of cars (from 2 to 10)");
        quantityOfThreads = sc.nextInt();

        System.out.println("Enter length of the track (from 1 to 100)");
        trackLength = sc.nextInt();

        List<CarRunnable> runnableList = new ArrayList<>();
        List<Thread> carThreads = new ArrayList<>();

        for (int i=0; i<quantityOfThreads; i++) {
            runnableList.add(new CarRunnable("car" + (i+1)));
        }

        for (CarRunnable car : runnableList) {
            carThreads.add(new Thread(car));
        }

        System.out.println("Everyone! Go to the start!");
        new Thread(new RaceLogger(runnableList)).start();

        for (Thread thread : carThreads) {
            thread.start();
        }

        for (Thread thread : carThreads) {
            thread.join();
        }

        isActive = false;

/* Think over lately.
        ExecutorService threadPool = Executors.newFixedThreadPool(quantityOfThreads);
        List<CarRunnable> runnableList = new ArrayList<>();

        for (int i=0; i<quantityOfThreads; i++) {
            CarRunnable car = new CarRunnable("car" + (i+1));
            runnableList.add(car);
        }

        new Thread(new RaceLogger(runnableList)).start();

        System.out.println("Everyone! Go to the start!");
        TimeUnit.MILLISECONDS.sleep(200);

        for (CarRunnable car : runnableList) {
            threadPool.submit(car);
        }

        threadPool.shutdown();

        isActive = threadPool.isTerminated();
*/
    }
}
