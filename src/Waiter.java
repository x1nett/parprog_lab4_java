import java.util.concurrent.Semaphore;

public class Waiter {
    private final Semaphore semaphore;

    public Waiter(int maxDiners) {
        semaphore = new Semaphore(maxDiners);
    }

    public void requestPermission() throws InterruptedException {
        semaphore.acquire();
    }

    public void releasePermission() {
        semaphore.release();
    }
}
