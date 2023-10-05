package Controller;

import Entity.Employee;
import Entity.Supplier;

public class SupplierManager extends BaseManager {
    public SupplierManager() {
        super("supplier.txt");
    }

    @Override
    public void add(Object object) {
        if (object instanceof Supplier) {
            Supplier supplier = (Supplier) object;
            super.add(supplier);
        } else {
            throw new IllegalArgumentException("Invalid object type");
        }
    }
}
