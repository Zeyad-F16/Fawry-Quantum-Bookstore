import bookStore.BookStore;
import inventory.Inventory;
import models.Book;
import models.EBook;
import models.FileType;
import models.Paper;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Book ebook = new EBook("1234567890","fawry book",2020,100.0, FileType.PDF,true);
        Book paper = new Paper("1234567891","fintech",2020,100.0,100,false);

        inventory.addBook(ebook);
        inventory.addBook(paper);

        inventory.removeOutdatedBooks(2020 , inventory.getBooks());

        BookStore bookStore = new BookStore(inventory);

        bookStore.buy("1234567890",1,"farghlyzeyad9@gmail.com","Cairo");
        bookStore.buy("1234567891",1,"farghlyzeyad9@gmail.com","Cairo");


    }
}