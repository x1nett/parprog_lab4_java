import java.util.concurrent.Semaphore;

public class Table {
    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore waiter;

    public Table(int maxDiners) {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
        waiter = new Semaphore(maxDiners);
    }

    public void requestPermission() throws InterruptedException {
        waiter.acquire();
    }

    public void releasePermission() {
        waiter.release();
    }

    public void getFork(int id) throws InterruptedException {
        forks[id].acquire();
    }

    public void putFork(int id) {
        forks[id].release();
    }
}
