package ProgrammingWithClasses.Task8_Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerBase {

    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> sortListByCustomerName() {
        return customerList.stream()
                .sorted(Comparator.comparing(Customer::getLastName)
                        .thenComparing(Customer::getFirstName)
                        .thenComparing(Customer::getSecondName))
                .collect(Collectors.toList());
    }

    public List<Customer> getListIfCreditCardNumberBetween(int cardNumberFrom, int cardNumberTo) {
        return customerList.stream()
                .filter(customer -> customer.getCreditCardNumber() > cardNumberFrom && customer.getCreditCardNumber() < cardNumberTo)
                .sorted(Comparator.comparing(Customer::getCreditCardNumber))
                .collect(Collectors.toList());

    }
}
