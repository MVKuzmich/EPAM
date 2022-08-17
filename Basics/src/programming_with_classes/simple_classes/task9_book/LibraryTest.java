package programming_with_classes.simple_classes.task9_book;

import java.util.List;

public class LibraryTest {

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "Don", List.of(new Author("Mikhail", "Sholokhov")), new Publisher("Access"),
                1968, 563, 60.65, BindingType.SOFT));
        library.addBook(new Book(2, "Metro", List.of(new Author("Mikhail", "Sholokhov"), new Author("Petr", "Petrov")),
                new Publisher("Access"), 2015, 253, 30.65, BindingType.SOFT));
        library.addBook(new Book(3, "House", List.of(new Author("Ivan", "Ivanov")), new Publisher("Access"),
                1980, 315, 40.02, BindingType.SOFT));
        library.addBook(new Book(4, "Trees", List.of(new Author("Ivan", "Ivanov")), new Publisher("Admiration"),
                2022, 210, 20.30, BindingType.HARD));
        library.addBook(new Book(5, "Mouse", List.of(new Author("Mikhail", "Sholokhov"), new Author("Ivan", "Ivanov"), new Author("Petr", "Ivanov")),
                new Publisher("Admiration"), 2020, 700, 70.25, BindingType.HARD));
        library.addBook(new Book(6, "Earth", List.of(new Author("Mikhail", "Sholokhov")), new Publisher("Flowers"),
                1970, 563, 90.90, BindingType.HARD));

        System.out.println("Book list by author name: ");
        library.findBooksByAuthor("Ivan", "Ivanov").forEach(System.out::println);
        System.out.println("Book list by publisher: ");
        library.findBooksByPublisher("").forEach(System.out::println);
        System.out.println("Book list published after given year: ");
        library.findBooksIfPublishYearAfter(2000).forEach(System.out::println);

    }
}
