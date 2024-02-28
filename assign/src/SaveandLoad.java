import java.io.*;

public class ToDoListApp {


    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        loadTasksFromFile();
        showMenu();
        saveTasksToFile();
    }

    private static void loadTasksFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (ArrayList<Task>) ois.readObject();
            System.out.println("Tasks loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No saved tasks found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks. Starting with an empty list.");
        }
    }

    private static void saveTasksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
            System.out.println("Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }


}
