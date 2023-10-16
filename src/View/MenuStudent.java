package View;

import Controller.StudentManager;
import Entity.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuStudent {
    private int option;
    private Scanner scanner = new Scanner(System.in);
    private StudentManager studentManager = new StudentManager();

    public MenuStudent() {
        this.option = -1;
    }

    public void studentMenu() throws IOException {
        while (option != 0) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. View all students");
            System.out.println("4. Search students by subject and grade");
            System.out.println("5. Show students who need to retake an exam");
            System.out.println("0. Exit");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    searchStudentsBySubjectAndGrade();
                    break;
                case 5:
                    studentsToRetakeExam();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    public void addStudent() throws IOException {
        System.out.println("Please enter the student's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the student's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter the student's DNI:");
        String dni = scanner.nextLine();
        System.out.println("Please enter the student's age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the student's email:");
        String email = scanner.nextLine();
        System.out.println("Please enter the student's subject:");
        String subject = scanner.nextLine();
        System.out.println("Please enter the student's grade:");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(name, lastName, age, email, dni, subject, grade);
        studentManager.add(student);

        System.out.println("Student added successfully!");
    }

    public void removeStudent() throws IOException {
        System.out.println("Please enter the student's DNI to remove:");
        String dni = scanner.nextLine();
        studentManager.remove(dni);
        System.out.println("Student removed successfully!");
    }

    public void viewAllStudents() throws IOException {
        studentManager.getStudentsList();
    }

    public void searchStudentsBySubjectAndGrade() {
        System.out.println("Please enter the subject to search:");
        String subject = scanner.nextLine();
        System.out.println("Please enter the minimum grade to search:");
        double minGrade = scanner.nextDouble();
        scanner.nextLine();

        List<Student> students = studentManager.searchBySubjectAndGrade(subject, minGrade);
        if (students.isEmpty()) {
            System.out.println("No students found with the given criteria.");
        } else {
            System.out.println("Students found with the given criteria:");
            for (Student student : students) {
                System.out.println(student);
                System.out.println("-----------");
            }
        }
    }

    public void studentsToRetakeExam() throws IOException {
        System.out.println("Please enter the subject for retaking the exam:");
        String subject = scanner.nextLine();
        System.out.println("Please enter the passing grade for the subject:");
        double passingGrade = scanner.nextDouble();
        scanner.nextLine();

        List<Student> studentsToRetake = studentManager.getStudentsToRetakeExam(subject, passingGrade);
        if (studentsToRetake.isEmpty()) {
            System.out.println("No students need to retake the exam for the given subject.");
        } else {
            System.out.println("Students who need to retake the exam for the given subject:");
            for (Student student : studentsToRetake) {
                System.out.println(student);
                System.out.println("-----------");
            }
        }
    }
}
