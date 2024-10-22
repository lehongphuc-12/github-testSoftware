/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagementLending;

/**
 *
 * @author hoang
 */
public class Lending {
    String bcode;
    String rcode;
    int state;

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public String toString() {
        return bcode + " | " + rcode + " | " + state;
    }
}
