class Person implements Comparable<Person>, Payable{
    static int id = 1;
    String name;
    String surname;
    public String toString(){
        return id++ + ". " + name + " " + surname;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person(){

    }

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getPosition(){
        if (getPosition() == "Employee" || getPosition() == "employee"){
            return "Employee";
        }
        else{
            return "Student";
        }
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }
    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }
}