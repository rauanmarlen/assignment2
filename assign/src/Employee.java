public class Employee {
    private int id;
    private String name;
    private String position;
    private String department;
    private int salary;


    public Employee(int id, String name, String position, String department, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", department='" + getDepartment() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
}
