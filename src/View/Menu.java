package View;

import java.util.Scanner;

public class Menu {
    private int option;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        this.option = -1;
    }
    public void start(){
        while (option != 0){
            switch (option){
                case 1 -> onMenuEmployee();
                case 2 -> onMenuSupplier();
                case 0 -> System.out.println("Exit");
            }
            System.out.println("Please select an option:");
            System.out.println("1. Menu Employee");
            System.out.println("2. Menu Supplier");
            System.out.println("0. Exit");
            setOption(scanner.nextInt());
        }
    }

    public void onMenuEmployee(){
        MenuEmployee menuEmployee = new MenuEmployee();
        menuEmployee.employeeMenu();
    }

    public void onMenuSupplier(){
        MenuSupplier menuSupplier = new MenuSupplier();
        menuSupplier.supplierMenu();
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
