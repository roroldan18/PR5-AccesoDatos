package View;

import Controller.EmployeeManager;
import Controller.SupplierManager;
import Entity.Employee;
import Entity.Supplier;

import java.util.Scanner;

public class MenuSupplier {

    private int option;
    private Scanner scanner = new Scanner(System.in);

    public MenuSupplier() {
        this.option = -1;
    }


    public void supplierMenu(){
        while (option != 0){
            switch (option){
                case 1 -> addSupplier();
                case 2 -> removeSupplier();
                case 3 -> viewAllSupplier();
                case 0 -> System.out.println("Exit");
            }
            System.out.println("Please select an option:");
            System.out.println("1. Add a supplier");
            System.out.println("2. Remove a supplier");
            System.out.println("3. View all suppliers");
            System.out.println("0. Exit");
            setOption(scanner.nextInt());
            scanner.nextLine();
        }
    }

    public void addSupplier(){
        System.out.println("Please enter the supplier's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the supplier's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter the supplier's dni:");
        String dni = scanner.nextLine();
        System.out.println("Please enter the supplier's age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the employee's email:");
        String email = scanner.nextLine();
        System.out.println("Please enter the supplier's company name:");
        String companyName = scanner.nextLine();
        System.out.println("Please enter the supplier's address:");
        String address = scanner.nextLine();
        System.out.println("Please enter the supplier's phone number:");
        String phoneNumber = scanner.nextLine();


        Supplier supplier = new Supplier(name, lastName, age, email, companyName, address, phoneNumber, dni);

        // Add the supplier to the file
        SupplierManager supplierManager = new SupplierManager();
        supplierManager.add(supplier);

        System.out.println("Supplier added successfully!");
    }

    public void removeSupplier(){
        System.out.println("Please enter the supplier's dni:");
        String dni = scanner.next();

        // Remove the supplier from the file
        SupplierManager supplierManager = new SupplierManager();
        supplierManager.remove(dni);

        System.out.println("Supplier removed successfully!");
    }

    public void viewAllSupplier(){
        SupplierManager supplierManager = new SupplierManager();
        supplierManager.viewAll();
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
}
