package programming_with_classes.aggregation_and_composition.task4_accounts;

public class BankTest {

    public static void main(String[] args) {
        Bank bank = new Bank("Start");
        Client first = new Client(1, bank);
        Client second = new Client(2, bank);
        Client third = new Client(3, bank);
        Client forth = new Client(4, bank);
        Client fifth = new Client(5, bank);

        Account acc1 = new Account(100, -1000.0, bank, first);
        Account acc2 = new Account(101, 1100.0, bank, first);
        Account acc3 = new Account(107, 1200.0, bank, first);
        Account acc4 = new Account(105, 10000.0, bank, second);
        Account acc5 = new Account(104, -10.0, bank, second);
        Account acc6 = new Account(103, 1000.0, bank, third);
        Account acc7 = new Account(106, 2000.0, bank, forth);
        Account acc8 = new Account(102, 3000.0, bank, fifth);
        Account acc9 = new Account(108, 3000.0, bank, fifth);
        Account acc10 = new Account(109, -3000.0, bank, fifth);

        bank.blockAccount(100);
        bank.blockAccount(107);
        bank.sortByAccNumber();
        System.out.printf("Accounts are SORTED by account number: %s\n", bank.getAccounts());
        bank.sortByAccAmount();
        System.out.printf("Accounts are SORTED by account amount: %s\n", bank.getAccounts());
        System.out.printf("BLOCKED accounts: %s\n", bank.findBlockedAccounts());
        System.out.printf("Find accounts by CLIENT ID: %s\n", bank.findAccountsByClientId(1));
        System.out.printf("Find accounts by ACCOUNT NUMBER: %s\n", bank.findAccountByAccNumber(108));
        System.out.printf("Find accounts with amount GREATER than 2 000: %s\n", bank.findAccountsIfAccAmountIsGreater(2000));
        System.out.printf("Find accounts with amount LESS than 2 000: %s\n", bank.findAccountsIfAccAmountIsLess(2000));
        System.out.printf("Sum of POSITIVE balance accounts: %f\n", bank.getSumPositiveBalanceAccounts());
        System.out.printf("Sum of NEGATIVE balance accounts: %f\n", bank.getSumNegativeBalanceAccounts());


    }
}
