public class Philosopher extends Thread {
    private final int id;
    private final int leftFork;
    private final int rightFork;
    private final Table table;

    public Philosopher(int id, Table table) {
        this.id = id;
        this.table = table;
        this.rightFork = id;
        this.leftFork = (id + 1) % 5;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Філософ " + id + " думає " + (i + 1) + " разів");

                if (id % 2 == 0) {
                    table.getFork(leftFork);
                    table.getFork(rightFork);
                } else {
                    table.getFork(rightFork);
                    table.getFork(leftFork);
                }

                System.out.println("Філософ " + id + " їсть " + (i + 1) + " разів");
                Thread.sleep(100);

                table.putFork(leftFork);
                table.putFork(rightFork);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
