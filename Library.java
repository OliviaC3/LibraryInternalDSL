/*
 * By: Olivia Cole
   Description: This code creates an internal DSL to allow a user to create a library object,
   add users, add books, and check out and return books under a user.
 */

 // Imports
import java.util.*;

// Main library class
public class Library {
    // Keep track of users and books
    private static ArrayList<User> users;
    private static ArrayList<Book> books;
    
    // Constructpr
    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    // Add user
    public void addUser(String name) {
        User user = new User(name);
        users.add(user);
    }

    // Add book
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    // Get user with certain name
    public User getUser(String user) {
        boolean foundUser = false;
        User chosenUser = null;
        int i = 0;

        while(!foundUser) {
            if(users.get(i).getName().compareTo(user) == 0) {
                chosenUser = users.get(i);
                foundUser = true;
            }

            i++;
        }

        return chosenUser;
    }

    // Print all the available books(not checked out)
    public void printAvailableBooks() {
        System.out.println("Available Books: ");
        for(int i = 0; i < books.size(); i++) {
            if(!books.get(i).isCheckedOut()) {
                System.out.println(books.get(i).toString());
                //System.out.println();
            }
        }
    }
    
    // Print all the books
    public void printAllBooks() {
        for(int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
    }

    // Get arraylist of available books
    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();

        for(int i = 0; i < books.size(); i++) {
            if(!books.get(i).isCheckedOut()) {
                availableBooks.add(books.get(i));
            }
        }

        return availableBooks;
    }

    // User class
    class User {
        // Keep track of name and checked out books
        private String name;
        private ArrayList<Book> myBooks;
    
        // Constructor
        User(String name) {
            this.name = name;
            this.myBooks = new ArrayList<>();
        }
    
        // Get name
        public String getName() {
            return this.name;
        }

        // Check out book
        public void checkOut(String book) {
            boolean foundBook = false;
            int i = 0;
            Book chosenBook = null;
    
            while(!foundBook) {
                if(books.get(i).getTitle().compareTo(book) == 0) {
                    chosenBook = books.get(i);
                    foundBook = true;
                }
    
                i++;
            }
    
            if(!chosenBook.isCheckedOut()) {
                chosenBook.checkOut();
                this.myBooks.add(chosenBook);
            }
        }

        // Return book
        public void returnBook(String book) {
            boolean foundBook = false;
            int i = 0;
            Book chosenBook = null;
    
            while(!foundBook) {
                if(books.get(i).getTitle().compareTo(book) == 0) {
                    chosenBook = books.get(i);
                    foundBook = true;
                }
    
                i++;
            }

            this.myBooks.remove(chosenBook);
            chosenBook.returnBook();
        }
    }
    
    // Book class
    class Book {
        // Keep track of title, author, and whether the book is checked out
        private String title;
        private String author;
        private boolean checkedOut;
    
        // Constructor
        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.checkedOut = false;
        }

        // Change checkedout to true
        public void checkOut() {
            this.checkedOut = true;
        }

        // Change checked out to false
        public void returnBook() {
            this.checkedOut = false;
        }
    
        // Get title
        public String getTitle() {
            return this.title;
        }

        // Check if checked out
        public boolean isCheckedOut() {
            return this.checkedOut;
        }

        // Overriden toString()
        @Override
        public String toString() {
            return "Title: " + this.title + "\n" +
            "Author: " + this.author + "\n";
        }
    }
}

