package homework10;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RaceCarRunnable extends Car implements Runnable{
    private int passed;
    private int distance;
    private boolean isFinish;
    private CountDownLatch latch;
    private long finishTime;

    public RaceCarRunnable(String name, int maxSpeed, int distance, CountDownLatch latch) {
        super(name, maxSpeed);
        this.distance = distance;
        this.latch = latch;
    }

    private int getRandomSpeed() {
        Random random = new Random();
        return random.nextInt(maxSpeed / 2) + maxSpeed / 2;
    }

    @Override
    public void run() {
        while (!isFinish) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            int speed = getRandomSpeed();
            passed += speed;
            System.out.println(name + " => speed: " + speed + "; progress: " + passed + "/" + distance);
            if (passed >= distance) {
                isFinish = true;
                finishTime = System.currentTimeMillis();
                latch.countDown();
                System.out.println(name + " FINISHED !");
            }
        }
    }

    public long getFinishTime() {
        return finishTime;
    }
}
