package Controller;

import Entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileManager {
    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    public List<Student> readFile() {
        List<Student> studentsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                if (tokenizer.countTokens() == 7) {
                    String name = tokenizer.nextToken();
                    String lastName = tokenizer.nextToken();
                    String subject = tokenizer.nextToken();
                    double grade = Double.parseDouble(tokenizer.nextToken());
                    int age = Integer.parseInt(tokenizer.nextToken());
                    String email = tokenizer.nextToken();
                    String dni = tokenizer.nextToken();

                    Student student = new Student(name, lastName, age, email, dni);
                    student.setAsignatura(subject);
                    student.setNote(grade);
                    studentsList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsList;
    }


    public void writeFile(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Student student : students) {
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


    public void removeLine(String lineToRemove) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(lineToRemove)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
