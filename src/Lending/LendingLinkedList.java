
package Lending;

import java.io.*;


public class LendingLinkedList {
    private LinkedListNode<Lending> head;

    public LendingLinkedList() {
        head = null;
        this.readFile("Lending.txt");
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

    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                this.addLending(new Lending(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void accSortByBcode(){
        for (LinkedListNode<Lending> i = head; i.next != null ;i=i.next){
            for (LinkedListNode<Lending> j = i.next; j!=null;j=j.next){
                if(i.data.bcode.compareTo(j.data.bcode)>0){
                    String temp= i.data.bcode;
                    i.data.bcode = j.data.bcode;
                    j.data.bcode = temp;
                }
            }
        }
    }

    void accSortByRcode(){
        for (LinkedListNode<Lending> i = head; i.next != null ;i=i.next){
            for (LinkedListNode<Lending> j = i.next; j!=null;j=j.next){
                if(i.data.rcode.compareTo(j.data.rcode)>0){
                    String temp= i.data.rcode;
                    i.data.rcode = j.data.rcode;
                    j.data.rcode = temp;
                }
            }
        }
    }

}


