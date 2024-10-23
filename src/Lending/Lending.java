package Lending;
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
