package ProgrammingWithClasses.AggregationAndComposition.Task4_Accounts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private String name;
    private List<Client> clients;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        clients = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public void blockAccount(int accNumber) {
        accounts.stream()
                .filter(account -> account.getAccNumber() == accNumber)
                .findFirst()
                .ifPresent(account -> account.setAccActive(false));
    }
    public void unblockAccount(int accNumber) {
        accounts.stream()
                .filter(account -> account.getAccNumber() == accNumber)
                .findFirst()
                .ifPresent(account -> account.setAccActive(true));
    }

    public void sortByAccAmount() {
        accounts.sort(Comparator.comparing(Account::getAccAmount).thenComparing(Account::getAccNumber));
    }

    public void sortByAccNumber() {
        accounts.sort(Comparator.comparing(Account::getAccNumber).thenComparing(Account::getAccAmount));
    }

    public List<Account> findBlockedAccounts() {
        return accounts.stream().filter(account -> !account.isAccActive()).collect(Collectors.toList());
    }

    public List<Account> findAccountsByClientId(int clientId) {
        return accounts.stream()
                .filter(account -> account.getClient().getId() == clientId)
                .collect(Collectors.toList());
    }

    public Account findAccountByAccNumber(int accNumber) {
        return accounts.stream()
                .filter(account -> account.getAccNumber() == accNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account is not exist!"));
    }
    public List<Account> findAccountsIfAccAmountIsGreater(int sum) {
        return accounts.stream()
                .filter(account -> account.getAccAmount() > sum)
                .collect(Collectors.toList());
    }
    public List<Account> findAccountsIfAccAmountIsLess(int sum) {
        return accounts.stream()
                .filter(account -> account.getAccAmount() < sum)
                .collect(Collectors.toList());
    }

    public double getSumPositiveBalanceAccounts() {
        return accounts.stream()
                .mapToDouble(Account::getAccAmount)
                .filter(amount -> amount > 0)
                .sum();
    }

    public double getSumNegativeBalanceAccounts() {
        return accounts.stream()
                .mapToDouble(Account::getAccAmount)
                .filter(amount -> amount < 0)
                .sum();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Bank: " +
                "name = " + name +
                ", clients = " + clients;
    }
}
