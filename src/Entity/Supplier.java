package Entity;

public class Supplier extends Person{
    private String companyName;
    private String address;
    private String phoneNumber;

    public Supplier(String name, String lastName, int age, String email, String companyName, String address, String phoneNumber, String dni) {
        super(name, lastName, age, email, dni);
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
