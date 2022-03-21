package MultiThread.problem1279;

import java.util.concurrent.Semaphore;

public class TrafficLight {
    private Semaphore greenLight = new Semaphore(1, true);
    private boolean road1CanGo = true;
    private boolean road2CanGo = false;

    public TrafficLight() {

    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) throws InterruptedException {
        greenLight.acquire();
        if (roadId == 1 && road1CanGo || roadId == 2 && road2CanGo) {
            crossCar.run();
        } else if (roadId == 1) {
            turnGreen.run();
            road1CanGo = true;
            road2CanGo = false;
            crossCar.run();
        } else if (roadId == 2) {
            turnGreen.run();
            road1CanGo = false;
            road2CanGo = true;
            crossCar.run();
        }
        greenLight.release();
    }
}
