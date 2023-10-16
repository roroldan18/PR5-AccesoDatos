package Controller;

import Entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final String FILE_NAME = "students.txt";
    private List<Student> studentsList;

    public StudentManager() {
        this.studentsList = new ArrayList<>();
        cargarDatosDesdeArchivo(FILE_NAME);
    }

    public void cargarDatosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parsear cada línea y crear objetos Student
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String name = parts[0];
                    String lastName = parts[1];
                    String subject = parts[2];
                    double grade = Double.parseDouble(parts[3]);
                    int age = Integer.parseInt(parts[4]);
                    String email = parts[5];
                    String dni = parts[6];

                    Student student = new Student(name, lastName, age, email, dni);
                    student.setAsignatura(subject);
                    student.setNote(grade);
                    studentsList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Student student) {
        studentsList.add(student);
        guardarDatosEnArchivo(FILE_NAME);
    }

    public void remove(String dni) {
        studentsList.removeIf(student -> student.getDni().equals(dni));
        guardarDatosEnArchivo(FILE_NAME);
    }

    public void guardarDatosEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Student student : studentsList) {
                bw.write(student.getName() + "," + student.getLastName() + "," +
                        student.getAsignatura() + "," + student.getNote() + "," +
                        student.getAge() + "," + student.getEmail() + "," +
                        student.getDni());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> searchBySubjectAndGrade(String subject, double minGrade) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.getAsignatura().equalsIgnoreCase(subject) && student.getNote() >= minGrade) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public List<Student> getStudentsToRetakeExam(String subject, double passingGrade) {
        List<Student> retakeStudents = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.getAsignatura().equalsIgnoreCase(subject) && student.getNote() < passingGrade) {
                retakeStudents.add(student);
            }
        }
        return retakeStudents;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }
}
