public class Main {
    public static void main(String[] args) {
        Table table = new Table(2);

        for (int i = 0; i < 5; i++) {
            new Philosopher(i, table).start();
        }
    }
}
