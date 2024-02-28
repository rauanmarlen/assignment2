import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoListApp {
    // ... (existing code)

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (yyyy-MM-dd, press Enter to skip): ");
        String dueDateString = scanner.nextLine();

        Date dueDate = null;
        try {
            if (!dueDateString.isEmpty()) {
                dueDate = DATE_FORMAT.parse(dueDateString);
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Task added without due date.");
        }

        System.out.print("Enter priority (High, Medium, Low; press Enter to skip): ");
        String priorityString = scanner.nextLine();
        Priority priority = Priority.parsePriority(priorityString);

        tasks.add(new TaskWithPriority(description, dueDate, priority));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        System.out.println("\n--- Tasks ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }


}

class TaskWithPriority extends Task {
    private Date dueDate;
    private Priority priority;

    public TaskWithPriority(String description, Date dueDate, Priority priority) {
        super(description);
        this.dueDate = dueDate;
        this.priority = priority;
    }

    @Override
    public String toString() {
        String taskString = super.toString();
        if (dueDate != null) {
            taskString += " [Due: " + DATE_FORMAT.format(dueDate) + "]";
        }
        if (priority != null) {
            taskString += " [Priority: " + priority + "]";
        }
        return taskString;
    }
}

enum Priority {
    HIGH, MEDIUM, LOW;

    public static Priority parsePriority(String priorityString) {
        try {
            return priorityString.isEmpty() ? null : Priority.valueOf(priorityString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority. Defaulting to Medium.");
            return MEDIUM;
        }
    }
}
