import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        UI user = new UI(scanner, manager);
        user.start();
    }
}
