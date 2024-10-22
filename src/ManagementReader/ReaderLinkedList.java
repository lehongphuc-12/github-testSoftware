/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementReader;

/**
 *
 * @author hoang
 */
public class ReaderLinkedList {
    private LinkedListNode<Reader> head;

    public ReaderLinkedList() {
        head = null;
    }

    // Thêm độc giả vào cuối danh sách
    public void addReader(Reader reader) {
        LinkedListNode<Reader> newNode = new LinkedListNode<>(reader);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode<Reader> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Hiển thị danh sách độc giả
    public void displayReaders() {
        LinkedListNode<Reader> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Tìm kiếm độc giả theo mã rcode
    public Reader searchReader(String rcode) {
        LinkedListNode<Reader> temp = head;
        while (temp != null) {
            if (temp.data.rcode.equals(rcode))
                return temp.data;
            temp = temp.next;
        }
        return null;
    }

    // Xóa độc giả theo mã rcode
    public void deleteReader(String rcode) {
        if (head == null)
            return;

        if (head.data.rcode.equals(rcode)) {
            head = head.next;
            return;
        }

        LinkedListNode<Reader> temp = head;
        while (temp.next != null) {
            if (temp.next.data.rcode.equals(rcode)) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}
