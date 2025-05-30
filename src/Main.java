import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть варіант:");
        System.out.println("1) Deadlock вирішено заміною порядку взяття виделок у одного філософа.");
        System.out.println("2) Deadlock вирішено за допомогою офіціанта (2 дозволи на їжу).");
        System.out.print("Ваш вибір: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                runPhilosophersWithForkReversal();
                break;
            case 2:
                runPhilosophersWithWaiter();
                break;
            default:
                System.out.println("Невірний вибір.");
        }
    }

    public static void runPhilosophersWithForkReversal() {
        Table table = new Table();
        for (int i = 0; i < 5; i++) {
            new Philosopher(i, table).start();
        }
    }

    public static void runPhilosophersWithWaiter() {
        Table table = new Table();
        Waiter waiter = new Waiter(2); // 2 філософи можуть одночасно їсти
        for (int i = 0; i < 5; i++) {
            new PhilosopherWithWaiter(i, table, waiter).start();
        }
    }
}
