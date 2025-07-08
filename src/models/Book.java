package models;

public abstract class Book {
    private String ISBN;
    private String title;
    private int publishYear;
    private double price;
    private boolean isDemo;

    public Book(String ISBN, String title, int publishYear, double price, boolean isDemo) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.isDemo = isDemo;
    }

    public abstract boolean isShippable();

    public boolean isDemo() {
        return isDemo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
