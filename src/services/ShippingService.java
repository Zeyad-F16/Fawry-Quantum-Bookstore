package services;

import models.Book;

public class ShippingService {
    public static void ship(Book book , String address , String email , int quantity){
        System.out.println("Book: " + book.getTitle() + " is shipped to " + address + " with email " + email + " and quantity " + quantity);
    }
}
