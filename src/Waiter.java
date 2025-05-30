import java.util.concurrent.Semaphore;

public class Waiter {
    private final Semaphore permission;

    public Waiter(int maxAllowedPhilosophers) {
        this.permission = new Semaphore(maxAllowedPhilosophers);
    }

    public void requestPermission() throws InterruptedException {
        permission.acquire();
    }

    public void releasePermission() {
        permission.release();
    }
}
