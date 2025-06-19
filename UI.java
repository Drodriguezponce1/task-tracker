import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    private Scanner scanner;
    private TaskManager manager;

    public UI(Scanner scanner, TaskManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void start() {

        System.out.println("Hello, and welcome to this Task Manager System");
        System.out.println("===============================================");
        while (true) {
            printCommands();

            System.out.print("Command: ");
            String command = scanner.nextLine();
            System.out.println();

            if (command.equalsIgnoreCase("quit")) {
                break;
            }

            if (!command.equalsIgnoreCase("add") && !command.equalsIgnoreCase("update")
                    && !command.equalsIgnoreCase("delete") && !command.equalsIgnoreCase("list")) {

                System.out.println("Please enter valid input!!");
                System.out.println("===============================================\n");
                continue;
            }

            if (command.equalsIgnoreCase("add")) {
                add();
            } else if (command.equalsIgnoreCase("update")) {
                update();
            } else if (command.equalsIgnoreCase("list")) {
                this.manager.printAll();
            }

            System.out.println("===============================================\n");
        }
    }

    public void update() {

        System.out.println("Please provide the ID of the task you want to update: ");
        boolean flag = false;
        int id = 0;
        while (!flag) {

            try {
                System.out.print("ID: ");
                id = Integer.parseInt(scanner.nextLine());

                Task task = this.manager.get(id);

                if (task == null) {
                    throw new InputMismatchException();
                }

                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input type or no task with that ID");
            }

        }

        System.out.println("What would you like to update: status or description");

        flag = false;
        String choice = "";
        while (!flag) {

            try {
                System.out.print("Command: ");
                choice = scanner.nextLine();

                if (!choice.equalsIgnoreCase("status") && !choice.equalsIgnoreCase("description")) {
                    throw new InputMismatchException();
                }

                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Please only type 'status' or 'description'");
            }

        }
        System.out.print("Command: ");

        System.out.print("Description: ");

        String description = scanner.nextLine();
        this.manager.updateDescription(id, description);
    }

    public void add() {

        System.out.println("What would you like the description to be? ");
        System.out.print("Description: ");

        String description = scanner.nextLine();
        this.manager.add(description);
    }

    public void printCommands() {
        System.out.println("List of Commands: \n");
        System.out.println("Add Task: type 'add {description}'");
        System.out.println("Update Task: type 'update {description}'");
        System.out.println("Delete Task: type 'delete {description}'");
        System.out.println("List all tasks: type 'list all'");
        System.out.println("List all done tasks: type 'list done'");
        System.out.println("List all in-progress tasks: type 'list in-progress'");
        System.out.println("Entering 'quit' closes the program\n");
    }
}
