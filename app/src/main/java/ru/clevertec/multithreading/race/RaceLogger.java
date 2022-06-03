package ru.clevertec.multithreading.race;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RaceLogger implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(RaceTrack.class);
    private static List<CarRunnable> runnableList;

    public RaceLogger(List<CarRunnable> list) {
        runnableList = list;
    }

    @Override
    public void run() {
        while (RaceTrack.isActive) {
            StringBuilder logString = new StringBuilder();
            for (CarRunnable car : runnableList) {
                logString.append(car.getName()).append(" : ").append(RaceTrack.trackLength - car.getPath()).append("km left, " );
            }
            LOGGER.info(logString);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
