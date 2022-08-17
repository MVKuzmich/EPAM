package programming_with_classes.aggregation_and_composition.task4_accounts;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private List<Account> accounts;
    private Bank bank;

    public Client(int id, Bank bank) {
        this.id = id;
        this.bank = bank;
        this.bank.getClients().add(this);
        accounts = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Client: " +
                "id = " + id +
                ", accounts = " + accounts;
    }
}
