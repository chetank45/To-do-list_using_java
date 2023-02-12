import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class project {
    private ArrayList<Task> todoList = new ArrayList<>();
    private class Task {
        private String task;
        private Date timestamp;

        public Task(String task) {
            this.task = task;
            this.timestamp = new Date();
        }

        @Override
        public String toString() {
            return task + " (added on " + timestamp + ")";
        }
    }
    
    public void addTask(String task) {
        Task newTask = new Task(task);
        todoList.add(newTask);
        System.out.println("Task '" + newTask + "' added to the to-do list.");
    }

    public void removeTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < todoList.size()) {
            Task task = todoList.remove(taskIndex);
            System.out.println("Task '" + task + "' removed from the to-do list.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("Tasks in the to-do list:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        project todoList = new project();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display tasks");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter task: ");
                scanner.nextLine();
                String task = scanner.nextLine();
                todoList.addTask(task);
            } else if (choice == 2) {
                System.out.print("Enter task index: ");
                int taskIndex = scanner.nextInt();
                todoList.removeTask(taskIndex - 1);
            } else if (choice == 3) {
                todoList.displayTasks();
            } else if (choice == 4) {
                break;
            }
        }
        scanner.close();
    }
}
