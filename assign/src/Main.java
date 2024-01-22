import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Employee employee1 = new Employee("John", "Lennon", "Employee", 27045.78);
        Employee employee2 = new Employee("George", "Harrison", "Employee", 50000.0);
        Student student1 = new Student("Ringo", "Starr", 2);
        Student student2 = new Student("Paul", "McCartney", 3.67);

        people.add(student1);
        people.add(employee1);
        people.add(student2);
        people.add(employee2);

        Collections.sort(people);
        printData(people);
    }
    public static void printData(Iterable<Person> people){
        for(Person person : people){
            System.out.println(person.toString() + " earns " + person.getPaymentAmount() + " tenge");
        }
    }
}