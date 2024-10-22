/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementBook;

/**
 *
 * @author hoang
 */
public class Book {
    String bcode;
    String title;
    int quantity;
    int lended;
    double price;

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String toString() {
        return bcode + " | " + title + " | " + quantity + " | " + lended + " | " + price;
    }
}
