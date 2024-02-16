public class Student extends Person{
    static int id;
    String name;
    String surname;
    double gpa;
    public String toString(){
        return "Student: " + super.toString();
    }
    public int getId(){
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public Student(){

    }
    public Student(String name, String surname, double gpa){
        super(name,surname);
        this.gpa = gpa;
    }

    @Override
    public double getPaymentAmount() {
        if(gpa > 2.67) {
            return 36660.0;
        }
        else {
            return 0;
        }
    }
    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }
}