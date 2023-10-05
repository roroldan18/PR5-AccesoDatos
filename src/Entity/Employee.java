package Entity;

public class Employee extends Person {
    private String position;
    private Double salary;

    public Employee(String name, String lastName, int age, String position, String email, Double salary, String dni) {
        super(name, lastName, age, email, dni);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "position='" + position + '\'' +
                ", salary=" + salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
