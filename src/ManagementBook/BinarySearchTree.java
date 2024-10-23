/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementBook;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * hi
 * 
 * @author hoang
 */
public class BinarySearchTree {
    private BookNode root;

    public BinarySearchTree() {
        root = null;
        this.readFileBook("Book.txt");
    }

    // Thêm sách vào cây
    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private BookNode insertRec(BookNode root, Book book) {
        if (root == null) {
            return new BookNode(book);
        }
        if (book.bcode.compareTo(root.data.bcode) < 0)
            root.left = insertRec(root.left, book);
        else if (book.bcode.compareTo(root.data.bcode) > 0)
            root.right = insertRec(root.right, book);
        return root;
    }

    // Duyệt cây theo thứ tự giữa (In-order)
    public void inOrderTraverse() {
        inOrderRec(root);
    }

    private void inOrderRec(BookNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data.toString());
            inOrderRec(root.right);
        }
    }

    // Duyệt cây theo chiều rộng (Breadth-first)
    public void breadthFirstTraverse() {
        if (root == null)
            return;

        Queue<BookNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BookNode current = queue.poll();
            System.out.println(current.data);
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    // Tìm kiếm sách theo mã bcode
    public Book search(String bcode) {
        return searchRec(root, bcode);
    }

    private Book searchRec(BookNode root, String bcode) {
        if (root == null || root.data.bcode.equals(bcode))
            return root != null ? root.data : null;
        if (bcode.compareTo(root.data.bcode) < 0)
            return searchRec(root.left, bcode);
        return searchRec(root.right, bcode);
    }

    // Xóa sách theo mã bcode
    public void delete(String bcode) {
        root = deleteRec(root, bcode);
    }

    private BookNode deleteRec(BookNode root, String bcode) {
        if (root == null)
            return root;
        if (bcode.compareTo(root.data.bcode) < 0)
            root.left = deleteRec(root.left, bcode);
        else if (bcode.compareTo(root.data.bcode) > 0)
            root.right = deleteRec(root.right, bcode);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data.bcode);
        }
        return root;
    }

    private Book findMin(BookNode root) {
        Book minv = root.data;
        while (root.left != null) {
            root = root.left;
            minv = root.data;
        }
        return minv;
    }

    // Đếm số lượng sách
    public int countBooks() {
        return countRec(root);
    }

    private int countRec(BookNode root) {
        if (root == null)
            return 0;
        return 1 + countRec(root.left) + countRec(root.right);
    }

    public  void readFileBook(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                this.insert(new Book(parts[0],parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Double.parseDouble(parts[4])));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
