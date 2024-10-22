/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementBook;

/**
 *
 * @author hoang
 */
public class BookNode {
    Book data;
    BookNode left, right;

    public BookNode(Book data) {
        this.data = data;
        this.left = this.right = null;
    }
}
