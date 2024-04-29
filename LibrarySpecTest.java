/*
 * By: Olivia Cole
   Description: This code is a specification test for the library internal DSL
   contained in Library.java
 */

import java.util.*;

public class LibrarySpecTest {
    public static void main(String[] args) {
        Library lib = new Library();

        // Add users
        lib.addUser("Martha");
        lib.addUser("John");

        // Add books
        lib.addBook("The Hunger Games", "Suzanne Collins");
        lib.addBook("Pride and Prejudice", "Jane Austen");
        lib.addBook("The Catcher in the Rye", "J. D. Salinger");
        lib.addBook("Harry Potter and the Sorcerer's Stone", "J. K. Rowling");

        // Users check out books
        lib.getUser("John").checkOut("The Hunger Games");
        lib.getUser("Martha").checkOut("Pride and Prejudice");
        lib.getUser("Martha").checkOut("The Catcher in the Rye");
        
        // Check if list of available books is accurate
        ArrayList<Library.Book> availableBooks = new ArrayList<>();
        availableBooks = lib.getAvailableBooks();
        if(availableBooks.size() == 1) {
            System.out.println("Size: true");
        }

        if(availableBooks.get(0).getTitle().compareTo("Harry Potter and the Sorcerer's Stone") == 0) {
            System.out.println("Title: true");
        }

        // User returns book
        lib.getUser("Martha").returnBook("Pride and Prejudice");
        
        // Check if list of available books is accurate
        availableBooks = lib.getAvailableBooks();
        if(availableBooks.size() == 2) {
            System.out.println("Size: true");
        }

        if(availableBooks.get(0).getTitle().compareTo("Harry Potter and the Sorcerer's Stone") == 0 
          || availableBooks.get(0).getTitle().compareTo("Pride and Prejudice") == 0) {
            System.out.println("Title1: true");
        }

        if(availableBooks.get(1).getTitle().compareTo("Harry Potter and the Sorcerer's Stone") == 0 
          || availableBooks.get(1).getTitle().compareTo("Pride and Prejudice") == 0) {
            System.out.println("Title2: true");
        }
    }
}
