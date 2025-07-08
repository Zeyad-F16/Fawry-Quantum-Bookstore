package bookStore;

import inventory.Inventory;
import models.Book;
import models.EBook;
import models.Paper;
import services.MailService;
import services.ShippingService;

import java.util.ArrayList;

public class BookStore {
    public Inventory inventory;
    ArrayList<Book> books;

    public BookStore(Inventory inventory) {
         this.inventory = inventory;
         this.books = inventory.getBooks();

        if(inventory.isEmpty()) {
            System.out.println("There is no book in the store");
            System.exit(0);
        }
    }


    public void buy(String ISBN , int quantity ,String email , String address){

        Book book = inventory.getBook(ISBN);

        if(book.isDemo()){
            System.out.println("Sorry, " +book.getTitle() + " is a demo book");
        }
        else if(book.isShippable()){
            if(((Paper) book).getQuantity() < quantity){
                throw new RuntimeException("Sorry, there is not enough quantity of this book");
            }
            ((Paper) book).reduceQuantity(quantity);
            ShippingService.ship(book , address , email , quantity);
        }else{
            MailService.sendEmail(book , email , ((EBook) book).getFileType());
        }

    }
}
