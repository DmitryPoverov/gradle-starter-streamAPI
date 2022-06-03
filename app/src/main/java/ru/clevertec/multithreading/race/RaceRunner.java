package ru.clevertec.multithreading.race;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class RaceRunner {

    private static final int trackLength = 20;
    private static final Logger LOGGER = LogManager.getLogger(RaceTrack.class);

    //Without Console inputting
    public static void main(String[] args) throws InterruptedException {

        CarRunnable carThread1 = new CarRunnable("Car1");
        CarRunnable carThread2 = new CarRunnable("Car2");
        CarRunnable carThread3 = new CarRunnable("Car3");
        CarRunnable carThread4 = new CarRunnable("Car4");
        CarRunnable carThread5 = new CarRunnable("Car5");

        Thread car1 = new Thread(carThread1);
        Thread car2 = new Thread(carThread2);
        Thread car3 = new Thread(carThread3);
        Thread car4 = new Thread(carThread4);
        Thread car5 = new Thread(carThread5);

        System.out.println("Everyone! Go to the start!");
        TimeUnit.MILLISECONDS.sleep(200);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();

        while (car1.isAlive() || car2.isAlive() || car3.isAlive() || car4.isAlive() || car5.isAlive()) {
            LOGGER.info("Car1=" + (trackLength-carThread1.getPath())
                    + "km left, Car2:" + (trackLength-carThread2.getPath())
                    + "km left, Car3:" + (trackLength-carThread3.getPath())
                    + "km left, Car4:" + (trackLength-carThread4.getPath())
                    + "km left, Car5:" + (trackLength-carThread5.getPath()) + "km left");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
