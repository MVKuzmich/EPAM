package ProgrammingWithClasses.Task9_Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Book {
    private int id;
    private String title;
    private List<Author> authorList = new ArrayList<>();
    private Publisher publisher;
    private int publishYear;
    private int pagesCount;
    private double price;
    private BindingType bindingType;

    public Book(int id, String title, List<Author> authorList, Publisher publisher, int publishYear, int pagesCount, double price, BindingType bindingType) {
        this.id = id;
        this.title = title;
        this.authorList = authorList;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.pagesCount = pagesCount;
        this.price = price;
        this.bindingType = bindingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setLocalDate(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BindingType getBindingType() {
        return bindingType;
    }

    public void setBindingType(BindingType bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorList=" + authorList +
                ", publisher=" + publisher +
                ", publishYear=" + publishYear +
                ", pagesCount=" + pagesCount +
                ", price=" + price +
                ", bindingType=" + bindingType +
                '}';
    }
}
