import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully.");
    }

    static void viewBooks() {
        if (books.size() == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- BOOK LIST ---");

        for (Book b : books) {
            System.out.println("Book ID: " + b.id);
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);

            if (b.available) {
                System.out.println("Status: Available");
            } else {
                System.out.println("Status: Issued");
            }

            System.out.println("----------------------");
        }
    }

    static void searchBook() {
        sc.nextLine();

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println("\nBook Found");
                System.out.println("Book ID: " + b.id);
                System.out.println("Title: " + b.title);
                System.out.println("Author: " + b.author);
                System.out.println("Status: " +
                        (b.available ? "Available" : "Issued"));

                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {

                if (b.available) {
                    b.available = false;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {

                if (!b.available) {
                    b.available = true;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is already available.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== COMMUNITY LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    System.out.println("Thank you for using the system.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}