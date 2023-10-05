package Controller;

import Entity.Employee;

public class EmployeeManager extends BaseManager{

    public EmployeeManager() {
        super("employees.txt");
    }

    @Override
    public void add(Object object) {
        if (object instanceof Employee) {
            Employee employee = (Employee) object;
            super.add(employee);
        } else {
            throw new IllegalArgumentException("Invalid object type");
        }
    }

}
