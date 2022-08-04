package ProgrammingWithClasses.SimpleClasses.Task8_Customer;

public class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String secondName;
    private int creditCardNumber;
    private int accountNumber;

    public Customer(int id, String lastName, String firstName, String secondName, int creditCardNumber, int accountNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.creditCardNumber = creditCardNumber;
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Customer: " +
                    "id = " + id + " " +
                    "name = " + lastName + " " + firstName + " " + secondName + " " +
                    "creditCardNumber = " + creditCardNumber + " " +
                    "accountNumber = " + accountNumber;
    }
}
