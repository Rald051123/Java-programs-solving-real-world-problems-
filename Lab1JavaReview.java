import java.util.Scanner;

public class Lab1JavaReview {
    // the code below this, is the number of max books
    static final int MAX_BOOKS = 5;

    // This is the arrays to store book data
    static String[] bookTitles = new String[MAX_BOOKS];
    static String[] bookStatus = new String[MAX_BOOKS];
    static int bookCount = 0; // to keep track of how many books are registered

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // to Display the Main menu
            System.out.println("\n===== Library Book Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            // this will ensure that the input that will accepted is an integer otherwise it will not accept it
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1-5 only: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline and clean up the input buffer so the next nextLine() works properly.

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBookStatus(sc);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting system... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1-5 only.");
            }
        } while (choice != 5);

        sc.close();
    }

    // this code is to add a new book
    public static void addBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Book limit reached. Cannot add more books.");
            return;
        }
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        bookTitles[bookCount] = title;
        bookStatus[bookCount] = "Available"; // the default status when adding a book
        bookCount++;
        System.out.println("Book added successfully!");
    }

    // this is to update the book status
    public static void updateBookStatus(Scanner sc) {
        if (bookCount == 0) {
            System.out.println("No books available to update.");
            return;
        }
        showBooks();
        System.out.print("Enter book number to update status: ");
        int bookNumber = sc.nextInt();
        sc.nextLine(); // consume newline and clean up the input buffer so the next nextLine() works properly.

        if (bookNumber < 1 || bookNumber > bookCount) {
            System.out.println("Invalid book number!");
            return;
        }

        int index = bookNumber - 1;
        if (bookStatus[index].equals("Available")) {
            bookStatus[index] = "Borrowed";
        } else {
            bookStatus[index] = "Available";
        }
        System.out.println("Book status updated successfully!");
    }

    // this is to display all books
    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n===== Book List =====");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + bookTitles[i] + " - " + bookStatus[i]);
        }
    }

    // creating a report or to generate report as the code said.
    public static void generateReport() {
        if (bookCount == 0) {
            System.out.println("No books available for report.");
            return;
        }
        int availableCount = 0, borrowedCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (bookStatus[i].equals("Available")) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\n===== Library Report =====");
        System.out.println("Total books: " + bookCount);
        System.out.println("Available books: " + availableCount);
        System.out.println("Borrowed books: " + borrowedCount);
    }
}
