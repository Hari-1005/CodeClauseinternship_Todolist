import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== To-Do List ===");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Remove Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void editTask() {
        System.out.print("Enter task number to edit: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (isValidTaskNumber(taskNumber)) {
            System.out.print("Enter new task: ");
            String newTask = scanner.nextLine();
            tasks.set(taskNumber - 1, newTask);
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask() {
        System.out.print("Enter task number to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (isValidTaskNumber(taskNumber)) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewTasks() {
        System.out.println("\nTasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }
}
