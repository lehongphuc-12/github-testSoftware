/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementReader;

/**
 *
 * @author hoang
 */
public class Reader {
    String rcode;
    String name;
    int byear;

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    public String toString() {
        return rcode + " | " + name + " | " + byear;
    }
}
