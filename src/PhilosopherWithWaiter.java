public class PhilosopherWithWaiter extends Thread {
    private final int id;
    private final int leftFork;
    private final int rightFork;
    private final Table table;
    private final Waiter waiter;

    public PhilosopherWithWaiter(int id, Table table, Waiter waiter) {
        this.id = id;
        this.table = table;
        this.waiter = waiter;
        this.rightFork = id;
        this.leftFork = (id + 1) % 5;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Філософ " + id + " думає " + (i + 1) + " разів");

                waiter.requestPermission();

                table.getFork(rightFork);
                table.getFork(leftFork);

                System.out.println("Філософ " + id + " їсть " + (i + 1) + " разів");
                Thread.sleep(100);

                table.putFork(leftFork);
                table.putFork(rightFork);

                waiter.releasePermission();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
