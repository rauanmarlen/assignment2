import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAccessObject {
    private Connection connection;


    public EmployeeDataAccessObject() {
        try {
            String url = key.getUrl();  // assuming key is a class or constant providing database details
            String user = key.getUser();
            String password = key.getPass();
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addEmployee(String name, String position, String department, int salary) {
        try {
            String query = "INSERT INTO employees (name, position, department, salary) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setString(3, department);
            preparedStatement.setInt(4, salary);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            String query = "SELECT * FROM employees";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String department = resultSet.getString("department");
                int salary = resultSet.getInt("salary");

                employees.add(new Employee(id, name, position, department, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    public void updateEmployee(int id, String name, String position, String department, int salary) {
        try {
            String query = "UPDATE employees SET name=?, position=?, department=?, salary=? WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setString(3, department);
            preparedStatement.setInt(4, salary);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteEmployee(int id) {
        try {
            String query = "DELETE FROM employees WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        try {
            String query = "DELETE FROM employees"; // Clearing the table
            String queryID = "ALTER SEQUENCE employees_id_seq RESTART WITH 1;"; // Resetting sequence

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryID);

            preparedStatement1.executeUpdate();
            preparedStatement.executeUpdate();

            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("CONNECTION WITH DATABASE CLOSED.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
