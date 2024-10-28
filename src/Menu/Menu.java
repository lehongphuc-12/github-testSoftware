package Menu;

import Lending.Lending;
import Lending.LendingLinkedList;
import ManagementBook.BinarySearchTree;
import ManagementBook.Book;
import ManagementReader.Reader;
import ManagementReader.ReaderLinkedList;

public class Menu {
    static BinarySearchTree bookTree = new BinarySearchTree();
    static ReaderLinkedList readerList = new ReaderLinkedList();
    static LendingLinkedList lendingList = new LendingLinkedList();
    static Utils input = new Utils();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("========= Library Management System =========");
            System.out.println("1. Book Management");
            System.out.println("2. Reader Management");
            System.out.println("3. Lending Management");
            System.out.println("0. Exit");
            choice = input.getInt("Your choice: ");
            switch (choice) {
                case 1:
                    bookManagementMenu();
                    break;
                case 2:
                    readerManagementMenu();
                    break;
                case 3:
                    lendingManagementMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void bookManagementMenu() {
        int choice;
        do {
            System.out.println("\n--- Book Management ---");
            System.out.println("1. Insert book");
            System.out.println("2. Display books");
            System.out.println("3. Search book");
            System.out.println("4. Delete book");
            System.out.println("5. Count book");
            System.out.println("0. Back to main menu");
            choice = input.getInt("Your choice: ");
            switch (choice) {
                case 1:
                    String bcode = input.getString("Enter book code: ");
                    String title = input.getString("Enter title: ");
                    int quantity = input.getInt("Enter quantity: ");
                    int lended = input.getInt("Enter lended quantity: ");
                    double price = input.getDouble("Enter price: ");
                    bookTree.insert(new Book(bcode, title, quantity, lended, price));
                    break;
                case 2:
                    System.out.println("Displaying books:");
                    bookTree.inOrderTraverse();
                    break;

                case 3:
                    bcode = input.getString("Enter book code to search: ");
                    Book book = bookTree.search(bcode);
                    if (book != null)
                        System.out.println("Book found: " + book);
                    else
                        System.out.println("Book not found.");
                    break;
                case 4:
                    bcode = input.getString("Enter book code to delete:");
                    bookTree.delete(bcode);
                    break;
                case 5:
                    System.err.println("Nums of book:" + bookTree.countBooks());
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void readerManagementMenu() {
        int choice;
        do {
            System.out.println("\n--- Reader Management ---");
            System.out.println("1. Add reader");
            System.out.println("2. Display readers");
            System.out.println("3. Search reader");
            System.out.println("4. Delete reader");
            System.out.println("0. Back to main menu");
            choice = input.getInt("Your choice: ");
            switch (choice) {
                case 1:
                    String rcode = input.getString("Enter reader code:");
                    String name = input.getString("Enter name:");
                    int byear = input.getbYear("Enter birth year: ");
                    readerList.addReader(new Reader(rcode, name, byear));
                    break;
                case 2:
                    System.out.println("Displaying readers:");
                    readerList.displayReaders();
                    break;
                case 3:
                    System.out.print("Enter reader code to search: ");
                    rcode = input.getString("Enter reader code to search:");
                    Reader reader = readerList.searchReader(rcode);
                    if (reader != null)
                        System.out.println("Reader found: " + reader);
                    else
                        System.out.println("Reader not found.");
                    break;
                case 4:
                    rcode = input.getString("Enter reader code to delete:");
                    readerList.deleteReader(rcode);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void lendingManagementMenu() {
        int choice;
        do {
            System.out.println("\n--- Lending Management ---");
            System.out.println("1. Add lending");
            System.out.println("2. Display lendings");
            System.out.println("0. Back to main menu");
            choice = input.getInt("Your choice: ");
            switch (choice) {
                case 1:
                    System.out.print("Enter book code: ");
                    String bcode = input.getString("Enter book code: ");
                    System.out.print("Enter reader code: ");
                    String rcode = input.getString("Enter reader code:");
                    int state = input.getState(
                            "Enter lending state (0: the book is not given to the reader, 1: the book is still at the reader, not given back, 2: the book is given back to the library): ");
                    lendingList.addLending(new Lending(bcode, rcode, state));
                    break;
                case 2:
                    System.out.println("Displaying lendings:");
                    lendingList.displayLending();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
