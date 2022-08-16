package ProgrammingWithClasses.AggregationAndComposition.Task4_Accounts;

public class Account {
    private int accNumber;
    private double accAmount;
    private boolean isAccActive;
    private Bank bank;
    private Client client;

    public Account(int accNumber, double accAmount, Bank bank, Client client) {
        this.accNumber = accNumber;
        this.accAmount = accAmount;
        isAccActive = true;
        this.bank = bank;
        this.bank.getAccounts().add(this);
        this.client = client;
        this.client.getAccounts().add(this);
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public double getAccAmount() {
        return accAmount;
    }

    public void setAccAmount(double accAmount) {
        this.accAmount = accAmount;
    }

    public boolean isAccActive() {
        return isAccActive;
    }

    public void setAccActive(boolean accActive) {
        isAccActive = accActive;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account: " +
                "accNumber = " + accNumber +
                ", accAmount = " + accAmount +
                ", isAccActive = " + isAccActive;
    }
}
