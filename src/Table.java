import java.util.concurrent.Semaphore;

public class Table {
    private final Semaphore[] forks = new Semaphore[5];

    public Table() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void getFork(int id) throws InterruptedException {
        forks[id].acquire();
    }

    public void putFork(int id) {
        forks[id].release();
    }
}
