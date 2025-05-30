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
                System.out.println("Філософ " + id + " думає (" + (i + 1) + ")");

                // Чекаємо дозволу у офіціанта (токен)
                table.requestPermission();

                // Беремо виделки
                table.getFork(rightFork);
                table.getFork(leftFork);

                System.out.println("Філософ " + id + " їсть (" + (i + 1) + ")");

                Thread.sleep(100); // імітація їжі

                // Кладемо виделки
                table.putFork(leftFork);
                table.putFork(rightFork);

                // Відпускаємо дозвіл офіціанту
                table.releasePermission();
            }
            System.out.println("Філософ " + id + " поїв.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
