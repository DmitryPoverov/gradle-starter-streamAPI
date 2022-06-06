package ru.clevertec.multithreading.wait;

class WaitJoinSleepRunner {
    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            try {
                int secToWait = 1000 * 6;
                Thread.sleep(secToWait);
                System.out.print("Waked up. ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + 1 + ". ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.print("Main finished. ");
    }
}
