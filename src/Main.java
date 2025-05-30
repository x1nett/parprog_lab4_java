public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter(2); // 2 одночасних дозволи
        Table table = new Table();

        for (int i = 0; i < 5; i++) {
            new Philosopher(i, table, waiter).start();
        }
    }
}
