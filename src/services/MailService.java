package services;

import models.Book;
import models.FileType;

public class MailService {
    public static void sendEmail(Book book , String email , FileType fileType){
        System.out.println("Book: " + book.getTitle() + " is sent to " + email+ " as a " + fileType.name());
    }
}
