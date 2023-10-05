package View;

import Controller.EmployeeManager;
import Entity.Employee;

import java.util.Scanner;

public class MenuEmployee {

    private int option;
    private Scanner scanner = new Scanner(System.in);

    public MenuEmployee() {
        this.option = -1;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void employeeMenu(){
        while (option != 0){
            switch (option){
                case 1 -> addEmployee();
                case 2 -> removeEmployee();
                case 3 -> viewAllEmployees();
                case 0 -> System.out.println("Exit");
            }
            System.out.println("Please select an option:");
            System.out.println("1. Add an employee");
            System.out.println("2. Remove an employee");
            System.out.println("3. View all employees");
            System.out.println("0. Exit");
            setOption(scanner.nextInt());
            scanner.nextLine();
        }
    }

    public void addEmployee(){
        // TODO: Se pueden hacer validaciones de cada dato.

        // Tomar los datos hasta que se ingrese un salto de linea
        System.out.println("Please enter the employee's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the employee's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter the employee's dni:");
        String dni = scanner.nextLine();
        System.out.println("Please enter the employee's age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the employee's position:");
        String position = scanner.nextLine();
        System.out.println("Please enter the employee's email:");
        String email = scanner.nextLine();
        System.out.println("Please enter the employee's salary:");
        Double salary = scanner.nextDouble();
        Employee employee = new Employee(name, lastName, age, position, email, salary, dni);

        // Agregar el empleado en el fichero
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.add(employee);

        System.out.println("Employee added successfully!"); }

    public void removeEmployee(){
        // TODO: Eliminar por DNI
        System.out.println("Please enter the employee's dni:");
        String dni = scanner.next();
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.remove(dni);
        System.out.println("DNI removed successfully!");
    }

    public void viewAllEmployees(){
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.viewAll();
    }
}
