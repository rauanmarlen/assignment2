import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDataAccessObject employeeDAO = new EmployeeDataAccessObject();


        Scanner scan = new Scanner(System.in);
        System.out.println("Input NAME, POSITION, DEPARTMENT, SALARY by spaces:");
        String input1 = scan.nextLine();

        String[] dbArguments = input1.split(" ");


        employeeDAO.addEmployee(dbArguments[0], dbArguments[1], dbArguments[2], Integer.parseInt(dbArguments[3]));


        employeeDAO.addEmployee("Rauan Marlen", "Software Engineer", "IT", 80000);
        employeeDAO.addEmployee("Will Smith", "Manager", "HR", 90000);
        employeeDAO.addEmployee("Michael Jackson", "Analyst", "Finance", 75000);
        employeeDAO.addEmployee("Jon Jones", "Designer", "Marketing", 85000);


        List<Employee> employeesList = employeeDAO.getEmployees();
        System.out.println("All employees: " + employeesList);


        employeeDAO.updateEmployee(1, "Rauan Marlen", "Senior Software Engineer", "IT", 95000);


        employeesList = employeeDAO.getEmployees();
        System.out.println("Updated employees: " + employeesList);

        System.out.println("EMPLOYEE SALARY for 0 el: " + employeesList.get(0).getSalary() + " NAME: " + employeesList.get(0).getName());


        for (int i = 0; i < employeesList.size(); i++) {
            if (Objects.equals(employeesList.get(i).getDepartment(), "HR")) {
                System.out.println("Deleted employee: " + employeesList.get(i) + ". YES THIS EMPLOYEE WAS FROM HR!!! :) ");
                employeeDAO.deleteEmployee(employeesList.get(i).getId());
            }
        }


        employeesList = employeeDAO.getEmployees();
        System.out.println("Final employees: " + employeesList);


        employeeDAO.closeConnection();
    }
}
