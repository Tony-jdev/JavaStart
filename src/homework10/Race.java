package homework10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Race {
    public static AtomicLong startRaceTime = new AtomicLong();
    public static void main(String[] args) {
        List<RaceCarRunnable> cars = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        CountDownLatch latch = new CountDownLatch(3);

        cars.add(new RaceCarRunnable("Car1", 200, 1000, latch));
        cars.add(new RaceCarRunnable("Car2", 220, 1000, latch));
        cars.add(new RaceCarRunnable("Car3", 180, 1000, latch));

        for (RaceCarRunnable car : cars) {
            threads.add(new Thread(car));
        }

        startRace(threads);

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        RaceCarRunnable winner = findWinner(cars);
        System.out.println("Winner: " + winner.name + " - Time: " + convertToTime(winner.getFinishTime()));
    }

    private static void startRace(List<Thread> cars) {
        Thread startThread = new Thread(() -> {
            try {
                for (int i = 3; i > 0; --i) {
                    System.out.println(i + "...");
                    Thread.sleep(500);
                }
                System.out.println("GO!!!");
                startRaceTime.set(System.currentTimeMillis());
                for (Thread car : cars) {
                    car.start();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        startThread.start();
    }

    private static RaceCarRunnable findWinner(List<RaceCarRunnable> cars) {
        RaceCarRunnable winner = cars.get(0);
        for (RaceCarRunnable car : cars) {
            if (car.getFinishTime() < winner.getFinishTime()) {
                winner = car;
            }
        }
        return winner;
    }

    private static String convertToTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SSS");
        return sdf.format(time);
    }
}
