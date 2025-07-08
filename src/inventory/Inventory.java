package inventory;

import models.Book;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    ArrayList<Book> books;

    public final int MAX_NUM_OF_YEARS_TO_BE_OUTDATED = 20;

    public Inventory() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeOutdatedBooks(int currentYear, ArrayList<Book> books) {
        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.getPublishYear() + MAX_NUM_OF_YEARS_TO_BE_OUTDATED <= currentYear) {
                iterator.remove();
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book getBook(String ISBN){
        for(Book book : books){
            if(book.getISBN().equals(ISBN)){
                return book;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return books.isEmpty();
    }

}
