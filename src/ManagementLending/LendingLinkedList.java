/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementLending;

/**
 *
 * @author hoang
 */
public class LendingLinkedList {
    private LinkedListNode<Lending> head;

    public LendingLinkedList() {
        head = null;
    }

    // Thêm mục mượn sách
    public void addLending(Lending lending) {
        LinkedListNode<Lending> newNode = new LinkedListNode<>(lending);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode<Lending> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Hiển thị danh sách mượn
    public void displayLending() {
        LinkedListNode<Lending> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
