/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructure;

/**
 *
 * @author ASUS
 */
public class MyQueue<T> {
    private Node<T> front; 
    private Node<T> rear;  

    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    // Thêm phần tử vào cuối hàng đợi
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {  
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Xóa và trả về phần tử ở đầu hàng đợi
    public T dequeue() {
        if (front == null) {  
            System.out.println("Queue is empty!");
            return null;
        }
        T data = front.data;  
        front = front.next;   

        if (front == null) { 
            rear = null;     
        }
        return data;  
    }

    // Kiểm tra hàng đợi có trống hay không
    public boolean isEmpty() {
        return front == null;
    }

    // Trả về phần tử ở đầu hàng đợi mà không xóa nó
    public T peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return null;
        }
        return front.data;
    }

    // Hiển thị các phần tử trong hàng đợi
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
