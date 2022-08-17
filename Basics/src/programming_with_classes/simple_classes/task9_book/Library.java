package programming_with_classes.simple_classes.task9_book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> findBooksByAuthor(String firstName, String lastName) {
       return bookList.stream()
                .filter(book -> book.getAuthorList().stream().anyMatch(author -> author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)))
                .collect(Collectors.toList());
    }
    public List<Book> findBooksByPublisher(String publisherName) {
        return bookList.stream()
                .filter(book -> book.getPublisher().getName().equals(publisherName))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksIfPublishYearAfter(int year) {
        return bookList.stream().filter(book -> book.getPublishYear() > year).collect(Collectors.toList());
    }
}

