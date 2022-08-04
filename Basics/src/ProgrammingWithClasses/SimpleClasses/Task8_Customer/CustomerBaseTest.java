package ProgrammingWithClasses.SimpleClasses.Task8_Customer;

public class CustomerBaseTest {

    public static void main(String[] args) {
        CustomerBase base = new CustomerBase();
        base.addCustomer(new Customer(1, "Ivanov", "Ivan", "Ivanovich", 100, 201));
        base.addCustomer(new Customer(2, "Petrov", "Ivan", "Sergeevich", 111, 202));
        base.addCustomer(new Customer(3, "Makov", "Ivan", "Semenovich", 103, 203));
        base.addCustomer(new Customer(4, "Zhanov", "Ivan", "Petrovich", 105, 204));
        base.addCustomer(new Customer(5, "Popov", "Ivan", "Ivanovich", 151, 205));
        base.addCustomer(new Customer(6, "Lesov", "Ivan", "Alekseevich", 113, 206));
        base.addCustomer(new Customer(7, "Polev", "Ivan", "Ivanovich", 142, 207));
        base.addCustomer(new Customer(8, "Ivanov", "Ivan", "Sergeevich", 199, 208));
        base.addCustomer(new Customer(9, "Ivanov", "Ivan", "Petrovich", 190, 209));
        base.addCustomer(new Customer(10, "Popov", "Pavel", "Ivanovich", 107, 210));

        System.out.println("Список покупателей по диапазону номеров кредитных карт: ");
        base.getListIfCreditCardNumberBetween(130, 200).forEach(System.out::println);

        System.out.println("Список покупателей по алфавиту: ");
        base.sortListByCustomerName().forEach(System.out::println);
    }

}
