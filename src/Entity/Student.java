package Entity;

public class Student extends Person {
    private String asignatura;
    private Double note;

    public Student(String name,String lastName,int age,String email,String dni){
        super(name,lastName,age,email,dni);
    }
    public Student(String name, String lastName, int age, String email, String dni, String asignatura, Double note) {
        super(name, lastName, age, email, dni);
        this.asignatura = asignatura;
        this.note = note;
    }



    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
