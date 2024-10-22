/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;
import ManagementBook.BinarySearchTree;
import ManagementBook.Book;
import ManagementLending.Lending;
import ManagementLending.LendingLinkedList;
import ManagementReader.Reader;
import ManagementReader.ReaderLinkedList;
import java.util.Scanner;
/**
 *
 * @author hoang
 */
public class Menu {
    private static BinarySearchTree bookTree = new BinarySearchTree();
    private static ReaderLinkedList readerList = new ReaderLinkedList();
    private static LendingLinkedList lendingList = new LendingLinkedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;       
        do {
            System.out.println("========= Library Management System =========");
            System.out.println("1. Book Management");
            System.out.println("2. Reader Management");
            System.out.println("3. Lending Management");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();           
            switch (choice) {
                case 1:
                    bookManagementMenu(sc);
                    break;
                case 2:
                    readerManagementMenu(sc);
                    break;
                case 3:
                    lendingManagementMenu(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void bookManagementMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Book Management ---");
            System.out.println("1. Insert book");
            System.out.println("2. Display books");
            System.out.println("3. Search book");
            System.out.println("4. Delete book");
            System.out.println("0. Back to main menu");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) {
                case 1:
                    System.out.print("Enter book code: ");
                    String bcode = sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter lended quantity: ");
                    int lended = sc.nextInt();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    bookTree.insert(new Book(bcode, title, quantity, lended, price));
                    break;
                case 2:
                    System.out.println("Displaying books:");
                    bookTree.inOrderTraverse();
                    break;
                case 3:
                    System.out.print("Enter book code to search: ");
                    bcode = sc.nextLine();
                    Book book = bookTree.search(bcode);
                    if (book != null)
                        System.out.println("Book found: " + book);
                    else
                        System.out.println("Book not found.");
                    break;
                case 4:
                    System.out.print("Enter book code to delete: ");
                    bcode = sc.nextLine();
                    bookTree.delete(bcode);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
//hello
    public static void readerManagementMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Reader Management ---");
            System.out.println("1. Add reader");
            System.out.println("2. Display readers");
            System.out.println("3. Search reader");
            System.out.println("4. Delete reader");
            System.out.println("0. Back to main menu");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter reader code: ");
                    String rcode = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter birth year: ");
                    int byear = sc.nextInt();
                    readerList.addReader(new Reader(rcode, name, byear));
                    break;
                case 2:
                    System.out.println("Displaying readers:");
                    readerList.displayReaders();
                    break;
                case 3:
                    System.out.print("Enter reader code to search: ");
                    rcode = sc.nextLine();
                    Reader reader = readerList.searchReader(rcode);
                    if (reader != null)
                        System.out.println("Reader found: " + reader);
                    else
                        System.out.println("Reader not found.");
                    break;
                case 4:
                    System.out.print("Enter reader code to delete: ");
                    rcode = sc.nextLine();
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

    public static void lendingManagementMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Lending Management ---");
            System.out.println("1. Add lending");
            System.out.println("2. Display lendings");
            System.out.println("0. Back to main menu");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter book code: ");
                    String bcode = sc.nextLine();
                    System.out.print("Enter reader code: ");
                    String rcode = sc.nextLine();
                    System.out.print("Enter lending state (0 = borrowed, 1 = returned): ");
                    int state = sc.nextInt();
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
